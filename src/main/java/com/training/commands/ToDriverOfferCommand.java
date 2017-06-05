package com.training.commands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.entities.Offer;
import com.training.entities.State;
import com.training.entities.User;
import com.training.properties.RequestParams;
import com.training.services.OfferService;
import com.training.services.StateService;

public class ToDriverOfferCommand implements ICommand {
	
	private static RequestParams rb = RequestParams.getInstance();
	private static final String USER = rb.getProperty("user");
	private static final String OFFER = rb.getProperty("offer");
	private static final String STATES = rb.getProperty("states");
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute(USER);
		Offer offer = OfferService.findOfferByDriver(user.getId());
		List<State> states = StateService.getAllStates();
		request.setAttribute(OFFER, offer);
		request.setAttribute(STATES, states);
		return Pages.DRIVER_OFFER;
	}

}
