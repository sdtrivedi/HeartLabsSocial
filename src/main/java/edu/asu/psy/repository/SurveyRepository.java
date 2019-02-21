package edu.asu.psy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.asu.psy.models.Survey;

@Repository("surveyRepository")
public interface SurveyRepository extends JpaRepository<Survey, Integer>{

	public Survey findSurveyBySurveyIdAndStatus(int id, int status);
	
	public List<Survey> findSurveyByStatus(int status);

}