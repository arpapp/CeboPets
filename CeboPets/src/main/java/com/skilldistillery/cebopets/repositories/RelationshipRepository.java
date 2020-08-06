package com.skilldistillery.cebopets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.cebopets.entities.Relationship;

public interface RelationshipRepository extends JpaRepository<Relationship, Integer> {
	Relationship findByCeboPetsId(int cebopetId);
	
}
