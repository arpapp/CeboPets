package com.skilldistillery.cebopets.entities;

import java.util.Date;
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
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Guild {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String description;
	
	@Column(name="create_date")
	@CreationTimestamp
	private Date createDate;
	
	@Column(name="picture_url")
	private String pictureUrl;
	
	@ManyToOne
	@JoinColumn(name="creator_user_id")
	@JsonIgnoreProperties({"posts", "events", "guilds", "cebopets", "comments","guildsCreated", "createdEvents"})
	private User user;
	
	@ManyToMany
	@JoinTable(name="user_has_guild",
	joinColumns=@JoinColumn(name="guild_id"),
	inverseJoinColumns=@JoinColumn(name="user_id"))
	@JsonIgnoreProperties({"posts", "events", "guilds", "cebopets", "comments","guildsCreated", "createdEvents"})
	private List <User> users;
	
	@OneToMany(mappedBy ="guild")
	@JsonIgnoreProperties({"guild","usersAttending", "creator_user"})
	private List<Event> events;
	
	@OneToMany(mappedBy="guild")
	@JsonIgnoreProperties({"guild", "creatorUser"})
	private List<Post> posts;

	
	public Guild() {};
	
	public Guild(int id, String name, String description, Date createDate, String pictureUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.createDate = createDate;
		this.pictureUrl = pictureUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Guild [id=" + id + ", name=" + name + ", description=" + description + ", createDate=" + createDate
				+ ", pictureUrl=" + pictureUrl + "]";
	}
	
	
	
	
	

}
