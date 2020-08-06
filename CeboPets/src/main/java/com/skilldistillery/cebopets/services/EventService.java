package com.skilldistillery.cebopets.services;

import java.util.List;

import com.skilldistillery.cebopets.entities.Event;

public interface EventService {
	
	List<Event> allEvents();
	
	Event event(int eventId);
	
	Event eventCreated(Event event, String username);
	
	Event updateEvent(Event event, int eventId, String username);
		
	Boolean deleteEvent(int eventId, String username);

}
