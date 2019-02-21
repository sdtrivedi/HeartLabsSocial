package edu.asu.psy.models;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "published_survey_table")
public class PublishedSurvey {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "published_survey_id")
	private int id;
	
	@Column(name = "survey_id")
	private int surveyId;
	
	
	@Column(name = "ends_at")
	private Timestamp endsAt;
	
	@Column(name = "created_at")
	private Timestamp createdAt;
	
	@Column(name = "title")
	private String surveyTitle;
	
	@Column(name = "submission_count")
	private int submissionCount;
	
	@Column(name = "question_id")
	private int questionId;
	@Column(name = "question_val")
	private int questionVal;
	
	public PublishedSurvey() {
		
	}
	
	public PublishedSurvey(int surveyId,String surveyTitle,Timestamp endsAt) {
		// TODO Auto-generated constructor stub
		this.surveyId=surveyId;
		this.surveyTitle = surveyTitle;
		this.endsAt = endsAt;
		this.submissionCount =0 ;
		this.createdAt = new Timestamp(System.currentTimeMillis());
	}
	

	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	public String getSurveyTitle() {
		return surveyTitle;
	}
	public void setSurveyTitle(String surveyTitle) {
		this.surveyTitle = surveyTitle;
	}
	public int getSubmissionCount() {
		return submissionCount;
	}
	public void setSubmissionCount(int submissionCount) {
		this.submissionCount = submissionCount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getEndsAt() {
		return endsAt;
	}
	public void setEndsAt(Timestamp endsAt) {
		this.endsAt = endsAt;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getQuestionVal() {
		return questionVal;
	}

	public void setQuestionVal(int questionVal) {
		this.questionVal = questionVal;
	}
	
	
	
	
}
