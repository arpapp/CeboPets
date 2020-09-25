package com.skilldistillery.cebopets.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.cebopets.entities.Breed;

@SpringBootTest
class BreedRepositoryTest {

	@Autowired
	private BreedRepository breedRepo;

	@Test
	void test_breed_by_id() {
		Optional<Breed> optBreed = breedRepo.findById(1);
		if (optBreed != null) {
			Breed breed = optBreed.get();
			assertNotNull(breed);
			assertEquals("Kacheeky", breed.getName());
		}

	}
	
	@Test
	void test_custom_query_breed_by_name() {
		Breed breed = breedRepo.findBreedByName("Kacheeky");
		assertNotNull(breed);
		assertEquals("Kacheeky", breed.getName());
	}
}
