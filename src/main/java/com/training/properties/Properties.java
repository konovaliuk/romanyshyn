package com.training.properties;

import java.util.ResourceBundle;

public class Properties {
	private static Properties instance;
	private ResourceBundle resource;
	private static final String BUNDLE_NAME = "requestparams";
	
	private Properties() {
		
	}
	
	public static Properties getInstance() {
		if (instance == null) {
			instance = new Properties();
			instance.resource = ResourceBundle.getBundle(BUNDLE_NAME);
		}
		return instance;
	}
	
	public String getProperty(String key) {
        return (String) resource.getObject(key);
    }
}
