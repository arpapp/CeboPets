package com.skilldistillery.cebopets.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.cebopets.entities.Event;
import com.skilldistillery.cebopets.entities.Guild;
import com.skilldistillery.cebopets.entities.Post;
import com.skilldistillery.cebopets.entities.User;
import com.skilldistillery.cebopets.services.GuildService;

@RestController
@RequestMapping("api")
public class GuildController {

	@Autowired
	private GuildService serv;

	@GetMapping("guilds")
	public List<Guild> allGuilds() {
		return serv.findAll();
	}

	@GetMapping("guilds/{guildId}")
	public Guild guildById(@PathVariable int guildId, HttpServletResponse res) {
		Guild guild;
		try {
			guild = serv.findById(guildId);
			if (guild == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			guild = null;
			res.setStatus(404);
			e.printStackTrace();
		}
		return guild;
	}
	
	@PostMapping("guilds")
	public Guild createGuild(@RequestBody Guild guild, HttpServletResponse res) {
		try {
			guild = serv.createGuild(guild);
			res.setStatus(201);
			if(guild == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			guild = null;
			res.setStatus(404);
			e.printStackTrace();
		}
		return guild;
	}
	
	@PutMapping("guilds/{guildId}")
	public Guild updateGuild(@PathVariable int guildId, @RequestBody Guild guild, HttpServletResponse res) {
		try {
			guild = serv.updateGuild(guildId, guild);
			res.setStatus(200);
			if(guild == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			guild = null;
			res.setStatus(404);
			e.printStackTrace();
		}
		return guild;
	}
	
	@DeleteMapping("guilds/{guildId}")
	public void deleteGuild(@PathVariable int guildId, HttpServletResponse res) {
		try {
			serv.deleteGuild(guildId);
			res.setStatus(204);
		} catch (Exception e) {
			res.setStatus(404);
			e.printStackTrace();
		}
	}
	
	@GetMapping("guilds/{guildId}/users")
	public List<User> guildByIdUsers(@PathVariable int guildId, HttpServletResponse res) {
		Guild guild;
		try {
			guild = serv.findById(guildId);
			if (guild == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			guild = null;
			res.setStatus(404);
			e.printStackTrace();
		}
		return guild.getUsers();
	}
	
	@GetMapping("guilds/{guildId}/events")
	public List<Event> guildByIdEvents(@PathVariable int guildId, HttpServletResponse res) {
		Guild guild;
		try {
			guild = serv.findById(guildId);
			if (guild == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			guild = null;
			res.setStatus(404);
			e.printStackTrace();
		}
		return guild.getEvents();
	}
	
	@GetMapping("guilds/{guildId}/posts")
	public List<Post> guildByIdPosts(@PathVariable int guildId, HttpServletResponse res) {
		Guild guild;
		try {
			guild = serv.findById(guildId);
			if (guild == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			guild = null;
			res.setStatus(404);
			e.printStackTrace();
		}
		return guild.getPosts();
	}
	
}
