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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "post_table")
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "post_id")
	private int postId;
	

	@Column(name = "video_link")
	private String videoLink;
	
	@Column(name = "post_content", columnDefinition="text")
	private String postContent;
	
	@Column(name = "timestamp")
	private Timestamp timestamp;
	
	@Column(name = "status")
	private int status;
	@Column(name = "isvideo")
	private int link;

	@ManyToOne
	private User postedBy;
	
	private String displayTime;
	public Post()
	{
		this.timestamp = new Timestamp(System.currentTimeMillis());
		this.status = 1;
		this.link = 1;
		this.displayTime = "1 month ago";
		
		
	}


	public String getDisplayTime() {
		return displayTime;
	}


	public void setDisplayTime(String displayTime) {
		this.displayTime = displayTime;
	}


	public int getLink() {
		return link;
	}

	public void setLink(int link) {
		this.link = link;
	}

	


	public User getPostedBy() {
		return postedBy;
	}


	public void setPostedBy(User postedBy) {
		this.postedBy = postedBy;
	}





	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}


	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
