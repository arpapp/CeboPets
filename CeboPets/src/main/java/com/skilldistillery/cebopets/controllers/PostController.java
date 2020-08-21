package com.skilldistillery.cebopets.controllers;

import java.security.Principal;
import java.util.List;

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

import com.skilldistillery.cebopets.entities.Post;
import com.skilldistillery.cebopets.services.PostService;

@RestController
@RequestMapping("api")
public class PostController {
	
	@Autowired
	private PostService postSvc;
	
	@GetMapping("/posts/{postId}") 
	public Post post(@PathVariable int postId, HttpServletResponse res) {
		Post post;
		try {
			post = postSvc.readPost(postId);
		} catch (Exception e) {
			post = null;
			res.setStatus(404);
			e.printStackTrace();
		}
		return post;
	}
	
	@GetMapping("/posts")
	public List<Post> allPosts() {
		return postSvc.allPostsIndex();
	}
	
	@PostMapping("/posts")
	public Post create(@RequestBody Post post, Principal principal, HttpServletResponse res) {
		Post newPost;
		try {
			newPost = postSvc.createPost(post, principal.getName());
			res.setStatus(200);
		} catch (Exception e) {
			newPost = null;
			res.setStatus(404);
			e.printStackTrace();
		}
		return newPost;
	}
	
	@PutMapping("posts/{id}")
	public Post update(@PathVariable int id, @RequestBody Post post, Principal principal, HttpServletResponse res) {
		try {
			post = postSvc.updatePost(post, id, principal.getName());
			if (post == null) {
				res.setStatus(404); 
			}
			return post;
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400); 
			post = null;
		}
		return post;
	}
	
	@DeleteMapping("posts/{postId}")
	public void delete(@PathVariable int postId, Principal principal, HttpServletResponse res) {
		try {
			postSvc.deletePost(postId, principal.getName());
			res.setStatus(204);
		} catch (Exception e) {
			res.setStatus(404);
			e.printStackTrace();
		}
	}
	
	

}
