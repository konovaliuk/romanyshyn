package com.training.commands;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.training.entities.Customer;
import com.training.entities.Offer;
import com.training.entities.OfferStatusEnum;
import com.training.properties.RequestParams;
import com.training.services.CustomerService;
import com.training.services.OfferService;
import com.training.services.util.CustomerValidator;
import com.training.services.util.OfferValidator;
import com.training.services.util.Validator;

public class CreateOfferCommand implements ICommand{
	
	private static Logger logger = Logger.getLogger(CreateOfferCommand.class);
	private static RequestParams rb = RequestParams.getInstance();
	private static final String OFFER_TIME = rb.getProperty("offer.time");
	private static final String PLACE_FROM = rb.getProperty("place.from");
	private static final String PLACE_TO = rb.getProperty("place.to");
	private static final String CAPACITY = rb.getProperty("capacity");
	private static final String CARGO = rb.getProperty("cargo");
	private static final String PRICE = rb.getProperty("price");
	private static final String EMAIL = rb.getProperty("email");
	private static final String PHONE = rb.getProperty("phone");
	private static final String FIRST_NAME = rb.getProperty("first.name");
	private static final String LAST_NAME = rb.getProperty("last.name");
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Validator validator = new Validator();
		String dateFromForm = request.getParameter(OFFER_TIME).replace("T", ":");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM:HH:mm");
		Date date = null;
		try {
			date = formatter.parse(dateFromForm);
		} catch (ParseException e) {
			System.out.println("unable to parse date");
		}
		String placeFrom = request.getParameter(PLACE_FROM);
		String placeTo = request.getParameter(PLACE_TO);
		int passengers = Integer.valueOf(request.getParameter(CAPACITY));
		String[] cargoArr = request.getParameterValues(CARGO);
		boolean cargo = false;
		if (cargoArr != null) {
			cargo = true;
		}
		int maxPrice = Integer.valueOf(request.getParameter(PRICE));
		String email = request.getParameter(EMAIL);
		String phone = request.getParameter(PHONE);
		String firstName = request.getParameter(FIRST_NAME);
		String lastName = request.getParameter(LAST_NAME);
		Customer customer = CustomerService.findCustomerByEmail(email);
		if (customer.getEmail() == null) {
			customer = new Customer();
			customer.setEmail(email);
			customer.setPhone(phone);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);			
			validator.setValidatorObject(new CustomerValidator());
			if (!validator.check(customer)) {
				logger.error("Invalid customer data");
				return Pages.INDEX;
			}
			CustomerService.createCustomer(customer);
			customer = CustomerService.findCustomerByEmail(email);
		}
		Offer offer = new Offer();
		offer.setCargo(cargo);
		offer.setCustomerId(customer.getId());
		offer.setDate(date);
		offer.setMaxPrice(maxPrice);
		offer.setPassangers(passengers);
		offer.setStatus(OfferStatusEnum.PENDING.name().toLowerCase());
		offer.setPlaceFrom(placeFrom);
		offer.setPlaceTo(placeTo);
		validator.setValidatorObject(new OfferValidator());
		if (!validator.check(offer)) {
			logger.error("Invalid customer data");
			return Pages.INDEX;
		}
		OfferService.createOffer(offer);
		return Pages.INDEX;
	}
	
}
