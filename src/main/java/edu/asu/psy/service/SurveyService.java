package edu.asu.psy.service;

import java.util.List;

import edu.asu.psy.models.Answer;
import edu.asu.psy.models.Question;
import edu.asu.psy.models.Survey;
import edu.asu.psy.models.SurveyResponse;

public interface SurveyService {
public void saveSurvey(Survey survey);
	
	public void saveQuestion(Question question);
	
	public List<Survey> findAllSurveys();
	
	public Survey findSurvey(int id);
	
	public void saveSurveyResponse(SurveyResponse surveyResponse);
	
	public List<SurveyResponse> findSurveyResponse(int surveyId);
	
	public void saveAnswer(Answer answer);

}
