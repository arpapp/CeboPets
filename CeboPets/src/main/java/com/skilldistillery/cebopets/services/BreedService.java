package com.skilldistillery.cebopets.services;

import java.util.List;

import com.skilldistillery.cebopets.entities.Breed;

public interface BreedService {
	
	Breed seeBreed(int breedId);
	
	List<Breed> allBreeds();
	
	Breed getBreedByName(String name);

}
