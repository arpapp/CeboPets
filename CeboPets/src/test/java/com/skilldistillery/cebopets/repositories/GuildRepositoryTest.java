package com.skilldistillery.cebopets.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.cebopets.entities.Guild;

@SpringBootTest
class GuildRepositoryTest {
	
	@Autowired
	private GuildRepository guildRepo;

	@Test
	void test_find_all() {
		List<Guild> guilds = guildRepo.findAll();
		assertNotNull(guilds);
		assertTrue(guilds.size() > 0);
	}
	
	@Test
	void test_find_by_Id() {
		Optional<Guild> guildOpt = guildRepo.findById(1);
		Guild managedGuild = guildOpt.get();
		assertNotNull(managedGuild);
		assertEquals("Anime Hangout", managedGuild.getName());
	}

}
