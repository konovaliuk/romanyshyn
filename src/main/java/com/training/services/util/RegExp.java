package com.training.services.util;

public interface RegExp {
	    String NAME_REGEXP = "^[A-Z�-߯�][a-z�-���]{2,30}$";
	    String EMAIL_REGEXP = "^[A-z0-9_.]{1,30}@([A-z]+[A-z0-9]{1,15}.){1,2}([A-z]+[A-z0-9]{1,15})$";
	    String CELL_PHONE_REGEXP = "([\\+]\\d{2}\\s?)?(([\\(\\s]\\d{3}[\\)\\s])|" +
	            "(\\d{3}))[\\s-]?\\d{3}[\\s-]?\\d{2}[\\s-]?\\d{2}$";
	    String CITY = "^[A-Z�-߯�][a-z�-���]{3,20}$";
}
