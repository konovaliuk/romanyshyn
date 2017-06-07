package com.training.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.training.dao.daoImpl.columns.CustomerCols;
import com.training.dao.daoImpl.util.SQLQuery;
import com.training.dao.iDao.ICustomerDao;
import com.training.entities.Customer;
import com.training.pool.ConnectionPool;

public class CustomerDao implements ICustomerDao {
	
	private static Logger logger = Logger.getLogger(CustomerDao.class);
	private static CustomerDao instance;
	
	private CustomerDao() {

	}
	
	public static CustomerDao getInstance() {
		if (instance == null) {
			instance = new CustomerDao();
		}
		return instance;
	}
	
	@Override
	public List<Customer> findAll() {
		List<Customer> customers = new ArrayList<>();
		try (Connection connection = ConnectionPool.getConnection()) {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQLQuery.SELECT_ALL_CUSTOMERS);
			while (rs.next()) {
				Customer customer = new Customer();				
				int customerId = rs.getInt(CustomerCols.CUSTOMER_ID);
				String firstName = rs.getString(CustomerCols.FIRST_NAME);
				String lastName = rs.getString(CustomerCols.LAST_NAME);
				String phone = rs.getString(CustomerCols.PHONE);
				String email = rs.getString(CustomerCols.EMAIL);				
				customer.setId(customerId);
				customer.setFirstName(firstName);
				customer.setLastName(lastName);
				customer.setPhone(phone);
				customer.setEmail(email);				
				customers.add(customer);
			}
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return customers;
	}
	
	@Override
	public Map<Integer, Customer> findAllMap() {
		Map<Integer, Customer> customers = new LinkedHashMap<>();
		try (Connection connection = ConnectionPool.getConnection()) {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQLQuery.SELECT_ALL_CUSTOMERS);
			while (rs.next()) {
				Customer customer = new Customer();				
				int customerId = rs.getInt(CustomerCols.CUSTOMER_ID);
				String firstName = rs.getString(CustomerCols.FIRST_NAME);
				String lastName = rs.getString(CustomerCols.LAST_NAME);
				String phone = rs.getString(CustomerCols.PHONE);
				String email = rs.getString(CustomerCols.EMAIL);				
				customer.setId(customerId);
				customer.setFirstName(firstName);
				customer.setLastName(lastName);
				customer.setPhone(phone);
				customer.setEmail(email);				
				customers.put(customer.getId(), customer);
			}
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return customers;
	}

	@Override
	public Customer findEntityById(Integer id) {
		Customer customer = new Customer();
		try (Connection connection = ConnectionPool.getConnection()) {
			PreparedStatement st = connection.prepareStatement(SQLQuery.FIND_CUSTOMER_BY_ID);
			st.setInt(1, id);
			try (ResultSet rs = st.executeQuery()) {
				while (rs.next()) {
					int customerId = rs.getInt(CustomerCols.CUSTOMER_ID);
					String firstName = rs.getString(CustomerCols.FIRST_NAME);
					String lastName = rs.getString(CustomerCols.LAST_NAME);
					String phone = rs.getString(CustomerCols.PHONE);
					String email = rs.getString(CustomerCols.EMAIL);				
					customer.setId(customerId);
					customer.setFirstName(firstName);
					customer.setLastName(lastName);
					customer.setPhone(phone);
					customer.setEmail(email);
				}
			}
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return customer;
	}
	
	@Override
	public Customer findEntityByEmail(String email) {
		Customer customer = new Customer();
		try (Connection connection = ConnectionPool.getConnection()) {
			PreparedStatement st = connection.prepareStatement(SQLQuery.FIND_CUSTOMER_BY_EMAIL);
			st.setString(1, email);
			try (ResultSet rs = st.executeQuery()) {
				while (rs.next()) {
					int customerId = rs.getInt(CustomerCols.CUSTOMER_ID);
					String firstName = rs.getString(CustomerCols.FIRST_NAME);
					String lastName = rs.getString(CustomerCols.LAST_NAME);
					String phone = rs.getString(CustomerCols.PHONE);		
					customer.setId(customerId);
					customer.setFirstName(firstName);
					customer.setLastName(lastName);
					customer.setPhone(phone);
					customer.setEmail(email);
				}
			}
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return customer;
	}

	@Override
	public boolean delete(Integer id) {
		boolean result = false;
		int rowsAffected = 0;
		try (Connection connection = ConnectionPool.getConnection()) {
			PreparedStatement st = connection.prepareStatement(SQLQuery.DELETE_CUSTOMER);
			st.setInt(1, id);
			rowsAffected = st.executeUpdate();
			result = (rowsAffected > 0) ? true : false;
			logger.info(st);
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return result;
	}

	@Override
	public boolean delete(Customer customer) {
		boolean result = false;
		int rowsAffected = 0;
		try (Connection connection = ConnectionPool.getConnection()) {
			PreparedStatement st = connection.prepareStatement(SQLQuery.DELETE_CUSTOMER);
			st.setInt(1, customer.getId());
			rowsAffected = st.executeUpdate();
			result = (rowsAffected > 0) ? true : false;
			logger.info(st);
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return result;
	}

	@Override
	public boolean create(Customer customer) {
		boolean result = false;
		int rowsAffected = 0;
		try (Connection connection = ConnectionPool.getConnection()) {
			PreparedStatement st = connection.prepareStatement(SQLQuery.INSERT_CUSTOMER);
			st.setString(1, customer.getFirstName());
			st.setString(2, customer.getLastName());
			st.setString(3, customer.getPhone());
			st.setString(4, customer.getEmail());			
			rowsAffected = st.executeUpdate();
			result = (rowsAffected > 0) ? true : false;
			logger.info(st);
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return result;
	}

	@Override
	public Customer update(Customer customer) {
		try (Connection connection = ConnectionPool.getConnection()) {
			PreparedStatement st = connection.prepareStatement(SQLQuery.UPDATE_CUSTOMER);
			st.setString(1, customer.getFirstName());
			st.setString(2, customer.getLastName());
			st.setString(3, customer.getPhone());
			st.setString(4, customer.getEmail());
			st.setInt(5, customer.getId());
			logger.info(st);
		} catch (SQLException ex) {
			logger.error(ex.getMessage());;
		}
		return customer;
	}	
}
