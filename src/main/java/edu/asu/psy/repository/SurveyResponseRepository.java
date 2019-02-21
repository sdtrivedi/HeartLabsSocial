package edu.asu.psy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.asu.psy.models.SurveyResponse;

@Repository("surveyResponseRepository")
public interface SurveyResponseRepository extends JpaRepository<SurveyResponse, Integer>{

	List<SurveyResponse> findSurveyResponseBySurveyId(int surveyId);

	List<SurveyResponse> findSurveyResponseByPublishedSurveyId(int publishId);

}