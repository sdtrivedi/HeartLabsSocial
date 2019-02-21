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
@Table(name = "message_table")
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "message_id")
	private int messageId;
	
	@ManyToOne
	private User sender;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "message_receiver", joinColumns = @JoinColumn(name = "message_id"))
	private List<User> receivers;
	
	@Column(name = "message_content")
	private String messageContent;
	
	@Column(name = "sent_timestamp")
	private Timestamp sentTimeStamp;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "type")
	private int type;
	
	
	public Message()
	{
		this.sentTimeStamp = new Timestamp(System.currentTimeMillis());
		this.status = 1;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public int getMessageId() {
		return messageId;
	}

	public Timestamp getSentTimeStamp() {
		return sentTimeStamp;
	}
	public void setSentTimeStamp(Timestamp sentTimeStamp) {
		this.sentTimeStamp = sentTimeStamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}

	
	public List<User> getReceivers() {
		return receivers;
	}
	public void setReceivers(List<User> receivers) {
		this.receivers = receivers;
	}
	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	
	
}
