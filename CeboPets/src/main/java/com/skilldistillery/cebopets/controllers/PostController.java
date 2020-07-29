package com.skilldistillery.cebopets.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.cebopets.entities.Post;
import com.skilldistillery.cebopets.services.PostService;

@RestController
@RequestMapping("api")
public class PostController {
	
	@Autowired
	PostService postSvc;
	
	@GetMapping("/posts/{postId}") 
	public Post post(@PathVariable int postId) {
		return postSvc.readPost(postId);
	}
	
	@GetMapping("/posts")
	public List<Post> allPosts() {
		return postSvc.allPostsIndex();
	}
	
	

}
