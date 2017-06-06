package com.training;

import org.junit.Test;

import com.training.entities.Offer;
import com.training.services.util.OfferValidator;
import com.training.services.util.Validator;

import static org.junit.Assert.*;

public class ValidatorTest {
	
	@Test
	public void testValidLatinOffer() {
		Offer offer = new Offer();
		String cityFrom = "Kyiv";
		String cityTo = "Minsk";
		offer.setPlaceFrom(cityFrom);
		offer.setPlaceTo(cityTo);
		Validator validator = new Validator();
		validator.setValidatorObject(new OfferValidator());
		Boolean result = validator.check(offer);
		Boolean expectedResult = true;
		assertEquals(expectedResult, result);
	}
	
	@Test
	public void testValidCyrOffer() {
		Offer offer = new Offer();
		String cityFrom = "Київ";
		String cityTo = "Мінськ";
		offer.setPlaceFrom(cityFrom);
		offer.setPlaceTo(cityTo);
		Validator validator = new Validator();
		validator.setValidatorObject(new OfferValidator());
		Boolean result = validator.check(offer);
		Boolean expectedResult = true;
		assertEquals(expectedResult, result);
	}
	
	@Test
	public void testInvalidCyrOffer() {
		Offer offer = new Offer();
		String cityFrom = "Киї№в";
		String cityTo = "Мінськ";
		offer.setPlaceFrom(cityFrom);
		offer.setPlaceTo(cityTo);
		Validator validator = new Validator();
		validator.setValidatorObject(new OfferValidator());
		Boolean result = validator.check(offer);
		Boolean expectedResult = false;
		assertEquals(expectedResult, result);
	}
}
