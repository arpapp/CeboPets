package com.skilldistillery.cebopets.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Event event;

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
		event = em.find(Event.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		event = null;
		em.close();
	}

	@Test
	void test() {
		assertNotNull(event);
		assertEquals("Anime Roleplay", event.getTitle());
		assertEquals("Everyone picks an anime character to roleplay over Zoom EXCEPT Naruto because I am Naruto.", event.getDescription());
		assertEquals("2020-07-21T13:00", event.getDateTime().toString());
	}
	
	@Test
	void test_relationship_mapping_guild() {
		assertNotNull(event);
		assertEquals("Anime Hangout", event.getGuild().getName());
		assertEquals("A hangout for anime luvers     uwu", event.getGuild().getDescription());
	}
	
	@Test
	void test_relationship_mapping_user_created() {
		assertNotNull(event);
		assertEquals("tflores", event.getCreator_user().getUsername());
	}
	
	@Test
	void test_relationship_mapping_users_attending() {
		assertNotNull(event);
		assertTrue(event.getUsersAttending().size() > 0);
	}

}
