package com.spgcrud.druc.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.*;
@Getter
@Setter
@Data
@Entity
public class Comment {// comments are many i,e why i am using set,list, (set)
	//if  i used list i can have duplicate comments
@Id
@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	private String body;
	private String email;
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="lead_id",nullable = false)//defining how do we join 2 tables
	private Lead lead;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Lead getLead() {
		return lead;
	}

	public void setLead(Lead lead) {
		this.lead = lead;
	}
	
}
