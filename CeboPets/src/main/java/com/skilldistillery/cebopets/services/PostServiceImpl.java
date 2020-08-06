package com.skilldistillery.cebopets.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.cebopets.entities.Post;
import com.skilldistillery.cebopets.entities.User;
import com.skilldistillery.cebopets.repositories.PostRepository;
import com.skilldistillery.cebopets.repositories.UserRepository;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired 
	private PostRepository postRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	

	@Override
	public Post createPost(Post post, String username) {
		User user = userRepo.findUserByUsername(username);
		post.setCreatorUser(user);
		postRepo.saveAndFlush(post);
		return post;
	}

	@Override
	public Post readPost(int postId) {
		Optional<Post> optPost = postRepo.findById(postId);
		if (optPost.isPresent()) {
			Post post = optPost.get();
			return post;
		}
		return null;
	}

	@Override
	public Post updatePost(Post post, int postId, String username) {
		Post managedPost = postRepo.findByIdAndCreatorUserUsername(postId, username);
		if (managedPost != null) {
			managedPost.setTitle(post.getTitle());
			managedPost.setDescription(post.getDescription());
			postRepo.saveAndFlush(managedPost);
			return managedPost;
		}
		return null;
	}

	@Override
	public boolean deletePost(int postId, String username) {
		boolean deleted = true;
		Post postToDelete = postRepo.findByIdAndCreatorUserUsername(postId, username);
		if (postToDelete != null) {
			postRepo.delete(postToDelete);
			return deleted;
		}
		return !deleted;
	}

	@Override
	public List<Post> allPostsIndex() {
		return postRepo.findAll();
	}

}
