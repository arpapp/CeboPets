package com.skilldistillery.cebopets.services;

import java.util.List;

import com.skilldistillery.cebopets.entities.Comment;

public interface CommentService {
	List<Comment> findAllComments();
	Comment findCommentById(int id);
	Comment createComment(Comment comment);
	Comment updateComment(int id, Comment comment);
	boolean deleteComment(int id);
	List<Comment> findAllCommentForPost(int postId);
}
