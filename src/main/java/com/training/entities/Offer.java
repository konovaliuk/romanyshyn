package com.training.entities;

import java.io.Serializable;
import java.util.Date;

public class Offer implements Serializable{
	
	private static final long serialVersionUID = 5150400539222397910L;
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
	
	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		} else if (object == this) {
			return true;
		}
		if (!(object instanceof Offer)) {
			return false;
		}
		Offer offer = (Offer) object;
		if (this.driver.equals(offer.driver) &&
				this.placeFrom.equals(offer.placeFrom) &&
				this.placeTo.equals(offer.placeTo) &&
				this.customer.equals(offer.customer) &&
				this.date.equals(offer.date) &&
				this.maxPrice.equals(offer.maxPrice) &&
				this.status.equals(offer.status)) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash = 17;
		hash = 31 * hash + placeFrom.hashCode();
		hash = 31 * hash + placeTo.hashCode();
		hash = 31 * hash + customer.hashCode();
		hash = 31 * hash + date.hashCode();
		hash = 31 * hash + maxPrice.hashCode();
		hash = 31 * hash + status.hashCode();
		return hash;
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
