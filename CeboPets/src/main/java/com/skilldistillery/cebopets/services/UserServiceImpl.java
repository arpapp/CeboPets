package com.skilldistillery.cebopets.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.cebopets.entities.Cebopet;
import com.skilldistillery.cebopets.entities.Comment;
import com.skilldistillery.cebopets.entities.Event;
import com.skilldistillery.cebopets.entities.Guild;
import com.skilldistillery.cebopets.entities.Post;
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

	@Override
	public User updateUser(User user, String username) {
		User managedUser = userRepo.findUserByUsername(username);
		if(managedUser != null) {
			managedUser.setFirstName(user.getFirstName());
			managedUser.setLastName(user.getLastName());
		}
		return managedUser;
	}

	@Override
	public boolean disableUser(String username) {
		User toDisable = userRepo.findUserByUsername(username);
		if(toDisable != null) {
			toDisable.setEnabled(false);
			return true;
		}
		return false;
	}

	@Override
	public List<Guild> fetchGuilds(String username) {
		User user = userRepo.findUserByUsername(username);
		return user.getGuilds();
	}

	@Override
	public List<Guild> fetchGuildsCreated(String username) {
		User user = userRepo.findUserByUsername(username);
		return user.getGuildsCreated();
	}

	@Override
	public List<Cebopet> fetchCebopets(String username) {
		User user = userRepo.findUserByUsername(username);
		return user.getCebopets();
	}

	@Override
	public List<Post> fetchPosts(String username) {
		User user = userRepo.findUserByUsername(username);
		return user.getPosts();
	}

	@Override
	public List<Comment> fetchComments(String username) {
		User user = userRepo.findUserByUsername(username);
		return user.getComments();
	}

	@Override
	public List<Event> fetchEventsAttending(String username) {
		User user = userRepo.findUserByUsername(username);
		return user.getEvents();
	}

	@Override
	public List<Event> fetchEventsCreated(String username) {
		User user = userRepo.findUserByUsername(username);
		return user.getCreatedEvents();
	}
	

}
