package com.skilldistillery.cebopets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.cebopets.entities.Cebopet;

public interface CebopetRepository extends JpaRepository<Cebopet, Integer>{
	
	Cebopet findByIdAndUserUsername(int ceboPetId, String username);

}
