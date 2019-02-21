package edu.asu.psy.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.asu.psy.models.Answer;
import edu.asu.psy.models.PublishedSurvey;
import edu.asu.psy.models.Question;
import edu.asu.psy.models.Survey;
import edu.asu.psy.models.SurveyResponse;
import edu.asu.psy.repository.AnswerRepository;
import edu.asu.psy.repository.PublishedSurveyRepository;
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
    @Autowired
    private PublishedSurveyRepository publishedSurveyRepository;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
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
		return surveyRepository.findSurveyByStatus(0);
	}

	@Override
	public Survey findSurvey(int id) {
		// TODO Auto-generated method stub
		return surveyRepository.findSurveyBySurveyIdAndStatus(id,0);
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

	@Override
	public void deleteSurvey(int id) {
		// TODO Auto-generated method stub
		Survey survey = findSurvey(id);
		survey.setStatus(1);
		surveyRepository.save(survey);
	}

	@Override
	public void savePublishedSurvey(PublishedSurvey publishedSurvey) {
		// TODO Auto-generated method stub
		publishedSurveyRepository.save(publishedSurvey);
		
	}

	@Override
	public List<PublishedSurvey> findAllCurrentPublishedSurveys() {
		// TODO Auto-generated method stub
		return publishedSurveyRepository.findAllCurrentPublishedSurveys(simpleDateFormat.format(new Timestamp(System.currentTimeMillis())));
	}
	
	@Override
	public List<PublishedSurvey> findAllOldPublishedSurveys() {
		// TODO Auto-generated method stub
		return publishedSurveyRepository.findAllOldPublishedSurveys(simpleDateFormat.format(new Timestamp(System.currentTimeMillis())));
	}


	@Override
	public PublishedSurvey findPublishedById(int id) {
		// TODO Auto-generated method stub
		return publishedSurveyRepository.findPublishedSurveyById(id);
	}

	@Override
	public List<PublishedSurvey> findCompletedAllPublishedSurveys(int userId) {
		// TODO Auto-generated method stub
		return publishedSurveyRepository.findAllCompletedSurveys(userId);
	}

	@Override
	public List<SurveyResponse> findSurveyResponseByPublishId(int publishId) {
		// TODO Auto-generated method stub
		return surveyResponseRepository.findSurveyResponseByPublishedSurveyId(publishId);
	}

}
