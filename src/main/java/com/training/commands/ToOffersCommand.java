package com.training.commands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.entities.Offer;
import com.training.properties.RequestParams;
import com.training.services.OfferService;

public class ToOffersCommand implements ICommand {
	
	private static RequestParams rb = RequestParams.getInstance();
	private static final String OFFERS = rb.getProperty("offers");
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		List<Offer> offers = OfferService.getAllOffers();
		request.setAttribute(OFFERS, offers);
		return Pages.OFFERS;
	}

}
