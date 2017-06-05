package com.training.services;

import java.util.List;
import java.util.Map;

import com.training.dao.DaoFactory;
import com.training.entities.Customer;
import com.training.entities.Offer;
import com.training.entities.User;

public class OfferService {

	public static List<Offer> getAllOffers() {
		Map<Integer, User> users = UserService.getAllUsersMap();
		Map<Integer, Customer> customers = DaoFactory.getCustomerDao().findAllMap();
		List<Offer> offers = DaoFactory.getOfferDao().findAll();
		for (Offer offer : offers) {
			offer.setDriver(users.get(offer.getDriverId()));
			offer.setCustomer(customers.get(offer.getCustomerId()));
		}
		return offers;
	}
	
	public static Offer findOfferById(int id) {
		Offer offer = DaoFactory.getOfferDao().findEntityById(id);
		User driver = UserService.findUserById(offer.getDriverId());
		Customer customer = CustomerService.findCustomerById(offer.getCustomerId());
		offer.setCustomer(customer);
		offer.setDriver(driver);
		return offer;
	}
	
	public static Offer findOfferByDriver(int id) {
		Offer offer = DaoFactory.getOfferDao().findEntityByDriver(id);
		if (offer.getId() == null) {
			return null;	
		}
		User driver = UserService.findUserById(offer.getDriverId());
		Customer customer = CustomerService.findCustomerById(offer.getCustomerId());
		offer.setCustomer(customer);
		offer.setDriver(driver);
		return offer;
	}
	
	public static boolean createOffer(Offer offer) {
		return DaoFactory.getOfferDao().create(offer);
	}
	
	public static boolean deleteOffer(Offer offer) {
		return DaoFactory.getOfferDao().delete(offer);
	}
	
	public static boolean deleteOffer(int id) {
		return DaoFactory.getOfferDao().delete(id);
	}
	
	public static Offer updateOffer(Offer offer) {
		return DaoFactory.getOfferDao().update(offer);
	}
}
