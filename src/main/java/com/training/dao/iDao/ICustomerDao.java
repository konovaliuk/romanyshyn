package com.training.dao.iDao;

import java.util.List;
import java.util.Map;

import com.training.entities.Customer;

public interface ICustomerDao {
	public List<Customer> findAll();
	public Customer findEntityById(Integer id);
	public boolean delete(Integer id);
	public boolean delete(Customer customer);
	public boolean create(Customer customer);
	public Customer update(Customer customer);
	public Map<Integer, Customer> findAllMap();
	Customer findEntityByEmail(String email);
}
