package com.skilldistillery.cebopets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.cebopets.entities.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {
	
	Event findByCreatorUserUsernameAndId(String username, int eventId);
	

}
