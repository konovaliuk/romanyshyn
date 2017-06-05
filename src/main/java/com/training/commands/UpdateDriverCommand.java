package com.training.commands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.entities.Car;
import com.training.entities.User;
import com.training.properties.RequestParams;
import com.training.services.CarService;
import com.training.services.UserService;

public class UpdateDriverCommand implements ICommand{
	private static RequestParams rb = RequestParams.getInstance();
	
	private static final String FIRST_NAME = rb.getProperty("first.name");
	private static final String CAR_ID = rb.getProperty("car.id");
	private static final String LAST_NAME = rb.getProperty("last.name");
	private static final String DRIVER_ID = rb.getProperty("driver.id");
	private static final String DRIVER = rb.getProperty("driver");
	private static final String CARS = rb.getProperty("cars");
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String firstName = request.getParameter(FIRST_NAME);
		String lastName = request.getParameter(LAST_NAME);
		int driverId = Integer.valueOf(request.getParameter(DRIVER_ID));
		int carId = Integer.valueOf(request.getParameter(CAR_ID));
		User driver = UserService.findUserById(driverId);
		driver.setCarId(carId);
		driver.setFirstName(firstName);
		driver.setLastName(lastName);
		UserService.updateUser(driver);
		driver = UserService.findUserById(driverId);
		List<Car> freeCars = CarService.getAllFreeCars();
		request.setAttribute(DRIVER, driver);
		request.setAttribute(CARS, freeCars);
		return Pages.DRIVER;
	}

}
