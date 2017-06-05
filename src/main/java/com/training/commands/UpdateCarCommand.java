package com.training.commands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.entities.Car;
import com.training.properties.RequestParams;
import com.training.services.CarService;

public class UpdateCarCommand implements ICommand {
	
	private static RequestParams rb = RequestParams.getInstance();
	private static final String CAR_ID = rb.getProperty("car.id");
	private static final String STATE_ID = rb.getProperty("state.id");
	private static final String CAR = rb.getProperty("car");
	private static final String CARS = rb.getProperty("cars");
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int carId = Integer.valueOf(request.getParameter(CAR_ID));
		int stateId = Integer.valueOf(request.getParameter(STATE_ID));
		Car car = CarService.getCar(carId);
		car.setStateId(stateId);
		CarService.updateCar(car);
		request.setAttribute(CAR, car);
		List<Car> cars = CarService.getAllCars();
		request.setAttribute(CARS, cars);
		return Pages.CARS;
	}

}
