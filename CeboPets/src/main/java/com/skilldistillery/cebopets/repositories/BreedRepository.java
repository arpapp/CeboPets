package com.skilldistillery.cebopets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.cebopets.entities.Breed;

public interface BreedRepository extends JpaRepository<Breed, Integer> {
	Breed findBreedByName(String name);
}
