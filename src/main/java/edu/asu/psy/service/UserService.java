package edu.asu.psy.service;

import java.util.List;

import edu.asu.psy.models.Message;
import edu.asu.psy.models.Post;
import edu.asu.psy.models.Question;
import edu.asu.psy.models.Survey;
import edu.asu.psy.models.User;
import edu.asu.psy.models.UserCredit;
import edu.asu.psy.models.UserMood;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
	public List<User> getAllUsers();
	public List<User> getAllActiveUsers();
	public List<User> findUserByName(String firstName, String lastName);
	public void updateUser(User user);
	
	public User findUserById(int userId);	
	
	public void saveUserMood(UserMood userMood,String email);
	public List<UserMood> findUserMoodsByUserId(int userId);
	public UserMood findUserMoodByid(int userId);
	
	public void saveUserCredit(UserCredit userCredit);
	public void updateUserCredit(UserCredit userCredit);
	public UserCredit findUserCreditByUserId(int id);
	
	
	
}
