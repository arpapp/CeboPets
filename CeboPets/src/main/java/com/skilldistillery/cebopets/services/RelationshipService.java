package com.skilldistillery.cebopets.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.cebopets.entities.Relationship;

public interface RelationshipService {
	List<Relationship> findAll();
	Relationship findById(int id);
	Relationship findByCeboPetId(int cebopetId);
	Relationship createRelationship(Relationship relationship);
	Relationship updateRelationship(int id, Relationship relationship);
	boolean disableRelationship (int id);
}
