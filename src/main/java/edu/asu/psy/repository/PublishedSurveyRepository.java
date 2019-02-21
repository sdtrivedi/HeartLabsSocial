package edu.asu.psy.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.asu.psy.models.PublishedSurvey;;

public interface PublishedSurveyRepository extends JpaRepository<PublishedSurvey, Integer> {

	public PublishedSurvey findPublishedSurveyById(int id);

	@Query(value = "SELECT * FROM published_survey_table as t INNER JOIN survey_response_table as r ON t.published_survey_id = r.survey_published_id and r.user_id = :userid", nativeQuery = true)
	public List<PublishedSurvey> findAllCompletedSurveys(@Param("userid") int userId);

	@Query(value = "SELECT * FROM published_survey_table as t where t.ends_at >= :curr_date", nativeQuery = true)
	public List<PublishedSurvey> findAllCurrentPublishedSurveys(@Param("curr_date") String curr);
	
	@Query(value = "SELECT * FROM published_survey_table as t where t.ends_at < :curr_date", nativeQuery = true)
	public List<PublishedSurvey> findAllOldPublishedSurveys(@Param("curr_date") String curr);

}
