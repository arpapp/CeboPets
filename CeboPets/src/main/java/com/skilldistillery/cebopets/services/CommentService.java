package com.skilldistillery.cebopets.services;

import java.util.List;

import com.skilldistillery.cebopets.entities.Comment;

public interface CommentService {
	List<Comment> findAllComments();
	Comment findCommentById(int id);
	Comment createComment(Comment comment, int postId);
	Comment updateComment(int id, Comment comment, int postId);
	boolean deleteComment(int id);
	List<Comment> findAllCommentForPost(int postId);
}
