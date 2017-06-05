package com.training.properties;

import java.util.ResourceBundle;

public class PagesProperties {
	private static PagesProperties instance;
	private ResourceBundle resource;
	private static final String BUNDLE_NAME = "pages";
	
	private PagesProperties() {
		
	}
	
	public static PagesProperties getInstance() {
		if (instance == null) {
			instance = new PagesProperties();
			instance.resource = ResourceBundle.getBundle(BUNDLE_NAME);
		}
		return instance;
	}
	
	public String getProperty(String key) {
        return (String) resource.getObject(key);
    }
}
