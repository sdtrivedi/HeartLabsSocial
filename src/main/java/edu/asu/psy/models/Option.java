package edu.asu.psy.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
//@Entity
//(name = "survey_questions_options")
@Embeddable
public class Option {

	//@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name = "option_id")
	//private int optionId;
	@NotNull
	private int id;


	//@Column(name = "content")
	@NotNull
	private String content;

	
	
	public Option() {}
	/*public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}
*/
	
	public String getContent() {
		return content;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
	
}
