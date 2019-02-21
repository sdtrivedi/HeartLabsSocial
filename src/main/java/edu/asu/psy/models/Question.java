package edu.asu.psy.models;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
@Table(name = "question_table")
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "question_id")
	private int questionId;
	
	@Column(name = "id")
	private int id;
	
	@Column(name = "question")
	private String question;
	
	 @ElementCollection(fetch = FetchType.LAZY)
	    @CollectionTable(name = "question_options_table", joinColumns = @JoinColumn(name = "question_id"))
	    @AttributeOverrides({
	            @AttributeOverride(name = "id", column = @Column(name = "option_id")),
	            @AttributeOverride(name = "content", column = @Column(name = "option_content"))
	    })
	private List<Option> options;
	
	@Column(name = "type")
	private int type;
	
	private Question()
	{
		
	}
	
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<Option> getOptions() {
		return options;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

}
