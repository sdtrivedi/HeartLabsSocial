package edu.asu.psy.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

import edu.asu.psy.models.Message;
import edu.asu.psy.models.Post;
import edu.asu.psy.models.Role;
import edu.asu.psy.models.Survey;
import edu.asu.psy.models.SurveyResponse;
import edu.asu.psy.models.User;
import edu.asu.psy.service.SurveyService;
import edu.asu.psy.service.UserService;
@SpringBootApplication
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private SurveyService surveyService;
	@GetMapping("/current_user")
	public User getCurrentUser()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		return user;
	}
	@GetMapping("/home")
	public ModelAndView userHomePage()
	{
		
		ModelAndView modelAndView = new ModelAndView();
		
		User user = getCurrentUser();
		
		modelAndView.addObject("currentUser", user);
		modelAndView.addObject("userCredit",  userService.findUserCreditByUserId(user.getId()));
		modelAndView.addObject("lastUserMood", userService.findUserMoodByid(user.getId()));
		modelAndView.addObject("viewname","newsfeed");
		modelAndView.addObject("recentPosts",  userService.retrieveRecentPosts(0, 20));
		List<Message> messages = userService.findByReceiverId(user.getId());
		modelAndView.addObject("messages",  messages);
		int unreadMessages = 0;
		for(Message  message : messages)
		{
			if(message.getStatus() ==1)
				unreadMessages++;
		}
		modelAndView.addObject("unreadMessages",unreadMessages);
		modelAndView.setViewName("user/home");
		
		return modelAndView;
	}
	@GetMapping("/profile")
	public ModelAndView profilePage()
	{
		ModelAndView modelAndView = new ModelAndView();
		User user = getCurrentUser();
	
		modelAndView.addObject("currentUser", user);
		modelAndView.addObject("userCredit",  userService.findUserCreditByUserId(user.getId()));
		modelAndView.setViewName("user/profile");
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
	@GetMapping("/announcement")
	public ModelAndView announcementPage()
	{
		ModelAndView modelAndView = new ModelAndView();
		User user = getCurrentUser();
		
		modelAndView.addObject("currentUser", user);
		modelAndView.addObject("previousAnnoucements", userService.findByReceiverId(user.getId()));
		modelAndView.setViewName("user/announcement");
		return modelAndView;
	}
	
	@GetMapping("/surveys")
	public ModelAndView surveyPage()
	{
		ModelAndView modelAndView = new ModelAndView();
		User user = getCurrentUser();
	
		Gson g = new Gson();
	
		String survey = g.toJson(surveyService.findSurvey(5)); 
		modelAndView.addObject("survey", survey);
		modelAndView.addObject("currentUser", user);
		
		modelAndView.setViewName("user/surveys");
		return modelAndView;
	}
	
	@PostMapping("/submitmood")
	public User submitCurrentMood()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		return user;
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
			post.setVideoLink(videoLink);
			post.setPostContent(postContent);
			post.setPostedBy(new User(userId));
			
			userService.savePost(post);;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		return userHomePage();
	}
	
	@RequestMapping(value="/savesurveyresponse", method = RequestMethod.POST)
	public void saveSurveyResponse(@RequestParam("response") String response)
	{
		System.out.println("......."+response);
		Gson g = new Gson();
		SurveyResponse s = g.fromJson(response, SurveyResponse.class);
		s.setUserId(getCurrentUser().getId());
		surveyService.saveSurveyResponse(s);
		System.out.println(g.toJson(s));
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
		return userHomePage();
	}
	@RequestMapping(value="/readnotification", method = RequestMethod.POST)
	public ModelAndView updateNotificationStatus(@RequestParam("id") int id)
	{
		System.out.println("......."+id);
		Message message = userService.findByMessageId(id);
		message.setStatus(2);
		userService.sendMessage(message);
		return userHomePage();
	}
}
