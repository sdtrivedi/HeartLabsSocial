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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "survey_table")
public class Survey {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "survey_id")
	private int surveyId;
	
	@Column(name = "title")
	private String title;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "survey_questions", joinColumns = @JoinColumn(name = "survey_id"), inverseJoinColumns = @JoinColumn(name = "question_id"))
	private List<Question> questions;
	
	@Column(name = "created_at")
	private Timestamp createdAt;
	
	@Column(name = "updated_at")
	private Timestamp updatedAt;
	
	private Survey() {
		
		this.createdAt = new Timestamp(System.currentTimeMillis());
		this.updatedAt = new Timestamp(System.currentTimeMillis());
	}
	
	public String getTitle() {
		return title;
	}
	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

}
