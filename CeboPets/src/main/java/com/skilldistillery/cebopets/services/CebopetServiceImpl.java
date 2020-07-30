package com.skilldistillery.cebopets.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.cebopets.entities.Cebopet;
import com.skilldistillery.cebopets.entities.User;
import com.skilldistillery.cebopets.repositories.CebopetRepository;
import com.skilldistillery.cebopets.repositories.UserRepository;

public class CebopetServiceImpl implements CebopetService {
	
	@Autowired
	private CebopetRepository cebopetRepo;
	
	@Autowired
	private UserRepository userRepo;
	

	@Override
	public Cebopet cebopet(int id, String username) {
		Cebopet cebopet = cebopetRepo.findByIdAndUserUsername(id, username);
		return cebopet;
	}

	@Override
	public List<Cebopet> findAllCebopets() {
		return cebopetRepo.findAll();
	}

	@Override
	public Cebopet createCebopet(Cebopet cebopet, String username) {
		User user = userRepo.findUserByUsername(username);
		cebopet.setUser(user);
		cebopetRepo.saveAndFlush(cebopet);
		return cebopet;
	}

	@Override
	public Cebopet updateCebopet(Cebopet cebopet, int ceboId, String username) {
		Cebopet managedCebopet = cebopetRepo.findByIdAndUserUsername(ceboId, username);
		if (managedCebopet != null) {
			managedCebopet.setName(cebopet.getName());
			managedCebopet.setRelationship(cebopet.getRelationship());
			managedCebopet.setHungerLevel(cebopet.getHungerLevel());
			managedCebopet.setGender(cebopet.getGender());
			cebopetRepo.saveAndFlush(managedCebopet);
			return managedCebopet;
		}
		return null;
	}

	@Override
	public Boolean deleteCebopet(int cebopetId, String username) {
		boolean disabled = true;
		Cebopet cebopetToDisable = cebopetRepo.findByIdAndUserUsername(cebopetId, username);
		if (cebopetToDisable != null) {
			cebopetToDisable.setEnabled(false);
			return disabled;
		}
		return !disabled;
	}

}
