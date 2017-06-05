package com.training.services;

import java.util.List;

import com.training.dao.DaoFactory;
import com.training.entities.Customer;

public class CustomerService {
	public static List<Customer> getAllCustomers() {
		return DaoFactory.getCustomerDao().findAll();
	}
	
	public static Customer findCustomerById(int id) {
		return DaoFactory.getCustomerDao().findEntityById(id);
	}
	
	public static boolean createCustomer(Customer customer) {
		return DaoFactory.getCustomerDao().create(customer);
	}
	
	public static Customer updateCustomer(Customer customer) {
		return DaoFactory.getCustomerDao().update(customer);
	}
	
	public static boolean deleteCustomer(Customer customer) {
		return DaoFactory.getCustomerDao().delete(customer);
	}
	
	public static boolean deleteCustomer(int id) {
		return DaoFactory.getCustomerDao().delete(id);
	}
	
	public static Customer findCustomerByEmail(String email) {
		return DaoFactory.getCustomerDao().findEntityByEmail(email);
	}
	
}
