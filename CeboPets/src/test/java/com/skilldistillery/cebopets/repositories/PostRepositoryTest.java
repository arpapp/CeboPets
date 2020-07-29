package com.skilldistillery.cebopets.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.cebopets.entities.Post;

@SpringBootTest
class PostRepositoryTest {
	
	@Autowired
	private PostRepository postRepo;
	
	@Test
	void test_Post_By_Id() {
		Optional <Post> post = postRepo.findById(1);
		Post managedPost = post.get();
		assertNotNull(managedPost);
		assertEquals("Is your cebopet looking for a relationship?", managedPost.getTitle());
		
	}



}
