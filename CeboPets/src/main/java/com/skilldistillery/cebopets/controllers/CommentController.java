package com.skilldistillery.cebopets.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.cebopets.entities.Comment;
import com.skilldistillery.cebopets.entities.Post;
import com.skilldistillery.cebopets.services.CommentService;

@RestController
@RequestMapping("api")
public class CommentController {

	@Autowired
	private CommentService comServ;

	@GetMapping("/posts/{postId}/comments")
	public List<Comment> getCommentsOnPost(@PathVariable int postId) {
		return comServ.findAllCommentForPost(postId);
	}

	@PostMapping("/posts/{postId}/comments")
	public Comment makeAComment(@PathVariable int postId, @RequestBody Comment comment, HttpServletRequest req,
			HttpServletResponse res, Principal principal) {
		try {
			comment = comServ.createComment(comment, postId, principal);
			if (comment == null) {
				res.setStatus(404);
				comment = null;
			} else {
				res.setStatus(201);
				StringBuffer url = req.getRequestURL();
				url.append("/").append(comment.getId());
				res.addHeader("Location", url.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			comment = null;
		}
		return comment;

	}

	@PutMapping("/posts/{postId}/comments/{commentId}")
	public Comment updateThisComment(@PathVariable int postId, @PathVariable int commentId,
			@RequestBody Comment comment, HttpServletRequest req, HttpServletResponse res, Principal principal) {
		Comment updatedComment = null;
		try {
			updatedComment = comServ.updateComment(commentId, comment, postId, principal);
			if (updatedComment == null) {
				res.setStatus(404);
				updatedComment = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			updatedComment = null;
		}
		return updatedComment;
	}
	
	@DeleteMapping("/posts/{postId}/comments/{commentId}")
	public void deleteThisComment(@PathVariable int postId, @PathVariable int commentId, HttpServletResponse res) {
		Post post = new Post();
		post.setId(postId);
		try {
			comServ.deleteComment(commentId);
			res.setStatus(204);
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
	}

}
