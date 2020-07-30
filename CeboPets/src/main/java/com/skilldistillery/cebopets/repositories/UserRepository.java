package com.skilldistillery.cebopets.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.cebopets.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findUserByUsername(String username);
	List<User> findByGuildsId(int guildId);

}
