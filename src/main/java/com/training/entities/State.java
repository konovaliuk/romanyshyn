package com.training.entities;

import java.io.Serializable;

public class State implements Serializable{
	
	private static final long serialVersionUID = -5458746497324541847L;
	private String name;
	private Integer id;
	
	public State() {
		
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		} else if (object == this) {
			return true;
		}
		if (!(object instanceof State)) {
			return false;
		}
		State state = (State) object;
		if (name.equals(state.name)) {
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
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
