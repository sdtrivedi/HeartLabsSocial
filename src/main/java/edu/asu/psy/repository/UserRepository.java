package edu.asu.psy.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.asu.psy.models.User;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	
	 User findByEmail(String email);
	 
	 
	 @Query(value = "select * from user u \r\n" + 
	 		"inner join user_role ur on(u.user_id=ur.user_id) \r\n" + 
	 		"inner join role r on(ur.role_id=r.role_id) where role = 'USER'", nativeQuery = true)
	 List<User> findAllUsers();
	 
	 
	 @Query(value = "SELECT * FROM USER WHERE ACTIVE = 1", nativeQuery = true)
	 List<User> findAllActiveUsers();
	 
	 
	 @Transactional
	 @Modifying(clearAutomatically = true)
	 @Query(value = "update User u set u.active= :active where u.email = :email", nativeQuery = true)
	 public void updateUserActiveStatus(@Param("active") int active, @Param("email") String email);


	 public User findById(int userId);

	 @Query(value = "Select * from User as u where u.name like %:firstname% or u.last_name like %:lastname%", nativeQuery = true)
	 public List<User> findUsersByFirstAndLastName(@Param("firstname")String firstName, @Param("lastname") String lastName);
	
}
