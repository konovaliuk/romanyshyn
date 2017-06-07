package com.training.entities;

import java.io.Serializable;

public class Role implements Serializable {
	
	private static final long serialVersionUID = 129687630092538604L;
	private Integer id;
	private String name;
	
	public Role() {
		
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		} else if (object == this) {
			return true;
		}
		if (!(object instanceof Role)) {
			return false;
		}
		Role role = (Role) object;
		if (name.equals(role.name)) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash = 17;
		hash = 31 * hash + name.hashCode();
		hash = 31 * hash + id.hashCode();
		return hash;
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

