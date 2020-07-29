package com.skilldistillery.cebopets.services;

import java.util.List;

import com.skilldistillery.cebopets.entities.Guild;

public interface GuildService {
	List<Guild> findAll();
	Guild findById(int id);
	Guild createGuild(Guild guild);
	Guild updateGuild(int id, Guild guild);
	boolean deleteGuild(int id);

}
