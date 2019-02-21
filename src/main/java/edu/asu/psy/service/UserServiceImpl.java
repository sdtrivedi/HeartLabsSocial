package edu.asu.psy.service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.asu.psy.models.Message;
import edu.asu.psy.models.Post;
import edu.asu.psy.models.Question;
import edu.asu.psy.models.Role;
import edu.asu.psy.models.Survey;
import edu.asu.psy.models.User;
import edu.asu.psy.models.UserCredit;
import edu.asu.psy.models.UserMood;
import edu.asu.psy.repository.UserMoodRepository;
import edu.asu.psy.repository.MessageRepository;
import edu.asu.psy.repository.PostRepository;
import edu.asu.psy.repository.QuestionRepository;
import edu.asu.psy.repository.RoleRepository;
import edu.asu.psy.repository.SurveyRepository;
import edu.asu.psy.repository.UserCreditRepository;
import edu.asu.psy.repository.UserRepository;



@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMoodRepository userMoodRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
	@Autowired
    private UserCreditRepository userCreditRepository;
    
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public User findUserByEmail(String email) {
		
		User user = userRepository.findByEmail(email);
		
		/*if(user!=null)
			user.setPassword("");*/
		return user;
	}

	@Override
	public void saveUser(User user) {
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(Arrays.asList(userRole));
		userRepository.save(user);
		
	}
	@Override
	public void updateUser(User user) {
	
		
		userRepository.updateUserActiveStatus(user.getActive(), user.getEmail());
		
		
		
	}
	@Override
	public List<User> getAllUsers() {
		
		// TODO Auto-generated method stub	
		return userRepository.findAllUsers();
	}

	@Override
	public List<User> getAllActiveUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAllActiveUsers();
	}

	
	@Override
	public void saveUserMood(UserMood userMood,String email) {
		// TODO Auto-generated method stub
		
		User user = userRepository.findByEmail(email);
		userMood.setUserId(user.getId());
		userMoodRepository.save(userMood);
	
		
	}
	
	@Override
	public List<UserMood> findUserMoodsByUserId(int userId) {
		// TODO Auto-generated method stub
		return userMoodRepository.findUserMoodsByUserId(userId);
	}

	@Override
	public User findUserById(int userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId);
	}

	@Override
	public UserMood findUserMoodByid(int userId) {
		// TODO Auto-generated method stub
		return userMoodRepository.findUserMoodByUserId(userId);
	}

	@Override
	public List<User> findUserByName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return userRepository.findUsersByFirstAndLastName(firstName, lastName);
	}

	
	@Override
	public void saveUserCredit(UserCredit userCredit) {
		// TODO Auto-generated method stub
		
		userCreditRepository.save(userCredit);
		
	}

	@Override
	public void updateUserCredit(UserCredit userCredit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserCredit findUserCreditByUserId(int id) {
		// TODO Auto-generated method stub
		return userCreditRepository.findByUserId(id);
	}


}
