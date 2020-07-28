package com.skilldistillery.cebopets.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PostTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Post post;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("CeboPetsPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		post = em.find(Post.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		post = null;
		em.close();
	}

	@Test
	void test() {
		assertNotNull(post);
		assertEquals("Is your cebopet looking for a relationship?", post.getTitle());
		assertEquals("Hi, my StinkBob FartPants is looking to date. Please comment if interested.", post.getDescription());
		assertEquals("2020-07-21 00:00:00.0", post.getCreateDate().toString());
	}

}
