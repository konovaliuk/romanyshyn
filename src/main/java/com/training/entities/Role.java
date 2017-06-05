package com.training.entities;

public class Role {
	
	private Integer id;
	private String name;
	
	public Role() {
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}

