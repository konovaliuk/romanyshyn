package com.training.commands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.entities.User;
import com.training.properties.RequestParams;
import com.training.services.UserService;

public class ToDriversCommand implements ICommand {
	private static RequestParams rb = RequestParams.getInstance();
	private static final String DRIVERS = rb.getProperty("drivers");
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		List<User> drivers = UserService.getAllDrivers();
		request.setAttribute(DRIVERS, drivers);
		return Pages.DRIVERS;
	}

}
