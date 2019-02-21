package edu.asu.psy.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "answer_table")
public class Answer{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "answer_id")
	private int answerId;
	
	@OneToOne
	private Question question;
	
	@Column(name = "response")
	private String response;
	
	
	public void setQuestion(Question question) {
		this.question = question;
	}
	public String getResponse() {
		return response;
	}
	
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public Question getQuestion() {
		return question;
	}
	
}
