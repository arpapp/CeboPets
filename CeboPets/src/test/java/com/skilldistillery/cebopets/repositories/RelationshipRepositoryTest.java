package com.skilldistillery.cebopets.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.cebopets.entities.Relationship;

@SpringBootTest
class RelationshipRepositoryTest {
	
	@Autowired
	private RelationshipRepository relationshipRepo;

	@Test
	void test() {
		List<Relationship> relationships = relationshipRepo.findAll();
		assertNotNull(relationships);
		assertTrue(relationships.size() > 0);
	}
	
	@Test
	void test_find_by_id() {
		Optional<Relationship> relationshipOpt = relationshipRepo.findById(1);
		Relationship relationship = relationshipOpt.get();
		assertNotNull(relationship);
		assertEquals("Kacheeky", relationship.getCeboPets().get(0).getBreed().getName());
	}
	
	@Test
	void test_custom_find_by_cebopet_id() {
		Relationship relationship = relationshipRepo.findByCeboPetsId(1);
		assertNotNull(relationship);
		assertEquals("Kacheeky", relationship.getCeboPets().get(0).getBreed().getName());
		
	}

}
