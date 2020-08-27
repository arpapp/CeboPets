package com.skilldistillery.cebopets.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Event {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	private String description;
	
	@Column(name="event_date_time")
	private LocalDateTime dateTime;
	
	private boolean enabled;
	
	@ManyToOne
	@JoinColumn(name="guild_id")
	@JsonIgnoreProperties({"users", "posts", "user", "events"})
	private Guild guild;
	
	@ManyToOne
	@JoinColumn(name="creator_user_id")
	@JsonIgnoreProperties({"posts", "events", "guilds", "cebopets", "comments","guildsCreated", "createdEvents"})
	private User creatorUser;
	
	@ManyToMany
	@JoinTable(name="user_has_event",
	joinColumns=@JoinColumn(name="user_id"),
	inverseJoinColumns=@JoinColumn(name="event_id"))
	@JsonIgnoreProperties({"posts", "events", "guilds", "cebopets", "comments","guildsCreated", "createdEvents"})
	private List<User> usersAttending;

	public Event() {
		super();
	}



	public Event(int id, String title, String description, LocalDateTime dateTime, boolean enabled) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.dateTime = dateTime;
		this.enabled = enabled;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public LocalDateTime getDateTime() {
		return dateTime;
	}



	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}



	public boolean isEnabled() {
		return enabled;
	}



	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



	public Guild getGuild() {
		return guild;
	}



	public void setGuild(Guild guild) {
		this.guild = guild;
	}



	public User getCreator_user() {
		return creatorUser;
	}



	public void setCreator_user(User creatorUser) {
		this.creatorUser = creatorUser;
	}



	public List<User> getUsersAttending() {
		return usersAttending;
	}



	public void setUsersAttending(List<User> usersAttending) {
		this.usersAttending = usersAttending;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (enabled != other.enabled)
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", description=" + description + ", dateTime=" + dateTime
				+ ", enabled=" + enabled + "]";
	}
	
	
	
}
