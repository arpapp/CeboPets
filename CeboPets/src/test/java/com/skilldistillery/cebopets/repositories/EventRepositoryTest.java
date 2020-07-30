package com.skilldistillery.cebopets.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.cebopets.entities.Event;

@SpringBootTest
class EventRepositoryTest {
	
	@Autowired
	private EventRepository eventRepo;

	@Test
	void test_for_event_by_id() {
		Optional <Event> optEvent = eventRepo.findById(1);
		Event event = optEvent.get();
		
		assertNotNull(event);
		assertEquals("Anime Roleplay", event.getTitle());
	}
	
	@Test
	void test_for_all_events() {
		List<Event> events = eventRepo.findAll();
		
		assertNotNull(events);
		assertEquals(1, events.size());
	}

}
