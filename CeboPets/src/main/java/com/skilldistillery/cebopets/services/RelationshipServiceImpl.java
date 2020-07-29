package com.skilldistillery.cebopets.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.cebopets.entities.Relationship;
import com.skilldistillery.cebopets.repositories.RelationshipRepository;

@Service
public class RelationshipServiceImpl implements RelationshipService {
	
	@Autowired
	private RelationshipRepository relationshipRepo;

	@Override
	public List<Relationship> findAll() {
		return relationshipRepo.findAll();
	}

	@Override
	public Relationship findById(int id) {
		Optional<Relationship> relaOpt = relationshipRepo.findById(id);
		Relationship relationship = null;
		if(relaOpt.isPresent()) {
			relationship = relaOpt.get();
		}
		return relationship;
	}

	@Override
	public Relationship findByCeboPetId(int cebopetId) {
		return relationshipRepo.findByCeboPetsId(cebopetId);
	}

	@Override
	public Relationship createRelationship(Relationship relationship) {
		relationshipRepo.saveAndFlush(relationship);
		return relationship;
	}

	@Override
	public Relationship updateRelationship(int id, Relationship relationship) {
		Optional<Relationship> relaOpt = relationshipRepo.findById(id);
		Relationship managedRelationship = null;
		if(relaOpt.isPresent()) {
			managedRelationship = relaOpt.get();
			managedRelationship.setCeboPets(relationship.getCeboPets());
			if(relationship.getMarriageDate() != null) {
				managedRelationship.setMarriageDate(relationship.getMarriageDate());
			}
			managedRelationship.setStatus(relationship.getStatus());
		}
		return managedRelationship;
	}

	@Override
	public boolean disableRelationship(int id) {
		Optional<Relationship> relaOpt = relationshipRepo.findById(id);
		Relationship managedRelationship = null;
		if(relaOpt.isPresent()) {
			managedRelationship = relaOpt.get();
			managedRelationship.setEnabled(false);
			return true;
		}
		
		return false;
	}

}
