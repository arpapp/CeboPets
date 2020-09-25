package com.skilldistillery.cebopets.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.cebopets.entities.Event;
import com.skilldistillery.cebopets.services.EventService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4211"})

public class EventController {
	
	@Autowired
	private EventService eventServ;
	
	@GetMapping("events")
	public List <Event> getEvents() {
		return eventServ.allEvents();
	}
	
	@GetMapping("events/{eventId}")
	public Event getEventById(@PathVariable int eventId, HttpServletResponse res) {
		Event event = eventServ.event(eventId);
		if (event == null) {
			res.setStatus(404);
		}
		return event;		
	}
	
	@PostMapping("/events")
	public Event makeNewEvent(@RequestBody Event event, Principal principal, HttpServletResponse res, 
			HttpServletRequest req) {
		try {
		event = eventServ.eventCreated(event, principal.getName());
		if (event == null) {
			res.setStatus(404);
		} else { 
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			res.setHeader("location", url.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			event = null;
		}
		return event;
	
	}
	
	@PutMapping("/events/{eventId}")
	public Event updateThisEvent(@RequestBody Event event, Principal principal, @PathVariable int eventId, 
			HttpServletResponse res, HttpServletRequest req) {
		
		try {
			event = eventServ.updateEvent(event, eventId, principal.getName());
			if (event == null) {
				res.setStatus(404);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(404);
			event = null;
		}
		return event;
	}
	
	@DeleteMapping("/events/{eventId}")
	public void deleteEvent(@PathVariable int eventId, Principal principal, HttpServletResponse res) {
		try {
			eventServ.deleteEvent(eventId, principal.getName());
			res.setStatus(204);
		} catch(Exception e) {
			res.setStatus(404);
			e.printStackTrace();
		}
		
	}
}
