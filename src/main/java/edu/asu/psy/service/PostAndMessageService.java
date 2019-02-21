package edu.asu.psy.service;

import java.util.List;

import edu.asu.psy.models.Message;
import edu.asu.psy.models.Post;

public interface PostAndMessageService {

	
	public void sendMessage(Message message);
	public void sendMessage(List<Message> messages);
	public List<Message> findByReceiverId(int userId);
	public List<Message> findBySenderId(int userId);
	public Message findByMessageId(int messageId);
	
	public void savePost(Post post);
	public List<Post> retrieveRecentPosts(int offset, int limit);
	public void deletePost(int postId);
	
}
