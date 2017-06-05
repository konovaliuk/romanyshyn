package com.training.commands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.entities.Car;
import com.training.properties.RequestParams;
import com.training.services.CarService;

public class NewCarCommand implements ICommand{
	
	private static RequestParams rb = RequestParams.getInstance();
	private static final String MARK = rb.getProperty("mark");
	private static final String PRICE = rb.getProperty("price");
	private static final String CARGO = rb.getProperty("cargo");
	private static final String CAPACITY = rb.getProperty("capacity");
	private static final String STATE_ID = rb.getProperty("state.id");
	private static final String CARS = rb.getProperty("cars");
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String mark = request.getParameter(MARK);
		int price = Integer.valueOf(request.getParameter(PRICE));
		boolean cargo = (request.getParameterValues(CARGO) == null)? false: true;
		int capacity = Integer.valueOf(request.getParameter(CAPACITY));
		int stateId = Integer.valueOf(request.getParameter(STATE_ID));
		Car car = new Car();
		car.setMark(mark);
		car.setPrice(price);
		car.setCargo(cargo);
		car.setCapacity(capacity);
		car.setStateId(stateId);
		CarService.createCar(car);
		List<Car> cars = CarService.getAllCars();
		request.setAttribute(CARS, cars);
		return Pages.CARS;
	}
	
}
