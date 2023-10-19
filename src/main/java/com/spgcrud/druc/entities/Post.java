package com.spgcrud.druc.entities;


public class Post {

	private long id;
	private String name;
	private String description;
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public Post(long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
	  	this.description = description;
	}
	
	@Override
	public String toString() {
		return "Post [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	
}
