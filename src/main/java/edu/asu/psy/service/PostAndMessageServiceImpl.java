package edu.asu.psy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.asu.psy.models.Message;
import edu.asu.psy.models.Post;
import edu.asu.psy.repository.MessageRepository;
import edu.asu.psy.repository.PostRepository;

@Service("postAndMessageService")
public class PostAndMessageServiceImpl implements PostAndMessageService{

	@Autowired
    private MessageRepository messageRepository;
	@Autowired
    private PostRepository postRepository;
	@Override
	public void sendMessage(Message message) {
		// TODO Auto-generated method stub
		messageRepository.save(message);
		
	}

	@Override
	public void sendMessage(List<Message> messages) {
		// TODO Auto-generated method stub
		messageRepository.saveAll(messages);
		
	}
	
	@Override
	public List<Message> findByReceiverId(int userId) {
		// TODO Auto-generated method stub
		return messageRepository.findByReceiverId(userId);
	}
	@Override
	public Message findByMessageId(int messageId)
	{
		return messageRepository.findByMessageId(messageId);
	}
	@Override
	public void savePost(Post post) {
		// TODO Auto-generated method stub
		postRepository.save(post);
		
		
		
	}

	@Override
	public List<Post> retrieveRecentPosts(int offset, int limit) {
		// TODO Auto-generated method stub
		return postRepository.retrieveRecentPosts(offset, limit);
	}

	@Override
	public void deletePost(int postId) {
		// TODO Auto-generated method stub
		
		postRepository.updatePost(postId);
		
	}

	@Override
	public List<Message> findBySenderId(int userId) {
		// TODO Auto-generated method stub
		return messageRepository.findBySenderId(userId);
	}

}
