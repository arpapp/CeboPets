package com.skilldistillery.cebopets.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

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

	@Override
	public String toString() {
		return "Guild [id=" + id + ", name=" + name + ", description=" + description + ", createDate=" + createDate
				+ ", pictureUrl=" + pictureUrl + "]";
	}
	
	
	
	
	

}
