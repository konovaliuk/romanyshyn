package com.training.services.util;

import java.util.regex.Pattern;

import com.training.entities.Customer;

public class CustomerValidator implements ValidatorObject {

	@Override
	public boolean check(Object object) {
		Customer customer = (Customer) object;
		if (!Pattern.matches(RegExp.NAME_REGEXP, customer.getFirstName())){
			return false;
		}
		if (!Pattern.matches(RegExp.NAME_REGEXP, customer.getLastName())){
			return false;
		}
		if (!Pattern.matches(RegExp.CELL_PHONE_REGEXP, customer.getPhone())){
			return false;
		}
		if (!Pattern.matches(RegExp.EMAIL_REGEXP, customer.getEmail())){
			return false;
		}
		return true;
	}

}
