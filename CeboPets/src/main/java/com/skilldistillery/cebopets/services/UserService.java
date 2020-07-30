package com.skilldistillery.cebopets.services;

import java.util.List;

import com.skilldistillery.cebopets.entities.User;

public interface UserService {
	List<User> findAllUsers();
	User findById(int id);
	User findByUsername(String username);
	List<User> findByGuildId(int guildId);
}
