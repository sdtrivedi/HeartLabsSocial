package edu.asu.psy.resources;



import java.sql.Timestamp;

import javax.validation.Valid;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import edu.asu.psy.service.UserService;

@SpringBootApplication
@RestController
public class LoginController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value={"/heart-lab","/"}, method = RequestMethod.GET)
	public ModelAndView landingPage(){
		
		// Landing Page View
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		User user = new User();
		modelAndView.addObject("user", user);
		return modelAndView;
	}
  
	@RequestMapping(value={"/heart-lab/mission"}, method = RequestMethod.GET)
	public ModelAndView missionPage(){
		
		// Mission Page View
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("mission");
		User user = new User();
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	
	@RequestMapping(value={"/heart-lab/team"}, method = RequestMethod.GET)
	public ModelAndView teamPage(){
		// Team Page View
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("team");
		User user = new User();
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	@RequestMapping(value={"/heart-lab/research"}, method = RequestMethod.GET)
	public ModelAndView researchPage(){
		// Research Page View
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("research");
		User user = new User();
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	@RequestMapping(value={"/heart-lab/participate"}, method = RequestMethod.GET)
	public ModelAndView participationPage(){
		
		// Participation Page View
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("participate");
		User user = new User();
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		
		// Registration Page View
		
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("index");
		modelAndView.addObject("page", "registration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		// Create User
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("page", "registration");
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("index");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("index");
			
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/getUserMood", method = RequestMethod.GET)
	public ModelAndView redirectToMood(){
		// Re
		User user = getCurrentUser();
		UserCredit userCredit = userService.findUserCreditByUserId(user.getId());
		if(userCredit==null)
		{
			userCredit = new UserCredit();
			userCredit.setUser(user);
			userCredit.setCredits(userCredit.getCredits()+1);
			userService.saveUserCredit(userCredit);
		}
		else
		{
		
			if(System.currentTimeMillis() - userCredit.getLastUpdatedDate().getTime()>60000 )
			{
				userCredit.setCredits(userCredit.getCredits()+1);
				userCredit.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
				userService.saveUserCredit(userCredit);
			}
		}
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user-mood");
		return modelAndView;
	
	}
	
	@RequestMapping(value="/dashboard", method = RequestMethod.GET)
	public ModelAndView dashboard(){
		
		// Redirect to homepage
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		String userRole = "";
		for(Role role: user.getRoles())
		{
			
			userRole+=role.getRole();
		}
	
		if(userRole.equalsIgnoreCase("admin"))
		{
			return new ModelAndView("redirect:/admin/home");
		}
		
		return new ModelAndView("redirect:/user/home");
		
		
	}
	public User getCurrentUser()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		User user = userService.findUserByEmail(auth.getName());
		return user;
	}
	@RequestMapping(value="/submitmood", method = RequestMethod.POST)
	public ModelAndView submitMood(@RequestParam("mood") String moodTitle, @RequestParam("rating") int rating){
	
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			
			UserMood userMood = new UserMood(moodTitle, rating);
			
			
			userService.saveUserMood(userMood, auth.getName());
			return new ModelAndView("redirect:/dashboard");
	}

}
