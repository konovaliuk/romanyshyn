package com.training.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.training.dao.DaoFactory;
import com.training.entities.Car;
import com.training.entities.State;

public class CarService {
	public static List<Car> getAllCars() {
		List<Car> cars = DaoFactory.getCarDao().findAll();
		Map<Integer, State> states = DaoFactory.getStateDao().findAllMap();
		for (Car car : cars) {
			Integer stateId = car.getStateId();
			State state = states.get(stateId);
			car.setState(state);
		}
		return cars;
	}
	
	public static List<Car> getAllFreeCars() {
		List<Car> cars = DaoFactory.getCarDao().findAllFreeCars();
		Map<Integer, State> states = DaoFactory.getStateDao().findAllMap();
		for (Car car : cars) {
			Integer stateId = car.getStateId();
			State state = states.get(stateId);
			car.setState(state);
		}
		return cars;
	}
	
	static Map<Integer, Car> getAllCarsMap() {
		List<Car> cars = CarService.getAllCars();
		Map<Integer, Car> carsMap = new LinkedHashMap<>();
		for (Car car : cars) {
			carsMap.put(car.getId(), car);
		}
		return carsMap;
	}
	
	public static Car getCar(Integer id) {
		Car car = DaoFactory.getCarDao().findEntityById(id);
		if (car.getId() == null) {
			return car;
		}
		State state = DaoFactory.getStateDao().findEntityById(car.getStateId());
		car.setState(state);
		return car;
	}
	
	public static boolean deleteCar(Car car) {
		return DaoFactory.getCarDao().delete(car);
	}
	
	public static boolean deleteCar(Integer id) {
		return DaoFactory.getCarDao().delete(id);
	}
	
	public static boolean createCar(Car car) {
		return DaoFactory.getCarDao().create(car);
	}
	
	public static Car updateCar(Car car) {
		return DaoFactory.getCarDao().update(car);
	}
}
