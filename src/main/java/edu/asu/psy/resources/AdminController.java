package edu.asu.psy.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import edu.asu.psy.models.Survey;
import edu.asu.psy.models.SurveyResponse;
import edu.asu.psy.models.UserCredit;
import edu.asu.psy.models.UserMood;
import edu.asu.psy.models.Answer;
import edu.asu.psy.models.Message;
import edu.asu.psy.models.Post;
import edu.asu.psy.models.PublishedSurvey;
import edu.asu.psy.service.PostAndMessageService;
import edu.asu.psy.service.SurveyService;
import edu.asu.psy.service.UserService;

@SpringBootApplication
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService userService;
	@Autowired
	private SurveyService surveyService;
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
    private PostAndMessageService postAndMessageService;

	@GetMapping("/home")
	public ModelAndView adminHomePage()
	{
		// HomePage View
		
		ModelAndView modelAndView = new ModelAndView();
		
		User user = getCurrentUser();
		
		modelAndView.addObject("currentUser", user);
		
		List<Post> last20 = postAndMessageService.retrieveRecentPosts(0, 20);
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
		// Fetch announcements
		ModelAndView modelAndView = new ModelAndView();
		User user = getCurrentUser();
		
		modelAndView.addObject("currentUser", user);
		modelAndView.addObject("previousAnnoucements", postAndMessageService.findBySenderId(user.getId()));
		modelAndView.setViewName("admin/announcement");
		return modelAndView;
	}
	@GetMapping("/profile")
	public ModelAndView profilePage()
	{
		// Profile Page View
		
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
		// Updated Profile View
	
		User user = getCurrentUser();
		user.setName(currentUser.getName());
		user.setLastName(currentUser.getLastName());
		
		userService.saveUser(user);
		
		return profilePage();
	}
	
	@RequestMapping(value="/surveyresponsedetails", method = RequestMethod.GET)
	public ModelAndView SurveyResponsePage(@RequestParam("publishId") int publishId)
	{
		// Survey Response View Page
		
		ModelAndView modelAndView = new ModelAndView();
		User currentUser = getCurrentUser();
	
		List<SurveyResponse> surveyResponses = surveyService.findSurveyResponseByPublishId(publishId);
		
		Map<String, SurveyResponse> map = new HashMap<String, SurveyResponse>();
		
		boolean flag = true;
		for(SurveyResponse surveyResponse:surveyResponses )
		{
			
			int userId = surveyResponse.getUserId();
			User user = userService.findUserById(userId);
			String name = user.getName()+" "+user.getLastName();
			if(flag)
			{
				map.put("th", surveyResponse);
				flag = false;
			}
			map.put(name, surveyResponse);
		}
		
		modelAndView.addObject("publishedSurveyId", publishId);
		modelAndView.addObject("currentUser", currentUser);
		modelAndView.addObject("userCredit",  userService.findUserCreditByUserId(currentUser.getId()));
		modelAndView.addObject("surveyResponses",map);
		modelAndView.setViewName("admin/surveyresponse");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/userdetailcsv", method = RequestMethod.GET)
	public void downloadUserDetailCSVFile(HttpServletResponse response){
		String csvFileName = "userList.csv";
		response.setContentType("text/csv");
		String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                csvFileName);
        response.setHeader(headerKey, headerValue);
        try{
			List <User> users = userService.getAllUsers();
			response.getWriter().write("FirstName,");
			response.getWriter().write("LastName,");
			response.getWriter().write("Email,\n");
			for(User user:users){
				
				response.getWriter().write(user.getName()+ ",");
				response.getWriter().write(user.getLastName() + ",");
				response.getWriter().write(user.getEmail() + ",\n");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
	        
	           
            try {
				response.getWriter().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
	}
	
	@RequestMapping(value="/surveyresponsedetailscsv", method = RequestMethod.GET)
	public  void downloadSurveyResponseCSVFile(@RequestParam("publishId") int publishId,HttpServletResponse response) throws FileNotFoundException
	{
	
		Survey publishedSurvey = surveyService.findSurvey(surveyService.findPublishedById(publishId).getSurveyId());
		response.setHeader("Content-Disposition","attachment; filename="+publishedSurvey.getTitle()+".csv");
        try {
        	
        	
        	
        	List<SurveyResponse> surveyResponses = surveyService.findSurveyResponseByPublishId(publishId);
    		
        	boolean flag = true;
        	String answers = "";
    		for(SurveyResponse surveyResponse:surveyResponses )
    		{ 
    		
    			if(flag)
    			{
    				String columns ="Full Name,";
    				for(Answer ans: surveyResponse.getSurveyAnswers())
        			{
        				
    					columns+= ans.getQuestion().getQuestion()+",";
        			}
    				flag = false;
    				columns+="\n";
					response.getWriter().write(columns);
    			}	
    			int userId = surveyResponse.getUserId();
    			User user = userService.findUserById(userId);
    			String name = user.getName()+" "+user.getLastName();
    			
    			answers = name+",";
    			for(Answer ans: surveyResponse.getSurveyAnswers())
    			{
    				
    				answers+= ans.getResponse()+" ,";
    			}
    			answers+="\n";
    			response.getWriter().write(answers);
    		
        	
    		} 
        }catch(Exception e)
        {
        	e.printStackTrace();
        }
        finally {
        
           
                try {
					response.getWriter().close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }
		
	}
	@GetMapping("/surveys")
	public ModelAndView surveyPage()
	{
		// Survey View
		
		ModelAndView modelAndView = new ModelAndView();
		User user = getCurrentUser();
	
		
		List<Survey> surveys = surveyService.findAllSurveys();
		
		System.out.println(new Gson().toJson(surveyService.findSurveyResponse(5)));
		
		Collections.reverse(surveys);
		
		modelAndView.addObject("currentPublishedSurveys", surveyService.findAllCurrentPublishedSurveys());
		modelAndView.addObject("oldPublishedSurveys", surveyService.findAllOldPublishedSurveys());
		
		modelAndView.addObject("surveys", surveys);
		modelAndView.addObject("currentUser", user);
		modelAndView.addObject("userCredit",  userService.findUserCreditByUserId(user.getId()));
		modelAndView.setViewName("admin/surveys");
		return modelAndView;
	}
	@PostMapping("/savesurvey")
	public ModelAndView saveSurvey(@RequestParam("survey") String surveyString)
	{
		// Save survey
		
		try {
		
		Gson gson = new Gson();
		Survey survey = gson.fromJson(surveyString, Survey.class);
		survey.setStatus(0);
		
		surveyService.saveSurvey(survey);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return surveyPage();
	}
	@PostMapping("/deletesurvey")
	public void deleteSurvey(@RequestParam("surveyId") int surveyId)
	{
		// Delete existing Survey
		surveyService.deleteSurvey(surveyId);
	
	}
	@PostMapping("/publishsurvey")
	public void publishSurvey(@RequestParam("surveyId") int surveyId,@RequestParam("endDate") String endDate, @RequestParam("questionId") int questionId, @RequestParam("questionVal") int questionVal)
	{
		// Publish Survey
	
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
		Date date;
		try {
			date = simpleDateFormat.parse(endDate);	
			PublishedSurvey p = new PublishedSurvey(surveyId,surveyService.findSurvey(surveyId).getTitle(), new java.sql.Timestamp(date.getTime()));
			p.setQuestionId(questionId);
			p.setQuestionVal(questionVal);
			surveyService.savePublishedSurvey(p);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
	}
	@GetMapping("/fetchsurvey")
	public String fetchSurvey(@RequestParam("id") int id)
	{
		// Fetch Survey
		Gson g = new Gson();
		System.out.println(g.toJson(surveyService.findSurvey(id)));
		return g.toJson(surveyService.findSurvey(id));
	}
	@GetMapping("/getmood")
	public List<UserMood> getMood()
	{
		// Get Usermood
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		User user = userService.findUserByEmail(auth.getName());
			
		return userService.findUserMoodsByUserId(user.getId());
	}
	@GetMapping("/current_user")
	public User getCurrentUser()
	{
		// Get Current user object
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		User user = userService.findUserByEmail(auth.getName());
		return user;
	}
	@GetMapping("/getUser")
	public ModelAndView getUser(@RequestParam("userid") int userId)
	{
		// Get User Object
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
		// Activate/ Deactivate User
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
		// List all users
		
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
		// Save Personal message or announcement
		try {
		if(receiverId ==-1)
		{
			List<User> activeUsers = userService.getAllActiveUsers();
			Message msg = new Message();
			msg.setReceivers(activeUsers);
			msg.setSender(new User(senderId));
			msg.setMessageContent(message);
			msg.setType(1);
			postAndMessageService.sendMessage(msg);
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
			postAndMessageService.sendMessage(msg);
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return getAllUsers();
	}
	
	@RequestMapping(value="/sumbitPost", method = RequestMethod.POST)
	public ModelAndView submitPost(@RequestParam("userid") int userId, @RequestParam("video_link") String videoLink, @RequestParam("message") String postContent )
	{
		// Save Post
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
		
		
		postAndMessageService.savePost(post);;
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
		// Delete Post
		
		postAndMessageService.deletePost(postId);
		return adminHomePage();
	}
	
	@RequestMapping(value="/updatePassword", method = RequestMethod.POST)
	public String updatePassword(@RequestParam("currPass") String currPass, @RequestParam("newPass") String newPass)
	{
		// Update Password 
		String response = "";
		try {
		User currentUser = getCurrentUser();
		System.out.println(currPass+","+newPass);
		System.out.println(currentUser.getPassword());
		System.out.println(bCryptPasswordEncoder.encode(currPass.trim()));
		System.out.println(bCryptPasswordEncoder.encode(currPass.trim()));
		
		if(bCryptPasswordEncoder.matches(currPass, currentUser.getPassword())) {
			String encrpytNewPass = bCryptPasswordEncoder.encode(newPass);
			currentUser.setPassword(encrpytNewPass);
			userService.saveUser(currentUser);
			response = "{\"status\":\"Update Success\"}";
		}
		else {
			response = "{\"status\":\"Current password not correct\"}";
		}
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return response;
	}

}
