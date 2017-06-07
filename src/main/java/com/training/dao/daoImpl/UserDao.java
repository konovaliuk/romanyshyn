package com.training.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.training.dao.daoImpl.columns.UserCols;
import com.training.dao.daoImpl.util.SQLQuery;
import com.training.dao.iDao.IUserDao;
import com.training.entities.User;
import com.training.pool.ConnectionPool;

public class UserDao implements IUserDao {
	
	private static Logger logger = Logger.getLogger(UserDao.class);
	private static UserDao instance;
	
	private UserDao() {
		
	}
	
	public static UserDao getInstance() {
		if (instance == null) {
			instance = new UserDao();
		}
		return instance;
	}
	
	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		try (Connection connection = ConnectionPool.getConnection();
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(SQLQuery.SELECT_ALL_USERS)) {
			while (rs.next()) {
				User user = new User();
				int roleId = rs.getInt(UserCols.ROLE_ID);
				int carId = rs.getInt(UserCols.CAR_ID);
				int userId = rs.getInt(UserCols.USER_ID);
				String firstName = rs.getString(UserCols.FIRST_NAME);
				String lastName = rs.getString(UserCols.LAST_NAME);
				String login = rs.getString(UserCols.LOGIN);
				String password = rs.getString(UserCols.PASSWORD);					
				user.setCarId(carId);
				user.setRoleId(roleId);
				user.setId(userId);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setLogin(login);
				user.setPassword(password);				
				users.add(user);
			}
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return users;
	}
	
	@Override
	public List<User> findAllDrivers() {
		List<User> users = new ArrayList<>();
		try (Connection connection = ConnectionPool.getConnection();
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(SQLQuery.SELECT_ALL_DRIVERS)) {
			while (rs.next()) {
				User user = new User();
				int roleId = rs.getInt(UserCols.ROLE_ID);
				int carId = rs.getInt(UserCols.CAR_ID);
				int userId = rs.getInt(UserCols.USER_ID);
				String firstName = rs.getString(UserCols.FIRST_NAME);
				String lastName = rs.getString(UserCols.LAST_NAME);
				String login = rs.getString(UserCols.LOGIN);
				String password = rs.getString(UserCols.PASSWORD);					
				user.setCarId(carId);
				user.setRoleId(roleId);
				user.setId(userId);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setLogin(login);
				user.setPassword(password);				
				users.add(user);
			}
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return users;
	}
	
	@Override
	public List<User> findAllFreeDrivers() {
		List<User> users = new ArrayList<>();
		try (Connection connection = ConnectionPool.getConnection();
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(SQLQuery.SELECT_ALL_FREE_DRIVERS)) {
			while (rs.next()) {
				User user = new User();
				int roleId = rs.getInt(UserCols.ROLE_ID);
				int carId = rs.getInt(UserCols.CAR_ID);
				int userId = rs.getInt(UserCols.USER_ID);
				String firstName = rs.getString(UserCols.FIRST_NAME);
				String lastName = rs.getString(UserCols.LAST_NAME);
				String login = rs.getString(UserCols.LOGIN);
				String password = rs.getString(UserCols.PASSWORD);					
				user.setCarId(carId);
				user.setRoleId(roleId);
				user.setId(userId);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setLogin(login);
				user.setPassword(password);				
				users.add(user);
			}
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return users;
	}

	@Override
	public User findEntityById(Integer id) {
		User user = new User();
		try (Connection connection = ConnectionPool.getConnection();
				PreparedStatement st = connection.prepareStatement(SQLQuery.FIND_USER_BY_ID)) {
			st.setInt(1, id);
			try (ResultSet rs = st.executeQuery()) {			
				while (rs.next()) {
					int roleId = rs.getInt(UserCols.ROLE_ID);
					int carId = rs.getInt(UserCols.CAR_ID);
					int userId = rs.getInt(UserCols.USER_ID);
					String firstName = rs.getString(UserCols.FIRST_NAME);
					String lastName = rs.getString(UserCols.LAST_NAME);
					String login = rs.getString(UserCols.LOGIN);
					String password = rs.getString(UserCols.PASSWORD);					
					user.setCarId(carId);
					user.setRoleId(roleId);
					user.setId(userId);
					user.setFirstName(firstName);
					user.setLastName(lastName);
					user.setLogin(login);
					user.setPassword(password);
				}
			}
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return user;
	}
	
	@Override
	public User findEntityByLogin(String login) {
		User user = new User();
		try (Connection connection = ConnectionPool.getConnection();
				PreparedStatement st = connection.prepareStatement(SQLQuery.FIND_USER_BY_LOGIN)) {
			st.setString(1, login);			
			try (ResultSet rs = st.executeQuery()) {
				while (rs.next()) {
					int roleId = rs.getInt(UserCols.ROLE_ID);
					Integer carId = (Integer) rs.getObject(UserCols.CAR_ID);
					int userId = rs.getInt(UserCols.USER_ID);
					String firstName = rs.getString(UserCols.FIRST_NAME);
					String lastName = rs.getString(UserCols.LAST_NAME);
					String password = rs.getString(UserCols.PASSWORD);					
					user.setCarId(carId);
					user.setRoleId(roleId);
					user.setId(userId);
					user.setFirstName(firstName);
					user.setLastName(lastName);
					user.setLogin(login);
					user.setPassword(password);
				}
			}
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return user;
	}

	@Override
	public boolean delete(Integer id) {
		boolean result = false;
		int rowsAffected = 0;
		try (Connection connection = ConnectionPool.getConnection(); 
				PreparedStatement st = connection.prepareStatement(SQLQuery.DELETE_USER)) {
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
	public boolean delete(User user) {
		boolean result = false;
		int rowsAffected = 0;
		try (Connection connection = ConnectionPool.getConnection();
				PreparedStatement st = connection.prepareStatement(SQLQuery.DELETE_USER)) {			
			st.setInt(1, user.getId());			
			rowsAffected = st.executeUpdate();
			result = (rowsAffected > 0) ? true : false;
			logger.info(st);
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return result;
	}

	@Override
	public boolean create(User user) {
		boolean result = false;
		int rowsAffected = 0;
		try (Connection connection = ConnectionPool.getConnection();
				PreparedStatement st = connection.prepareStatement(SQLQuery.INSERT_USER)) {			
			st.setString(1, user.getLogin());
			st.setString(2, user.getLogin());
			st.setString(3, user.getFirstName());
			st.setString(4, user.getLastName());
			st.setObject(5, user.getCarId());
			st.setInt(6, user.getRoleId());
			rowsAffected = st.executeUpdate();
			result = (rowsAffected > 0) ? true : false;
			logger.info(st);
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return result;
	}
	
	@Override
	public User update(User user) {
		try (Connection connection = ConnectionPool.getConnection();
				PreparedStatement st = connection.prepareStatement(SQLQuery.UPDATE_USER)) {
			st.setString(1, user.getLogin());
			st.setString(2, user.getPassword());
			st.setString(3, user.getFirstName());
			st.setString(4, user.getLastName());
			st.setInt(5, user.getCarId());
			st.setInt(6, user.getRoleId());
			st.setInt(7, user.getId());
			st.executeUpdate();
			logger.info(st);
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return user;
	}
	
}
