package edu.asu.psy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.asu.psy.models.Answer;
import edu.asu.psy.models.Question;
import edu.asu.psy.models.Survey;
import edu.asu.psy.models.SurveyResponse;
import edu.asu.psy.repository.AnswerRepository;
import edu.asu.psy.repository.QuestionRepository;
import edu.asu.psy.repository.SurveyRepository;
import edu.asu.psy.repository.SurveyResponseRepository;
@Service("surveyService")
public class SurveyServiceImpl implements SurveyService{
	
	@Autowired
    private SurveyRepository surveyRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private SurveyResponseRepository surveyResponseRepository;
    @Autowired
    private AnswerRepository answerRepository;
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

	@Override
	public void saveSurveyResponse(SurveyResponse surveyResponse) {
		// TODO Auto-generated method stub
		
		surveyResponseRepository.save(surveyResponse);
		
	}
	@Override
	public void saveAnswer(Answer answer)
	{
		answerRepository.save(answer);
	}

	@Override
	public List<SurveyResponse> findSurveyResponse(int surveyId) {
		// TODO Auto-generated method stub
		return surveyResponseRepository.findSurveyResponseBySurveyId(surveyId);
	}

}
