package com.skilldistillery.cebopets.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.cebopets.entities.Comment;
import com.skilldistillery.cebopets.entities.Post;
import com.skilldistillery.cebopets.repositories.CommentRepository;
import com.skilldistillery.cebopets.repositories.PostRepository;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository commentRepo;
	@Autowired
	private PostRepository postRepo;

	@Override
	public List<Comment> findAllComments() {
		return commentRepo.findAll(); 
	}

	@Override
	public Comment findCommentById(int id) {
		Optional<Comment> commentOpt = commentRepo.findById(id);
		Comment comment = null;
		if(commentOpt.isPresent()) {
			comment = commentOpt.get();
		}
		return comment;
	}

	@Override
	public Comment createComment(Comment comment, int postId) {
		Optional<Post> postOpt = postRepo.findById(postId);
		Post post = postOpt.get();
		comment.setPost(post);
		commentRepo.saveAndFlush(comment);
		return comment;
	}

	@Override
	public Comment updateComment(int commentId, Comment comment, int postId) {
		Comment managedComment = commentRepo.findByIdAndPostId(commentId, postId);
		if(managedComment != null) {
			managedComment.setContent(comment.getContent());
			commentRepo.saveAndFlush(managedComment);
		}
		return managedComment;
	}

	@Override
	public boolean deleteComment(int id) {
		Optional<Comment> commentOpt = commentRepo.findById(id);
		Comment managedComment = null;
		if(commentOpt.isPresent()) {
			managedComment = commentOpt.get();
			commentRepo.delete(managedComment);
			return true;
		}
		return false;
	}

	@Override
	public List<Comment> findAllCommentForPost(int postId) {
		return commentRepo.findByPostId(postId);
	}

}
