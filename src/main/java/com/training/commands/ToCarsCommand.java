package com.training.commands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.entities.Car;
import com.training.properties.RequestParams;
import com.training.services.CarService;

public class ToCarsCommand implements ICommand {
	
	private static RequestParams rb = RequestParams.getInstance();
	private static final String CARS = rb.getProperty("cars");
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		List<Car> cars = CarService.getAllCars();
		request.setAttribute(CARS, cars);
		return Pages.CARS;
	}
	
}
