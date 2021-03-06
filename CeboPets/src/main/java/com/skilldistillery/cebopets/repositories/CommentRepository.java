package com.skilldistillery.cebopets.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.cebopets.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
	List<Comment> findByPostId(int postId);
	Comment findByIdAndPostIdAndUserUsername(int commentId, int postId, String username);
}
