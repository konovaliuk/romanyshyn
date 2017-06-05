package com.training.commands;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.entities.Offer;
import com.training.entities.User;
import com.training.properties.RequestParams;
import com.training.services.OfferService;
import com.training.services.UserService;

public class ToOfferCommand implements ICommand {
	
	private static RequestParams rb = RequestParams.getInstance();
	private static final String OFFER_ID = rb.getProperty("offer.id");
	private static final String OFFER = rb.getProperty("offer");
	private static final String DRIVERS = rb.getProperty("drivers");
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int offerId = Integer.valueOf(request.getParameter(OFFER_ID));
		Offer offer = OfferService.findOfferById(offerId);
		List<User> drivers = UserService.getDriversByParams(offer);
		request.setAttribute(OFFER, offer);
		request.setAttribute(DRIVERS, drivers);
		return Pages.OFFER;
		
	}

}
