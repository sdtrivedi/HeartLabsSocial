package edu.asu.psy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.asu.psy.models.Question;
import edu.asu.psy.models.Survey;
import edu.asu.psy.repository.QuestionRepository;
import edu.asu.psy.repository.SurveyRepository;
@Service("surveyService")
public class SurveyServiceImpl implements SurveyService{
	
	@Autowired
    private SurveyRepository surveyRepository;
    @Autowired
    private QuestionRepository questionRepository;
	@Override
	public void saveSurvey(Survey survey) {
		// TODO Auto-generated method stub
		
		surveyRepository.save(survey);
		
	}

	@Override
	public void saveQuestion(Question question) {
		// TODO Auto-generated method stub
		questionRepository.save(question);
		
	}

	@Override
	public List<Survey> findAllSurveys() {
		// TODO Auto-generated method stub
		return surveyRepository.findAll();
	}

	@Override
	public Survey findSurvey(int id) {
		// TODO Auto-generated method stub
		return surveyRepository.findSurveyBySurveyId(id);
	}

}
