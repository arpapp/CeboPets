package com.skilldistillery.cebopets.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CeboPetTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private CeboPet ceboPet;

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
		ceboPet = em.find(CeboPet.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		ceboPet = null;
		em.close();
	}

	@Test
	void test() {
		assertNotNull(ceboPet);
		assertEquals("StinkBobFartPants", ceboPet.getName());
		assertEquals(10, ceboPet.getHungerLevel());
		assertEquals(Gender.MALE, ceboPet.getGender());
	}
	
	@Test
	void test_relationship_mapping_breed() {
		assertNotNull(ceboPet);
		assertEquals("Kacheeky", ceboPet.getBreed().getName());
	}
	
	@Test
	void test_user_mapping() {
		assertNotNull(ceboPet);
		assertEquals("tpapp", ceboPet.getUser().getUsername());
	}
	
	@Test
	void test_relationship_mapping() {
		assertNotNull(ceboPet);
		assertEquals(Status.COMPLICATED, ceboPet.getRelationship().getStatus());
	}

}
