package com.training.entities;

import java.util.Date;

public class Offer{
	
	private Integer id;
	private User driver;
	private String status;
	private Date date;
	private String placeFrom;
	private String placeTo;
	private Customer customer;
	private Integer customerId;
	private Integer driverId;
	private boolean cargo;
	private Integer passangers;
	private Integer maxPrice;
	
	public Offer() {

	}
	
	public Integer getId() {
		return this.id;
	}
	
	public User getDriver() {
		return this.driver;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public String getPlaceFrom() {
		return this.placeFrom;
	}
	
	public String getPlaceTo() {
		return this.placeTo;
	}
	
	public Integer getCustomerId() {
		return this.customerId;
	}
	
	public Integer getDriverId() {
		return this.driverId;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}
	
	public void setDriver(User driver) {
		this.driver = driver;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setPlaceFrom(String placeFrom) {
		this.placeFrom = placeFrom;
	}
	
	public void setPlaceTo(String placeTo) {
		this.placeTo = placeTo;
	}
	
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public boolean isCargo() {
		return cargo;
	}

	public void setCargo(boolean cargo) {
		this.cargo = cargo;
	}

	public Integer getPassangers() {
		return passangers;
	}

	public void setPassangers(int passangers) {
		this.passangers = passangers;
	}

	public Integer getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}
}
