package com.myblogApp.Repository;

import com.myblogApp.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment , Long > {

    List<Comment> findByPostId(long postId);
}
