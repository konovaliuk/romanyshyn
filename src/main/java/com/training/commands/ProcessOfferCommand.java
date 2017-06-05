package com.training.commands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.entities.Offer;
import com.training.entities.OfferStatusEnum;
import com.training.properties.RequestParams;
import com.training.services.OfferService;

public class ProcessOfferCommand implements ICommand {
	private static RequestParams rb = RequestParams.getInstance();
	private static final String OFFER_ID = rb.getProperty("offer.id");
	private static final String DRIVER_ID = rb.getProperty("driver.id");
	private static final String OFFERS = rb.getProperty("offers");
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int offerId = Integer.valueOf(request.getParameter(OFFER_ID));
		int driverId = Integer.valueOf(request.getParameter(DRIVER_ID));
		Offer offer = OfferService.findOfferById(offerId);
		offer.setStatus(OfferStatusEnum.ACTIVE.name().toLowerCase());
		offer.setDriverId(driverId);
		OfferService.updateOffer(offer);
		List<Offer> offers = OfferService.getAllOffers();
		request.setAttribute(OFFERS, offers);
		return Pages.OFFERS;
	}

}
