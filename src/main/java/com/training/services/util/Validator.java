package com.training.services.util;


public class Validator {
	
	private ValidatorObject validatorObject;
	
	public void setValidatorObject(ValidatorObject validatorObject) {
		this.validatorObject = validatorObject;
	}
	
	public boolean check(Object object) {
		return validatorObject.check(object);
	}
}
