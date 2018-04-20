package edu.asu.psy.resources;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import edu.asu.psy.models.Role;
import edu.asu.psy.models.User;
import edu.asu.psy.models.UserCredit;
import edu.asu.psy.models.UserMood;
import edu.asu.psy.models.Message;
import edu.asu.psy.models.Post;
import edu.asu.psy.service.UserService;

@SpringBootApplication
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService userService;
	

	@GetMapping("/home")
	public ModelAndView adminHomePage()
	{
		
		ModelAndView modelAndView = new ModelAndView();
		
		User user = getCurrentUser();
		
		modelAndView.addObject("currentUser", user);
		
		List<Post> last20 = userService.retrieveRecentPosts(0, 20);
/*		for(int i =0; i< last20.size(); i++)
		{
			int userId = last20.get(i).getUserId();
			last20.get(i).setUser(userService.findUserById(userId));
		}*/
		
		modelAndView.addObject("userCredit",  userService.findUserCreditByUserId(user.getId()));
		modelAndView.addObject("lastUserMood", userService.findUserMoodByid(user.getId()));
		modelAndView.addObject("userCredit",  userService.findUserCreditByUserId(user.getId()));
		modelAndView.addObject("viewname","newsfeed");
		modelAndView.setViewName("admin/home");
		modelAndView.addObject("recentPosts", last20 );
		
		return modelAndView;
	}
	
	@GetMapping("/announcement")
	public ModelAndView announcementPage()
	{
		ModelAndView modelAndView = new ModelAndView();
		User user = getCurrentUser();
		
		modelAndView.addObject("currentUser", user);
		modelAndView.addObject("previousAnnoucements", userService.findBySenderId(user.getId()));
		modelAndView.setViewName("admin/announcement");
		return modelAndView;
	}
	@GetMapping("/profile")
	public ModelAndView profilePage()
	{
		ModelAndView modelAndView = new ModelAndView();
		User user = getCurrentUser();
	
		modelAndView.addObject("currentUser", user);
		modelAndView.addObject("userCredit",  userService.findUserCreditByUserId(user.getId()));
		modelAndView.setViewName("admin/profile");
		return modelAndView;
	}
	@RequestMapping(value="/profile", method = RequestMethod.POST)
	public ModelAndView updateProfile(User currentUser)
	{
		
	
		User user = getCurrentUser();
		user.setName(currentUser.getName());
		user.setLastName(currentUser.getLastName());
		
		userService.saveUser(user);
		
		return profilePage();
	}
	@GetMapping("/getmood")
	public List<UserMood> getMood()
	{
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		User user = userService.findUserByEmail(auth.getName());
			
		return userService.findUserMoodsByUserId(user.getId());
	}
	@GetMapping("/current_user")
	public User getCurrentUser()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		User user = userService.findUserByEmail(auth.getName());
		return user;
	}
	@GetMapping("/getUser")
	public ModelAndView getUser(@RequestParam("userid") int userId)
	{
		ModelAndView modelAndView = new ModelAndView();
		User currentUser = getCurrentUser();
		modelAndView.addObject("currentUser", currentUser);
		
		if(userId==0)
			return null;
		User user = userService.findUserById(userId);
		
		modelAndView.addObject("viewname","userprofile");
		modelAndView.addObject("userObject", user);
		modelAndView.addObject("lastTenMoods", userService.findUserMoodsByUserId(user.getId()));
		modelAndView.addObject("lastUserMood", userService.findUserMoodByid(currentUser.getId()));
		modelAndView.setViewName("admin/all-users");
		return modelAndView;
	}
	
	@GetMapping("/activateUser")
	public ModelAndView updateUser(@RequestParam("username") String username,@RequestParam("active") int active)
	{
		
		ModelAndView modelAndView = new ModelAndView();
		try {
		User currentUser = getCurrentUser();
		modelAndView.addObject("currentUser", currentUser);
		User user = null;
        if(username!=null)
        {
        	user = userService.findUserByEmail(username);
    		user.setActive(active);
    		
    		userService.updateUser(user);
    		user = userService.findUserByEmail(username);
        }

		modelAndView.addObject("viewname","userprofile");
		modelAndView.addObject("userObject", user);
		modelAndView.addObject("lastTenMoods", userService.findUserMoodsByUserId(user.getId()));
		modelAndView.addObject("lastUserMood", userService.findUserMoodByid(currentUser.getId()));
		modelAndView.setViewName("admin/all-users");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return modelAndView;
		
	}
	
	
	@GetMapping("/all_users")
	public ModelAndView getAllUsers()
	{
		ModelAndView modelAndView = new ModelAndView();
		User user = getCurrentUser();
		modelAndView.addObject("currentUser", user);
		modelAndView.addObject("lastUserMood", userService.findUserMoodByid(user.getId()));
		
		modelAndView.addObject("users",  userService.getAllUsers());
		modelAndView.addObject("viewname","users");
		modelAndView.setViewName("admin/all-users");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/sendMessage", method = RequestMethod.POST)
	public ModelAndView sendMessage(@RequestParam("senderid") int senderId, @RequestParam("receiverid") int receiverId, @RequestParam("message") String message )
	{
		try {
		if(receiverId ==-1)
		{
			List<User> activeUsers = userService.getAllActiveUsers();
			Message msg = new Message();
			msg.setReceivers(activeUsers);
			msg.setSender(new User(senderId));
			msg.setMessageContent(message);
			msg.setType(1);
			userService.sendMessage(msg);
			Gson gson = new Gson();
			System.out.println(gson.toJson(msg));
			return announcementPage();
		}
		else
		{
			List<User> activeUsers = new ArrayList<User>();
			activeUsers.add(userService.findUserById(receiverId));
			Message msg = new Message();
			msg.setReceivers(activeUsers);
			msg.setSender(new User(senderId));
			msg.setMessageContent(message);
			msg.setType(2);
			
			Gson gson = new Gson();
			System.out.println(gson.toJson(msg));
			userService.sendMessage(msg);
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(senderId+" "+receiverId+" "+message);
		return getAllUsers();
	}
	
	@RequestMapping(value="/sumbitPost", method = RequestMethod.POST)
	public ModelAndView submitPost(@RequestParam("userid") int userId, @RequestParam("video_link") String videoLink, @RequestParam("message") String postContent )
	{
		try {
		Post post = new Post();
		if(videoLink!=null && videoLink.length()!=0)
		{
			if(videoLink.contains("youtube"))
			{
				
				String str=videoLink;
				String strs[] = str.split("//?");
				String videoId = strs[2].split("=")[1];
				videoLink = "<iframe width=\"450\" height=\"250\" src=\"https://www.youtube.com/embed/"+videoId+"\"></iframe>";
				post.setLink(2);
			
			}
			else
			{
				
				videoLink = "<a href=\""+videoLink+"\" target=\"_blank\"> Go to the link</a>";
			}

			
		}
		
		
		post.setVideoLink(videoLink);
		post.setPostContent(postContent);
		post.setPostedBy(new User(userId));
		
		
		userService.savePost(post);;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return adminHomePage();
	}
	@RequestMapping(value="/submitWatchedCount", method = RequestMethod.POST)
	public void submitWatchedCount(@RequestParam("id") int id)
	{
		System.out.println("......."+id);
	}
	@RequestMapping(value="/deletePost", method = RequestMethod.GET)
	public ModelAndView deletePost(@RequestParam("postid") int postId)
	{
		System.out.println("......."+postId);
		userService.deletePost(postId);
		return adminHomePage();
	}
	

}
