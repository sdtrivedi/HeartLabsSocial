package edu.asu.psy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.asu.psy.models.Answer;
@Repository("answerRepository")
public interface AnswerRepository extends JpaRepository<Answer, Integer>{

}
