package com.training.dao.daoImpl.util;

public interface SQLQuery {
	static final String SELECT_ALL_USERS = "SELECT * FROM users WHERE deleted = 'exist'";
	static final String FIND_USER_BY_ID = "SELECT * FROM users WHERE user_id =? AND deleted = 'exist'";
	static final String SELECT_ALL_DRIVERS = "SELECT * FROM users WHERE role_id=2 AND deleted = 'exist'";
	static final String SELECT_ALL_FREE_DRIVERS = "SELECT * FROM users WHERE role_id = 2 AND deleted = 'exist' AND user_id NOT IN (SELECT driver_id FROM offers WHERE status = 'active')";
	static final String FIND_USER_BY_LOGIN = "SELECT * FROM users WHERE login =?";
	static final String DELETE_USER = "UPDATE users SET deleted='deleted' WHERE user_id= ?";
	static final String INSERT_USER = "INSERT INTO users "
			+ "(login, password, first_name, second_name, car_id, role_id) "
			+ "VALUES(?,?,?,?,?,?)";
	static final String UPDATE_USER = "UPDATE users SET "
			+ "login = ?, password = ?, first_name = ?, second_name = ?, car_id = ?, role_id=? "
			+ "WHERE user_id = ?";
	static final String SELECT_ALL_USERS_FULL = "SELECT * FROM "
				+ "(SELECT user_id, login, password, first_name, second_name, users.car_id, users.role_id "
				+ "FROM users JOIN roles ON users.role_id = roles.role_id) AS union_table "
			+ "LEFT JOIN "
				+ "(SELECT car_id AS temp_car_id, mark, capacity, cargo, price, name AS state_name, cars.state_id "
				+ "FROM cars JOIN car_state ON cars.state_id = car_state.state_id) AS union_table2 "
			+ "ON union_table.car_id = union_table2.temp_car_id";
	
	
	static final String SELECT_ALL_CUSTOMERS = "SELECT * FROM customers";
	static final String FIND_CUSTOMER_BY_ID = "SELECT * FROM customers WHERE customer_id = ?";
	static final String FIND_CUSTOMER_BY_EMAIL = "SELECT * FROM customers WHERE email = ?";
	static final String DELETE_CUSTOMER = "DELETE FROM customers WHERE customer_id= ?";
	static final String INSERT_CUSTOMER = "INSERT INTO customers "
			+ "(first_name, second_name, phone, email) "
			+ "VALUES(?,?,?,?)";
	static final String UPDATE_CUSTOMER = "UPDATE customers SET "
			+ "first_name = ?, second_name = ?, phone = ?, email = ? "
			+ "WHERE customer_id = ?";
	
	
	static final String SELECT_ALL_CARS = "SELECT * FROM cars WHERE deleted = 'exist'";
	static final String SELECT_ALL_FREE_CARS = "SELECT * FROM cars WHERE car_id NOT IN "
			+ "(SELECT car_id FROM users WHERE car_id IS NOT NULL) AND deleted = 'exist'";
	static final String FIND_CAR_BY_ID = "SELECT * FROM cars WHERE car_id = ? AND deleted = 'exist'";
	static final String DELETE_CAR = "UPDATE cars SET deleted='deleted' WHERE car_id=? ";
	static final String INSERT_CAR = "INSERT INTO cars "
			+ "(cargo, capacity, mark, price, state_id) "
			+ "VALUES(?,?,?,?,?)";
	static final String UPDATE_CAR = "UPDATE cars SET "
			+ "cargo = ?, capacity = ?, mark = ?, price = ?, state_id = ? "
			+ "WHERE car_id = ?";
	
	
	static final String SELECT_ALL_STATES = "SELECT * FROM car_state";
	static final String FIND_STATE_BY_ID = "SELECT * FROM car_state WHERE state_id = ?";
	static final String DELETE_STATE = "DELETE FROM car_state WHERE car_id= ?";
	static final String INSERT_STATE = "INSERT INTO car_state (name) "
			+ "VALUES(?)";
	static final String UPDATE_STATE = "UPDATE car_state SET "
			+ "name = ? "
			+ "WHERE state_id = ?";
	
	
	static final String SELECT_ALL_ROLES = "SELECT * FROM roles";
	static final String FIND_ROLE_BY_ID = "SELECT * FROM roles WHERE role_id = ?";
	static final String DELETE_ROLE = "DELETE FROM roles WHERE role_id= ?";
	static final String INSERT_ROLE = "INSERT INTO roles (name) "
			+ "VALUES(?)";
	static final String UPDATE_ROLE = "UPDATE roles SET "
			+ "name = ? "
			+ "WHERE role_id = ?";
	
	static final String SELECT_ALL_OFFERS = "SELECT * FROM offers";
	static final String FIND_OFFER_BY_ID = "SELECT * FROM offers WHERE offer_id = ?";
	static final String FIND_OFFER_BY_DRIVER = "SELECT * FROM offers WHERE driver_id = ? AND status='active'";
	static final String DELETE_OFFER = "DELETE FROM offers WHERE offer_id= ?";
	static final String INSERT_OFFER = "INSERT INTO offers (status, from_city, to_city, cargo, customer_id, date, passangers, max_price) "
			+ "VALUES(?,?,?,?,?,?,?,?)";
	static final String UPDATE_OFFER = "UPDATE offers SET "
			+ "status = ?, from_city = ?, to_city = ?, driver_id = ?, customer_id = ?, date = ?, passangers = ?, max_price = ?, cargo = ? "
			+ "WHERE offer_id = ?";
}
