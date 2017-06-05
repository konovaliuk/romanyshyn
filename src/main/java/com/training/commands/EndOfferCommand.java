package com.training.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.entities.Car;
import com.training.entities.Offer;
import com.training.entities.OfferStatusEnum;
import com.training.properties.RequestParams;
import com.training.services.CarService;
import com.training.services.OfferService;

public class EndOfferCommand implements ICommand {
	
	private static RequestParams rb = RequestParams.getInstance();
	private static final String OFFER_ID = rb.getProperty("offer.id");
	private static final String STATE_ID = rb.getProperty("state.id");
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int offerId = Integer.valueOf(request.getParameter(OFFER_ID));
		int stateId = Integer.valueOf(request.getParameter(STATE_ID));
		Offer offer = OfferService.findOfferById(offerId);
		offer.setStatus(OfferStatusEnum.DONE.name().toLowerCase());
		OfferService.updateOffer(offer);
		Car car = offer.getDriver().getCar();
		car.setStateId(stateId);
		CarService.updateCar(car);
		return Pages.DRIVER_OFFER;
	}

}
