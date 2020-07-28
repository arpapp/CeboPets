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

class RelationshipTest {
	
	private static EntityManagerFactory emf;
	
	private EntityManager em;
	
	private Relationship relationship;

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
		relationship = em.find(Relationship.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		relationship = null;
	}

	@Test
	void test() {
		assertNotNull(relationship);
		assertEquals(Status.COMPLICATED, relationship.getStatus());
		assertTrue(relationship.getEnabled());
		assertEquals("PinkKacheeky", relationship.getCeboPets().get(1).getName());
	}

}
