package com.skilldistillery.cebopets.services;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.cebopets.entities.Comment;
import com.skilldistillery.cebopets.entities.Post;
import com.skilldistillery.cebopets.entities.User;
import com.skilldistillery.cebopets.repositories.CommentRepository;
import com.skilldistillery.cebopets.repositories.PostRepository;
import com.skilldistillery.cebopets.repositories.UserRepository;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository commentRepo;
	@Autowired
	private PostRepository postRepo;
	@Autowired 
	private UserRepository userRepo;

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
	public Comment createComment(Comment comment, int postId, Principal principal) {
		Optional<Post> postOpt = postRepo.findById(postId);
		Post post = postOpt.get();
		User user = userRepo.findUserByUsername(principal.getName());
		comment.setPost(post);
		comment.setUser(user);
		commentRepo.saveAndFlush(comment);
		return comment;
	}

	@Override
	public Comment updateComment(int commentId, Comment comment, int postId, Principal principal) {
		Comment managedComment = commentRepo.findByIdAndPostIdAndUserUsername(commentId, postId, principal.getName());
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
