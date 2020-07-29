package com.skilldistillery.cebopets.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.cebopets.entities.Guild;
import com.skilldistillery.cebopets.repositories.GuildRepository;

@Service
public class GuildServiceImpl implements GuildService {
	
	@Autowired
	private GuildRepository guildRepo;
	
	@Override
	public List<Guild> findAll() {
		return guildRepo.findAll();
	}

	@Override
	public Guild findById(int id) {
		Optional<Guild> guildOpt = guildRepo.findById(id);
		Guild guild = null;
		if(guildOpt.isPresent()) {
			guild = guildOpt.get();
		}
		return guild;
	}

	@Override
	public Guild createGuild(Guild guild) {
		guildRepo.saveAndFlush(guild);
		return guild;
	}

	@Override
	public Guild updateGuild(int id, Guild guild) {
		Optional<Guild> guildOpt = guildRepo.findById(id);
		Guild managedGuild = null;
		if(guildOpt.isPresent()) {
			managedGuild = guildOpt.get();
			managedGuild.setDescription(guild.getDescription());
			managedGuild.setName(guild.getName());
			managedGuild.setPictureUrl(guild.getPictureUrl());
		}
		return managedGuild;
	}

	@Override
	public boolean deleteGuild(int id) {
		Optional<Guild> guildOpt = guildRepo.findById(id);
		Guild managedGuild = null;
		if(guildOpt.isPresent()) {
			managedGuild = guildOpt.get();
			guildRepo.delete(managedGuild);
			return true;
		}
		return false;
	}

}
