package edu.asu.psy.models;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "survey_response_table")
public class SurveyResponse {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "survey_response_id")
	private int surveyResponseId;
	
	@Column(name = "survey_published_id")
	private int publishedSurveyId;
	
	@Column(name = "survey_id")
	private int surveyId;
	
	@Column(name = "user_id")
	private int userId;
	

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "survey_answer_table", joinColumns = @JoinColumn(name = "survey_response_id"), inverseJoinColumns = @JoinColumn(name = "answer_id"))
	private List<Answer> surveyAnswers;

	@Column(name = "submitted_date")
	private Timestamp submittedDate;
	
	public SurveyResponse()
	{
		submittedDate = new Timestamp(System.currentTimeMillis());
	}
	
	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	
	public int getSurveyResponseId() {
		return surveyResponseId;
	}
	public void setSurveyResponseId(int surveyResponseId) {
		this.surveyResponseId = surveyResponseId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Timestamp getSubmittedDate() {
		return submittedDate;
	}
	public void setSubmittedDate(Timestamp submittedDate) {
		this.submittedDate = submittedDate;
	}
	public List<Answer> getSurveyAnswers() {
		return surveyAnswers;
	}

	public void setSurveyAnswers(List<Answer> surveyAnswers) {
		this.surveyAnswers = surveyAnswers;
	}
	public int getPublishedSurveyId() {
		return publishedSurveyId;
	}
	public void setPublishedSurveyId(int publishedSurveyId) {
		this.publishedSurveyId = publishedSurveyId;
	}
	
	
}