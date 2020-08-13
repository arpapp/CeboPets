package com.skilldistillery.cebopets.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.cebopets.entities.Cebopet;
import com.skilldistillery.cebopets.entities.Comment;
import com.skilldistillery.cebopets.entities.Event;
import com.skilldistillery.cebopets.entities.Guild;
import com.skilldistillery.cebopets.entities.Post;
import com.skilldistillery.cebopets.entities.User;
import com.skilldistillery.cebopets.services.UserService;

@RestController
@RequestMapping("api")
public class UserController {

	@Autowired
	private UserService userServ;

	@GetMapping("users/{id}")
	public User getUserById(@PathVariable int id, HttpServletResponse res) {
		User user = userServ.findById(id);
		if (user == null) {
			res.setStatus(404);
		}
		return user;
	}
	
	@PutMapping("users/{id}")
	public User updateUser(Principal principal, @RequestBody User user, HttpServletResponse res) {
		try {
			if (user == null) {
				res.setStatus(404);
			}
			user = userServ.updateUser(user, principal.getName());
		} catch (Exception e) {
			res.setStatus(400);
			user= null;
			e.printStackTrace();
		}
		return user;
	}
	
	@PutMapping("users/{id}/disable")
	public void disableUser(Principal principal, HttpServletResponse res) {
		try {
			boolean disabled = userServ.disableUser(principal.getName());
			if(disabled) {
				res.setStatus(204);
			} else{
				res.setStatus(404);
			}
		} catch (Exception e) {
			res.setStatus(409);
			e.printStackTrace();
		}
	}
	
	@GetMapping("users/{id}/guilds")
	public List<Guild> userGuilds(Principal principal){
		return userServ.fetchGuilds(principal.getName());
	}
	
	@GetMapping("users/{id}/guildsleading")
	public List<Guild> userGuildsCreated(Principal principal){
		return userServ.fetchGuildsCreated(principal.getName());
	}
	
	@GetMapping("users/{id}/cebopets")
	public List<Cebopet> userCebopets(Principal principal){
		return userServ.fetchCebopets(principal.getName());
	}
	
	@GetMapping("users/{id}/posts")
	public List<Post> userPosts(Principal principal){
		return userServ.fetchPosts(principal.getName());
	}
	
	@GetMapping("users/{id}/comments")
	public List<Comment> userComments(Principal principal){
		return userServ.fetchComments(principal.getName());
	}
	
	@GetMapping("users/{id}/events")
	public List<Event> userEventsAttending(Principal principal){
		return userServ.fetchEventsAttending(principal.getName());
	}
	
	@GetMapping("users/{id}/eventshosting")
	public List<Event> userEventsCreated(Principal principal){
		return userServ.fetchEventsCreated(principal.getName());
	}
	
	
	
	
	

}
