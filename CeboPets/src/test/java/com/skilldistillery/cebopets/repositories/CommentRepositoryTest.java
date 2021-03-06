package com.skilldistillery.cebopets.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.cebopets.entities.Comment;

@SpringBootTest
class CommentRepositoryTest {
	
	@Autowired
	private CommentRepository commentRepo;

	@Test
	void test_find_all() {
		List<Comment> comments = commentRepo.findAll();
		assertNotNull(comments);
		assertTrue(comments.size() > 0);
	}
	
	@Test
	void test_custom_find_by_Post() {
		List<Comment> comments = commentRepo.findByPostId(1);
		assertNotNull(comments);
		assertTrue(comments.size() > 0);
		assertEquals("Um, what the hell? Our CeboPets are dating.", comments.get(0).getContent());
		
	}

}
