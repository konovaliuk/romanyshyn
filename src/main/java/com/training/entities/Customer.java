package com.training.entities;

import java.io.Serializable;

public class Customer implements Serializable {
	
	private static final long serialVersionUID = 7305749059090761871L;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private Integer id;
	
	public Customer() {
		
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		} else if (object == this) {
			return true;
		}
		if (!(object instanceof Customer)) {
			return false;
		}
		Customer customer = (Customer) object;
		if (this.firstName.equals(customer.firstName) &&
				this.lastName.equals(customer.lastName) &&
				this.phone.equals(customer.phone) &&
				this.email.equals(customer.email)) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash = 17;
		hash = 31 * hash + firstName.hashCode();
		hash = 31 * hash + lastName.hashCode();
		hash = 31 * hash + phone.hashCode();
		hash = 31 * hash + email.hashCode();
		return hash;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
