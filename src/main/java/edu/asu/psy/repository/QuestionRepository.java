package edu.asu.psy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.asu.psy.models.Question;



@Repository("questionRepository")
public interface QuestionRepository extends JpaRepository<Question, Integer>{
	
}