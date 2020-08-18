package com.skilldistillery.cebopets.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Breed {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name="picture_url")
	private String pictureUrl;
	
	private String trait;
	
	@OneToMany(mappedBy="breed")
	@JsonIgnore
	private List<Cebopet> ceboPets;

	public Breed() {
		super();
	}



	public Breed(int id, String name, String pictureUrl, String trait) {
		super();
		this.id = id;
		this.name = name;
		this.pictureUrl = pictureUrl;
		this.trait = trait;
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



	public String getPictureUrl() {
		return pictureUrl;
	}



	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}



	public String getTrait() {
		return trait;
	}



	public void setTrait(String trait) {
		this.trait = trait;
	}
	
	



	public List<Cebopet> getCeboPets() {
		return ceboPets;
	}



	public void setCeboPets(List<Cebopet> ceboPets) {
		this.ceboPets = ceboPets;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pictureUrl == null) ? 0 : pictureUrl.hashCode());
		result = prime * result + ((trait == null) ? 0 : trait.hashCode());
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
		Breed other = (Breed) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pictureUrl == null) {
			if (other.pictureUrl != null)
				return false;
		} else if (!pictureUrl.equals(other.pictureUrl))
			return false;
		if (trait == null) {
			if (other.trait != null)
				return false;
		} else if (!trait.equals(other.trait))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Breed [id=" + id + ", name=" + name + ", pictureUrl=" + pictureUrl + ", trait=" + trait + "]";
	}
	
	
	
	

}
