package edu.asu.psy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.asu.psy.models.Post;
import edu.asu.psy.models.UserCredit;
@Repository("userCreditRepository")
public interface UserCreditRepository extends JpaRepository<UserCredit, Integer> {

	UserCredit findByUserId(int id);


}
