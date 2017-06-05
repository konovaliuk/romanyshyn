package com.training;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.training.entities.RoleEnum;
import com.training.properties.PagesProperties;

public class PagesMapping {
	public static final Map<String, List<String>> PAGES_MAP;
	private static PagesProperties rb = PagesProperties.getInstance();
	static {
		PAGES_MAP = new LinkedHashMap<>();
		List<String> user = new ArrayList<>();
		List<String> driver = new ArrayList<>();
		List<String> dispatcher = new ArrayList<>();
		List<String> admin = new ArrayList<>();
		
		user.add(rb.getProperty("index"));
		user.add(rb.getProperty("login"));
		user.add(rb.getProperty("create.offer"));
		user.add(rb.getProperty("customers.form"));
		user.add(rb.getProperty("change.language"));
		
		driver.add(rb.getProperty("index"));
		driver.add(rb.getProperty("main"));
		driver.add(rb.getProperty("login"));
		driver.add(rb.getProperty("create.offer"));
		driver.add(rb.getProperty("customers.form"));
		driver.add(rb.getProperty("end.offer"));
		driver.add(rb.getProperty("driver.offer"));
		driver.add(rb.getProperty("logout"));
		driver.add(rb.getProperty("change.language"));
		
		dispatcher.add(rb.getProperty("index"));
		dispatcher.add(rb.getProperty("login"));
		dispatcher.add(rb.getProperty("main"));
		dispatcher.add(rb.getProperty("logout"));
		dispatcher.add(rb.getProperty("create.offer"));
		dispatcher.add(rb.getProperty("customers.form"));
		dispatcher.add(rb.getProperty("update.driver"));
		dispatcher.add(rb.getProperty("update.car"));
		dispatcher.add(rb.getProperty("delete.car"));
		dispatcher.add(rb.getProperty("process.offer"));
		dispatcher.add(rb.getProperty("create.car"));
		dispatcher.add(rb.getProperty("offers"));
		dispatcher.add(rb.getProperty("offer"));
		dispatcher.add(rb.getProperty("cars"));
		dispatcher.add(rb.getProperty("car"));
		dispatcher.add(rb.getProperty("drivers"));
		dispatcher.add(rb.getProperty("driver"));
		dispatcher.add(rb.getProperty("car.form"));
		dispatcher.add(rb.getProperty("change.language"));
		dispatcher.add(rb.getProperty("delete.driver"));
		
		admin.add(rb.getProperty("index"));
		admin.add(rb.getProperty("login"));
		admin.add(rb.getProperty("main"));
		admin.add(rb.getProperty("logout"));
		admin.add(rb.getProperty("create.offer"));
		admin.add(rb.getProperty("customers.form"));
		admin.add(rb.getProperty("change.language"));
		admin.add(rb.getProperty("new.user"));
		admin.add(rb.getProperty("create.user"));
		
		PAGES_MAP.put(RoleEnum.UNREGISTERED.name().toLowerCase(), user);
		PAGES_MAP.put(RoleEnum.DRIVER.name().toLowerCase(), driver);
		PAGES_MAP.put(RoleEnum.DISPATCHER.name().toLowerCase(), dispatcher);
		PAGES_MAP.put(RoleEnum.ADMIN.name().toLowerCase(), admin);
	}
}
