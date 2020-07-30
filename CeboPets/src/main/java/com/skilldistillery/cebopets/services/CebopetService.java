package com.skilldistillery.cebopets.services;

import java.util.List;

import com.skilldistillery.cebopets.entities.Cebopet;

public interface CebopetService {
	
	Cebopet cebopet(int id, String username);
	
	List<Cebopet> findAllCebopets();
	
	Cebopet createCebopet(Cebopet cebopet, String username);
	
	Cebopet updateCebopet(Cebopet cebopet, int ceboId, String username);
	
	Boolean deleteCebopet(int cebopetId, String username);

}
