package com.skilldistillery.cebopets.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.cebopets.entities.User;
import com.skilldistillery.cebopets.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<User> findAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User findById(int id) {
		Optional<User> userOpt = userRepo.findById(id);
		User user = null;
		if(userOpt.isPresent()) {
			user = userOpt.get();
		}
		return user;
	}

	@Override
	public User findByUsername(String username) {
		return userRepo.findUserByUsername(username);
	}

	@Override
	public List<User> findByGuildId(int guildId) {
		return userRepo.findByGuildsId(guildId);
	}

}
