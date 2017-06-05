package com.training.commands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.entities.State;
import com.training.properties.RequestParams;
import com.training.services.StateService;

public class ToNewCarCommand implements ICommand {
	
	private static RequestParams rb = RequestParams.getInstance();
	private static final String STATES = rb.getProperty("states");
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		List<State> states = StateService.getAllStates();
		request.setAttribute(STATES, states);
		return Pages.NEW_CAR;
	}

}
