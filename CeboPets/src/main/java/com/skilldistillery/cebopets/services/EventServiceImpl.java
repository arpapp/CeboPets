package com.skilldistillery.cebopets.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.cebopets.entities.Event;
import com.skilldistillery.cebopets.entities.User;
import com.skilldistillery.cebopets.repositories.EventRepository;
import com.skilldistillery.cebopets.repositories.UserRepository;

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	private EventRepository eventRepo;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public Event event(int eventId) {
		Optional <Event> optEvent = eventRepo.findById(eventId);
		if (optEvent != null) {
			Event event = optEvent.get();
			return event;
		}
		return null;
	}

	@Override
	public Event eventCreated(Event event, String username) {
		User user = userRepo.findUserByUsername(username);
		event.setCreator_user(user);
		eventRepo.save(event);
		return event;
	}

	@Override
	public Event updateEvent(Event event, int eventId, String username) {
		Event managedEvent = eventRepo.findByCreatorUserUsernameAndId(username, eventId);
		if (managedEvent != null) {
			managedEvent.setTitle(event.getTitle());
			managedEvent.setDescription(event.getDescription());
			managedEvent.setDateTime(event.getDateTime());
			eventRepo.saveAndFlush(managedEvent);
			return managedEvent;
		}
		return null;
	}

	@Override
	public Boolean deleteEvent(int eventId) {
		boolean eventDeleted = true;
		Optional <Event> eventOpt = eventRepo.findById(eventId);
		Event eventToDelete = eventOpt.get();
		if (eventToDelete != null) {
			eventRepo.delete(eventToDelete);
			return eventDeleted;
		}
		return !eventDeleted;
	}

}
