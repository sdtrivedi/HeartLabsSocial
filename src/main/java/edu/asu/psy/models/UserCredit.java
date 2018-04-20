package edu.asu.psy.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "credit_table")
public class UserCredit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "credit_id")
	private int id;

	@Column(name = "credits")
	private int credits;
	
	@Column(name = "lastUpdated")
	private Timestamp lastUpdatedDate;
	
	
	@OneToOne
	private User user;

	public UserCredit()
	{
		lastUpdatedDate =new Timestamp(System.currentTimeMillis());
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Timestamp getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
