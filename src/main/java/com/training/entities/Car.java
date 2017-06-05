package com.training.entities;

public class Car {
	private Integer id;
	private Integer stateId;
	private State state;
	private String mark;
	private Integer price;
	private boolean cargo;
	private Integer capacity;
	
	public Car() {
		
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
