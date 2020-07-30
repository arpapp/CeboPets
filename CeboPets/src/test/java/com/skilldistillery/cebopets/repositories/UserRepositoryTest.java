package com.skilldistillery.cebopets.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.cebopets.entities.User;

@SpringBootTest
class UserRepositoryTest {

	@Autowired
	private UserRepository userRepo;
	
	@Test
	void test_find_all() {
		List<User> users = userRepo.findAll();
		assertNotNull(users);
		assertTrue(users.size() > 0);
	}
	
	@Test
	void test_find_by_id() {
		Optional<User> user = userRepo.findById(1);
		User userTest = user.get();
		assertNotNull(userTest);
		assertEquals("tpapp", userTest.getUsername());
	}
	
	@Test
	void test_find_by_username() {
		User user = userRepo.findUserByUsername("tpapp");
		assertNotNull(user);
	}
	
	@Test
	void find_list_guild_memebers() {
		List<User> users = userRepo.findByGuildsId(1);
		assertNotNull(users);
		assertTrue(users.size() > 0);
	}

}
