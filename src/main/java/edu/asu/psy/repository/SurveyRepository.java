package edu.asu.psy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.asu.psy.models.Survey;

@Repository("surveyRepository")
public interface SurveyRepository extends JpaRepository<Survey, Integer>{

	public Survey findSurveyBySurveyId(int id);

}