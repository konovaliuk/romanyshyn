package com.training.services.util;

import java.util.regex.Pattern;

import com.training.entities.Offer;

public class OfferValidator implements ValidatorObject{

	@Override
	public boolean check(Object object) {
		Offer offer = (Offer) object;
		if (!Pattern.matches(RegExp.CITY, offer.getPlaceFrom())){
			return false;
		}
		if (!Pattern.matches(RegExp.CITY, offer.getPlaceTo())){
			return false;
		}
		return true;
	}

}
