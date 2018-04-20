package edu.asu.psy.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.asu.psy.models.Post;
@Repository("postRepository")
public interface PostRepository extends JpaRepository<Post, Long>{

	@Query(value = "SELECT * FROM post_table as p"
			+ "  where p.status=1 ORDER BY p.timestamp DESC LIMIT :limit OFFSET :offset", nativeQuery = true)
	List<Post> retrieveRecentPosts(@Param("offset")int offset,@Param("limit") int limit);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update Post_table as p set p.status= 2 where p.post_id = :postid", nativeQuery = true)
	void updatePost(@Param("postid") int postId);
	

}
