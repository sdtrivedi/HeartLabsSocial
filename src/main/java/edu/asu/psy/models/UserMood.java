package edu.asu.psy.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "usermood")
public class UserMood {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "mood_title")
	private String moodTitle;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "timestamp")
	private Timestamp timestamp;
	
	@Column(name = "rating")
	private int rating;
	
	public UserMood()
	{		
	}
	
	public UserMood(String moodTitle,int rating)
	{
		this.moodTitle = moodTitle;
		this.rating = rating;
		this.timestamp = new Timestamp(System.currentTimeMillis());
	}
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMoodTitle() {
		return moodTitle;
	}

	public void setMoodTitle(String moodTitle) {
		this.moodTitle = moodTitle;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	
	
	
}
