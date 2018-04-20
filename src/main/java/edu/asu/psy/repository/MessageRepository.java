package edu.asu.psy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.asu.psy.models.Message;

@Repository("messageRepository")
public interface MessageRepository extends JpaRepository<Message, Integer>{
	@Query(value = "SELECT * FROM message_table as m inner join message_receiver as mr on mr.message_id = m.message_id where mr.receivers_user_id = :userid and m.status !=3  ORDER BY m.status asc, m.sent_timestamp DESC limit 20", nativeQuery = true)
	public List<Message> findByReceiverId(@Param("userid") int userId);
	
	@Query(value = "SELECT * FROM message_table as m where m.sender_user_id = :userid and m.type =1  ORDER BY m.status asc, m.sent_timestamp DESC limit 20", nativeQuery = true)
	public List<Message> findBySenderId(@Param("userid") int userId);
	public Message findByMessageId(int messageId);
	
}
