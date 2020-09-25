package com.skilldistillery.cebopets.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.cebopets.entities.Breed;
import com.skilldistillery.cebopets.repositories.BreedRepository;

@Service
public class BreedServiceImpl implements BreedService {
	
	@Autowired
	private BreedRepository breedRepo;

	@Override
	public Breed seeBreed(int breedId) {
		Optional <Breed> optBreed = breedRepo.findById(breedId);
		
		if (optBreed != null) {
			Breed breed = optBreed.get();
			return breed;
		}
		return null;
	}

	@Override
	public List<Breed> allBreeds() {
		return breedRepo.findAll();
	}

	@Override
	public Breed getBreedByName(String name) {
		return breedRepo.findBreedByName(name);
	}
	
	

}
