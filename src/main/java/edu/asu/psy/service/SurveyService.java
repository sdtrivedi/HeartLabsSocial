package edu.asu.psy.service;

import java.util.List;

import edu.asu.psy.models.Question;
import edu.asu.psy.models.Survey;

public interface SurveyService {
public void saveSurvey(Survey survey);
	
	public void saveQuestion(Question question);
	
	public List<Survey> findAllSurveys();
	
	public Survey findSurvey(int id);

}
