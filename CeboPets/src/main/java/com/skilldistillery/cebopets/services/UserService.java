package com.skilldistillery.cebopets.services;

import java.util.List;

import com.skilldistillery.cebopets.entities.Cebopet;
import com.skilldistillery.cebopets.entities.Comment;
import com.skilldistillery.cebopets.entities.Event;
import com.skilldistillery.cebopets.entities.Guild;
import com.skilldistillery.cebopets.entities.Post;
import com.skilldistillery.cebopets.entities.User;

public interface UserService {
	List<User> findAllUsers();
	User findById(int id);
	User findByUsername(String username);
	List<User> findByGuildId(int guildId);
	User updateUser(User user, String username);
	boolean disableUser(String username);
	List<Guild> fetchGuilds(String username);
	List<Guild> fetchGuildsCreated(String username);
	List<Cebopet> fetchCebopets(String username);
	List<Post> fetchPosts(String username);
	List<Comment> fetchComments(String username);
	List<Event> fetchEventsAttending(String username);
	List<Event> fetchEventsCreated(String username);
}
