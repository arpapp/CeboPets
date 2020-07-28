package com.skilldistillery.cebopets.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Relationship {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private Boolean enabled;
	
	@Column(name="create_date")
	@CreationTimestamp
	private Date createDate;
	
	@Column(name="marriage_date")
	private Date marriageDate;
	
	@OneToMany(mappedBy="relationship")
	private List<CeboPet> ceboPets;

	public Relationship() {}

	public Relationship(int id, Status status, Boolean enabled, Date createDate, Date marriageDate) {
		super();
		this.id = id;
		this.status = status;
		this.enabled = enabled;
		this.createDate = createDate;
		this.marriageDate = marriageDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getMarriageDate() {
		return marriageDate;
	}

	public void setMarriageDate(Date marriageDate) {
		this.marriageDate = marriageDate;
	}
	

	public List<CeboPet> getCeboPets() {
		return ceboPets;
	}

	public void setCeboPets(List<CeboPet> ceboPets) {
		this.ceboPets = ceboPets;
	}

	@Override
	public String toString() {
		return "Relationship [id=" + id + ", status=" + status + ", enabled=" + enabled + ", createDate=" + createDate
				+ ", marriageDate=" + marriageDate + "]";
	}	
	

}
