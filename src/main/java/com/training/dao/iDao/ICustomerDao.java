package com.training.dao.iDao;

import java.util.List;
import java.util.Map;

import com.training.entities.Customer;
/**
 * 
 * @author Olexandr
 *
 */
public interface ICustomerDao {
	
	/**
	 * @return	list of customers
	 */
	public List<Customer> findAll();
	
	/**
	 * @param	id
	 * @return	Customer with id
	 */
	public Customer findEntityById(Integer id);
	
	/**
	 * @param	id
	 * @return	true if record was deleted
	 */
	public boolean delete(Integer id);
	
	
	/**
	 * @param	customer
	 * @return	true if record was deleted
	 */
	public boolean delete(Customer customer);
	
	/**
	 * @param	customer
	 * @return	true if record was created
	 */
	public boolean create(Customer customer);
	
	/**
	 * @param	customer
	 * @return	customer after database was updated
	 */
	public Customer update(Customer customer);
	
	/**
	 * @return	Map with id as a key and customer as a value
	 */
	public Map<Integer, Customer> findAllMap();
	
	/**
	 * @param	email
	 * @return	return empty object if there is no customer with email
	 */
	public Customer findEntityByEmail(String email);
}
