package com.skilldistillery.cebopets.services;

import com.skilldistillery.cebopets.entities.Event;

public interface EventService {
	
	Event event(int eventId);
	
	Event eventCreated(Event event, String username);
	
	Event updateEvent(Event event, int eventId, String username);
		
	Boolean deleteEvent(int eventId);

}
