package edu.asu.psy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.asu.psy.models.UserMood;


@Repository("userMoodRepository")
public interface UserMoodRepository extends JpaRepository<UserMood, Long>{
	
	@Query(value = "SELECT * FROM USERMOOD as u where u.user_id = :userid ORDER BY u.timestamp DESC LIMIT 10", nativeQuery = true)
	List<UserMood> findUserMoodsByUserId(@Param("userid") int userId);
	
	@Query(value = "SELECT * FROM USERMOOD as u where u.user_id = :userid ORDER BY u.timestamp DESC LIMIT 1", nativeQuery = true)
	UserMood findUserMoodByUserId(@Param("userid") int userId);
}
