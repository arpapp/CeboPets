package com.skilldistillery.cebopets.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	
	private String password;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	private Boolean enabled;
	
	@OneToMany(mappedBy="creatorUser")
	private List <Post> posts;
	
	@OneToMany(mappedBy="user")
	private List <Comment> comments;
	
	@ManyToMany(mappedBy="users")
	private List <Guild> guilds;
	
	@OneToMany(mappedBy="user")
	private List <Guild> guildsCreated;
	
	@OneToMany(mappedBy="user")
	private List <Cebopet> cebopets;
	
	@OneToMany(mappedBy="creatorUser")
	private List <Event> createdEvents;
	
	@ManyToMany(mappedBy="usersAttending")
	private List <Event> events;
	
	private User() {}

	public User(int id, String username, String password, String firstName, String lastName, Boolean enabled) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.enabled = enabled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Guild> getGuilds() {
		return guilds;
	}

	public void setGuilds(List<Guild> guilds) {
		this.guilds = guilds;
	}

	public List<Guild> getGuildsCreated() {
		return guildsCreated;
	}

	public void setGuildsCreated(List<Guild> guildsCreated) {
		this.guildsCreated = guildsCreated;
	}

	public List<Cebopet> getCebopets() {
		return cebopets;
	}

	public void setCebopets(List<Cebopet> cebopets) {
		this.cebopets = cebopets;
	}

	public List<Event> getCreatedEvents() {
		return createdEvents;
	}

	public void setCreatedEvents(List<Event> createdEvents) {
		this.createdEvents = createdEvents;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", enabled=" + enabled + "]";
	}
	
	
	
	

}
