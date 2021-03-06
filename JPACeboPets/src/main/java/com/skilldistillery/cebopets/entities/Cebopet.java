package com.skilldistillery.cebopets.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Cebopet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name="hunger_level")
	private int hungerLevel;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private boolean enabled;
	
	@ManyToOne
	@JoinColumn(name="breed_id")
	private Breed breed;
	
	@ManyToOne
	@JsonIgnoreProperties({"posts", "comments", "guilds","cebopets","events","guildsCreated","createdEvents"})
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JsonIgnoreProperties({"ceboPets"})
	@JoinColumn(name="relationship_id")
	private Relationship relationship;

	public Cebopet() {
		super();
	}

	public Cebopet(int id, String name, int hungerLevel, Gender gender, boolean enabled) {
		super();
		this.id = id;
		this.name = name;
		this.hungerLevel = hungerLevel;
		this.gender = gender;
		this.enabled = enabled;
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

	public int getHungerLevel() {
		return hungerLevel;
	}

	public void setHungerLevel(int hungerLevel) {
		this.hungerLevel = hungerLevel;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	

	public Breed getBreed() {
		return breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Relationship getRelationship() {
		return relationship;
	}

	public void setRelationship(Relationship relationship) {
		this.relationship = relationship;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + hungerLevel;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Cebopet other = (Cebopet) obj;
		if (enabled != other.enabled)
			return false;
		if (gender != other.gender)
			return false;
		if (hungerLevel != other.hungerLevel)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CeboPet [id=" + id + ", name=" + name + ", hungerLevel=" + hungerLevel + ", gender=" + gender
				+ ", enabled=" + enabled + "]";
	}
	
	

}
