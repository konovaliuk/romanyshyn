package com.training.commands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.entities.Car;
import com.training.entities.User;
import com.training.properties.RequestParams;
import com.training.services.CarService;
import com.training.services.UserService;

public class ToDriverCommand implements ICommand {
	
	private static RequestParams rb = RequestParams.getInstance();
	private static final String DRIVER_ID = rb.getProperty("driver.id");
	private static final String DRIVER = rb.getProperty("driver");
	private static final String CARS = rb.getProperty("cars");
	private static final String DRIVER_FREE = rb.getProperty("driver.free");
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int driverId = Integer.valueOf((request.getParameter(DRIVER_ID)));
		User driver = UserService.findUserById(driverId);
		boolean isDriverFree = UserService.isDriverFree(driverId);
		List<Car> freeCars = CarService.getAllFreeCars();
		request.setAttribute(DRIVER_FREE, isDriverFree);
		request.setAttribute(DRIVER, driver);
		request.setAttribute(CARS, freeCars);
		return Pages.DRIVER;
	}

}
