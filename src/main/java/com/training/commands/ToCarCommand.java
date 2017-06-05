package com.training.commands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.entities.Car;
import com.training.entities.State;
import com.training.properties.RequestParams;
import com.training.services.CarService;
import com.training.services.StateService;

public class ToCarCommand implements ICommand {
	
	private static RequestParams rb = RequestParams.getInstance();
	private static final String CAR_ID = rb.getProperty("car.id");
	private static final String STATES = rb.getProperty("states");
	private static final String CAR = rb.getProperty("car");
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int carId = Integer.valueOf((request.getParameter(CAR_ID)));
		Car car = CarService.getCar(carId);
		List<State> states = StateService.getAllStates();
		request.setAttribute(STATES, states);
		request.setAttribute(CAR, car);
		return Pages.CAR;
	}

}
