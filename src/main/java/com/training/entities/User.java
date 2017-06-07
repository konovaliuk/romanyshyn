package com.training.entities;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = -2241869643311838770L;
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private Integer id;
	private Integer carId;
	private Integer roleId;
	private Role role;
	private Car car;
	
	public User() {
		
	}
	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		} else if (object == this) {
			return true;
		}
		if (!(object instanceof User)) {
			return false;
		}
		User user = (User) object;
		if (this.firstName.equals(user.firstName) &&
				this.lastName.equals(user.lastName) &&
				this.login.equals(user.login)) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash = 17;
		hash = 31 * hash + firstName.hashCode();
		hash = 31 * hash + lastName.hashCode();
		hash = 31 * hash + login.hashCode();
		hash = 31 * hash + password.hashCode();
		return hash;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public Integer getRoleId() {
		return roleId;
	}
	
	public Integer getCarId() {
		return carId;
	}
	
	public Car getCar() {
		return this.car;
	}
	
	public Role getRole() {
		return this.role;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setCar(Car car) {
		this.car = car;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	public void setCarId(Integer carId) {
		this.carId = carId;
	}

}
