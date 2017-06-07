package com.training.services;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.training.dao.DaoFactory;
import com.training.entities.Car;
import com.training.entities.CarStateEnum;
import com.training.entities.Offer;
import com.training.entities.Role;
import com.training.entities.User;

public class UserService {
	
	public static List<User> getAllUsers() {
		List<User> users = DaoFactory.getUserDao().findAll();
		Map<Integer, Car> cars = CarService.getAllCarsMap();
		Map<Integer, Role> roles = DaoFactory.getRoleDao().findAllMap();
		for (User user : users) {
			Integer roleId = user.getRoleId();
			Integer carId = user.getCarId();
			Role role = roles.get(roleId);
			if (carId != null) {
				Car car = cars.get(carId);				
				user.setCar(car);
			}
			user.setRole(role);
			
		}
		return users;
	}
	
	public static List<User> getDriversByParams(Offer offer) {
		List<User> drivers = DaoFactory.getUserDao().findAllFreeDrivers();
		Map<Integer, Car> cars = CarService.getAllCarsMap();
		Map<Integer, Role> roles = DaoFactory.getRoleDao().findAllMap();
		List<User> appropDrivers = new ArrayList<>();
		for (User driver : drivers) {
			Integer roleId = driver.getRoleId();
			Integer carId = driver.getCarId();
			Role role = roles.get(roleId);
			if (carId != null) {
				Car car = cars.get(carId);				
				driver.setCar(car);
			}
			driver.setRole(role);
		}
		for (User driver : drivers) {
			Car car = driver.getCar();
			if (car == null) {
				continue;
			}
			if (offer.getPassangers() <= car.getCapacity()) {
				if (offer.getMaxPrice() >= car.getPrice()) {
					if (offer.isCargo() && !car.hasCargo()) {
					} else {
						if (car.getState().getName().equalsIgnoreCase(CarStateEnum.GOOD.name())){
							appropDrivers.add(driver);
						}
					}
				} 
			} 
		}
		return appropDrivers;
	}
	
	public static List<User> getAllDrivers() {
		List<User> users = DaoFactory.getUserDao().findAllDrivers();
		Map<Integer, Car> cars = CarService.getAllCarsMap();
		Map<Integer, Role> roles = DaoFactory.getRoleDao().findAllMap();
		for (User user : users) {
			Integer roleId = user.getRoleId();
			Integer carId = user.getCarId();
			Role role = roles.get(roleId);
			if (carId != null) {
				Car car = cars.get(carId);				
				user.setCar(car);
			}
			user.setRole(role);
		}
		return users;
	}
	
	public static boolean isDriverFree(Integer id) {
		List<User> drivers = DaoFactory.getUserDao().findAllFreeDrivers();
		for (User driver : drivers) {
			if (id.equals(driver.getId())) {
				return true;
			}
		}
		return false;
	}
	
	public static Map<Integer, User> getAllUsersMap() {
		List<User> users = UserService.getAllUsers();
		Map<Integer, User> userMap = new LinkedHashMap<>();
		for (User user : users) {
			userMap.put(user.getId(), user);
		}
		return userMap;
	}
	
	public static User findUserById(Integer id) {
		User user = DaoFactory.getUserDao().findEntityById(id);
		if (user.getId() == null) {
			return user;
		}
		Role role = DaoFactory.getRoleDao().findEntityById(user.getRoleId());
		if (user.getCarId() != null) {
			Car car = CarService.getCar(user.getCarId());
			user.setCar(car);
		}
		user.setRole(role);
		return user;
	}
	
	public static User findUserByLogin(String login) {
		User user = DaoFactory.getUserDao().findEntityByLogin(login);
		if (user.getId() == null) {
			return user;
		}
		Role role = DaoFactory.getRoleDao().findEntityById(user.getRoleId());
		if (user.getCarId() != null) {
			Car car = CarService.getCar(user.getCarId());
			user.setCar(car);
		}
		user.setRole(role);
		return user;
	}
	
	public static User updateUser(User user) {
		DaoFactory.getUserDao().update(user);
		return user;
	}
	
	public static boolean deleteUser(User user) {
		return DaoFactory.getUserDao().delete(user);
	}
	
	public static boolean deleteUser(Integer id) {
		return DaoFactory.getUserDao().delete(id);
	}
	
	public static boolean createUser(User user) {
		return DaoFactory.getUserDao().create(user);
	}
}
