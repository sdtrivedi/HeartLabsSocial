package edu.asu.psy.resources;


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
import edu.asu.psy.models.PublishedSurvey;
import edu.asu.psy.models.Role;
import edu.asu.psy.models.Survey;
import edu.asu.psy.models.SurveyResponse;
import edu.asu.psy.models.User;
import edu.asu.psy.service.PostAndMessageService;
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
	@Autowired
    private PostAndMessageService postAndMessageService;
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
		
		List<PublishedSurvey> completed = surveyService.findCompletedAllPublishedSurveys(user.getId());
		List<PublishedSurvey> total = surveyService.findAllCurrentPublishedSurveys();
		
		total.removeAll(completed);
		modelAndView.addObject("publishedSurveys", total);
		modelAndView.addObject("currentUser", user);
		modelAndView.addObject("userCredit",  userService.findUserCreditByUserId(user.getId()));
		modelAndView.addObject("lastUserMood", userService.findUserMoodByid(user.getId()));
		modelAndView.addObject("viewname","newsfeed");
		modelAndView.addObject("recentPosts",  postAndMessageService.retrieveRecentPosts(0, 20));
		List<Message> messages = postAndMessageService.findByReceiverId(user.getId());
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
		modelAndView.addObject("previousAnnoucements", postAndMessageService.findByReceiverId(user.getId()));
		modelAndView.setViewName("user/announcement");
		return modelAndView;
	}
	
	
	@GetMapping("/takesurvey")
	public ModelAndView surveyPage(@RequestParam("publishedSurveyId") int publishedSurveyId)
	{
		ModelAndView modelAndView = new ModelAndView();
		User user = getCurrentUser();
	    
		PublishedSurvey publishedSurvey = surveyService.findPublishedById(publishedSurveyId);
		String survey = new Gson().toJson(surveyService.findSurvey(publishedSurvey.getSurveyId())); 
		modelAndView.addObject("publishedSurveyId", publishedSurveyId);
		modelAndView.addObject("publishedSurvey", publishedSurvey);
		modelAndView.addObject("survey", survey);
		modelAndView.addObject("currentUser", user);
		
		modelAndView.setViewName("user/surveys");
		return modelAndView;
	}
	
	@PostMapping("/submitmood")
	public User submitCurrentMood()
	{
		// Store Current Mood
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		User user = userService.findUserByEmail(auth.getName());
		
		return user;
	}
	
	@RequestMapping(value="/sumbitPost", method = RequestMethod.POST)
	public ModelAndView submitPost(@RequestParam("userid") int userId, @RequestParam("video_link") String videoLink, @RequestParam("message") String postContent )
	{
		// Submit Post
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
			
			postAndMessageService.savePost(post);;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		return userHomePage();
	}
	
	@RequestMapping(value="/savesurveyresponse", method = RequestMethod.POST)
	public void saveSurveyResponse(@RequestParam("response") String response,@RequestParam("publishedSurveyId") int publishedSurveyId)
	{
		// Save Survey Response
		
		SurveyResponse surveyResponses = new Gson().fromJson(response, SurveyResponse.class);
		surveyResponses.setPublishedSurveyId(publishedSurveyId);
		surveyResponses.setUserId(getCurrentUser().getId());
		surveyService.saveSurveyResponse(surveyResponses);
		
		PublishedSurvey publishedSurvey = surveyService.findPublishedById(publishedSurveyId);
		publishedSurvey.setSubmissionCount(publishedSurvey.getSubmissionCount()+1);
		surveyService.savePublishedSurvey(publishedSurvey);
		
		
	}
	@RequestMapping(value="/submitWatchedCount", method = RequestMethod.POST)
	public void submitWatchedCount(@RequestParam("id") int id)
	{
		// To Do 
		// Store video count
		System.out.println("......."+id);
	}
	@RequestMapping(value="/deletePost", method = RequestMethod.GET)
	public ModelAndView deletePost(@RequestParam("postid") int postId)
	{
		// Delete post 
		
		postAndMessageService.deletePost(postId);
		
		return userHomePage();
	}
	@RequestMapping(value="/readnotification", method = RequestMethod.POST)
	public ModelAndView updateNotificationStatus(@RequestParam("id") int id)
	{
		// Update Message Status
		
		Message message = postAndMessageService.findByMessageId(id);
		
		message.setStatus(2);
		
		postAndMessageService.sendMessage(message);
		
		return userHomePage();
	}
}
