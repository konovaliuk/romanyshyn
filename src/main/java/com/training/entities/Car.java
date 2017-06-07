package com.training.entities;

import java.io.Serializable;

public class Car implements Serializable{
	
	private static final long serialVersionUID = -3963609849368438666L;
	private Integer id;
	private Integer stateId;
	private State state;
	private String mark;
	private Integer price;
	private boolean cargo;
	private Integer capacity;
	
	public Car() {
		
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		} else if (object == this) {
			return true;
		}
		if (!(object instanceof Car)) {
			return false;
		}
		Car car = (Car) object;
		if (this.state.equals(car.state) &&
				this.mark.contentEquals(car.mark) &&
				this.price.equals(car.price) &&
				this.cargo == car.cargo &&
				this.capacity.equals(car.capacity)) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash = 17;
		hash = 31 * hash + state.hashCode();
		hash = 31 * hash + mark.hashCode();
		hash = 31 * hash + price.hashCode();
		hash = 31 * hash + capacity.hashCode();
		return hash;
	}
	
	public boolean isCargo() {
		return this.cargo;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public State getState() {
		return this.state;
	}
	
	public String getMark() {
		return this.mark;
	}
	
	public Integer getPrice() {
		return this.price;
	}
	
	public Integer getStateId() {
		return this.stateId;
	}
	
	public boolean hasCargo() {
		return this.cargo;
	}
	
	public Integer getCapacity() {
		return this.capacity;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setCargo(boolean cargo) {
		this.cargo = cargo;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
}
