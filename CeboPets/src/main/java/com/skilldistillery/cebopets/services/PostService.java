package com.skilldistillery.cebopets.services;

import java.util.List;

import com.skilldistillery.cebopets.entities.Post;

public interface PostService {
		
	Post readPost(int postId);
	
	List<Post> allPostsIndex();
	
	Post updatePost(Post post, int postId, String username);
	
	boolean deletePost(int postId, String username);
	
	Post createPost(Post post, String username);

}
