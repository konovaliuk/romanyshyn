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

import com.training.dao.daoImpl.columns.CarCols;
import com.training.dao.daoImpl.util.SQLQuery;
import com.training.dao.iDao.ICarDao;
import com.training.entities.Car;
import com.training.pool.ConnectionPool;



public class CarDao implements ICarDao {
	
	private static Logger logger = Logger.getLogger(CarDao.class);
	
	private static CarDao instance;
	

	private CarDao() {
	}
	
	public static CarDao getInstance() {
		if (instance == null) {
			instance = new CarDao();
		}
		return instance;
	}
	
	@Override
	public List<Car> findAll() {
		List<Car> cars = new ArrayList<>();
		try (Connection connection = ConnectionPool.getConnection();
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(SQLQuery.SELECT_ALL_CARS)) {
			while (rs.next()) {
				Car car = new Car();
				int stateId= rs.getInt(CarCols.STATE_ID);
				int capacity = rs.getInt(CarCols.CAPACITY);
				int carId = rs.getInt(CarCols.CAR_ID);
				int price = rs.getInt(CarCols.PRICE);
				boolean cargo = (rs.getInt(CarCols.CARGO) > 0) ? true : false;
				String mark = rs.getString(CarCols.MARK);
				car.setCapacity(capacity);
				car.setCargo(cargo);
				car.setMark(mark);
				car.setPrice(price);
				car.setStateId(stateId);
				car.setId(carId);
				cars.add(car);
			}
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return cars;
	}
	@Override
	public List<Car> findAllFreeCars() {
		List<Car> cars = new ArrayList<>();
		try (Connection connection = ConnectionPool.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(SQLQuery.SELECT_ALL_FREE_CARS)) {			
			while (rs.next()) {
				Car car = new Car();
				int stateId= rs.getInt(CarCols.STATE_ID);
				int capacity = rs.getInt(CarCols.CAPACITY);
				int carId = rs.getInt(CarCols.CAR_ID);
				int price = rs.getInt(CarCols.PRICE);
				boolean cargo = (rs.getInt(CarCols.CARGO) > 0) ? true : false;
				String mark = rs.getString(CarCols.MARK);
				car.setCapacity(capacity);
				car.setCargo(cargo);
				car.setMark(mark);
				car.setPrice(price);
				car.setStateId(stateId);
				car.setId(carId);
				cars.add(car);
			}
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return cars;
	}
	@Override
	public Map<Integer, Car> findAllMap() {
		Map<Integer, Car> cars = new LinkedHashMap<>();
		try (Connection connection = ConnectionPool.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(SQLQuery.SELECT_ALL_CARS)) {
			while (rs.next()) {
				Car car = new Car();
				int stateId= rs.getInt(CarCols.STATE_ID);
				int capacity = rs.getInt(CarCols.CAPACITY);
				int carId = rs.getInt(CarCols.CAR_ID);
				int price = rs.getInt(CarCols.PRICE);
				boolean cargo = (rs.getInt(CarCols.CARGO) > 0) ? true : false;
				String mark = rs.getString(CarCols.CARGO);
				car.setCapacity(capacity);
				car.setCargo(cargo);
				car.setMark(mark);
				car.setPrice(price);
				car.setStateId(stateId);
				car.setId(carId);
				cars.put(carId, car);
			}
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return cars;
	}
	@Override
	public Car findEntityById(Integer id) {
		Car car = new Car();
		try (Connection connection = ConnectionPool.getConnection();
			PreparedStatement st = connection.prepareStatement(SQLQuery.FIND_CAR_BY_ID)) {
			st.setObject(1, id);
			try (ResultSet rs = st.executeQuery()) {
				while (rs.next()) {
					int stateId= rs.getInt(CarCols.STATE_ID);
					int capacity = rs.getInt(CarCols.CAPACITY);
					int carId = rs.getInt(CarCols.CAR_ID);
					int price = rs.getInt(CarCols.PRICE);
					boolean cargo = (rs.getInt(CarCols.CARGO) > 0) ? true : false;
					String mark = rs.getString(CarCols.MARK);
					car.setCapacity(capacity);
					car.setCargo(cargo);
					car.setMark(mark);
					car.setPrice(price);
					car.setStateId(stateId);
					car.setId(carId);
				}
			}
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return car;
	}
	@Override
	public boolean delete(Integer id) {
		boolean result = false;
		int rowsAffected = 0;
		try (Connection connection = ConnectionPool.getConnection()) {
			PreparedStatement st = connection.prepareStatement(SQLQuery.DELETE_CAR);
			st.setInt(1, id);
			logger.info(st);
			rowsAffected = st.executeUpdate();
			result = (rowsAffected > 0) ? true : false;
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return result;
	}
	@Override
	public boolean delete(Car car) {
		boolean result = false;
		int rowsAffected = 0;
		try (Connection connection = ConnectionPool.getConnection()) {
			PreparedStatement st = connection.prepareStatement(SQLQuery.DELETE_CAR);
			st.setInt(1, car.getId());
			rowsAffected = st.executeUpdate();
			result = (rowsAffected > 0) ? true : false;
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return result;
	}
	@Override
	public boolean create(Car car) {
		boolean result = false;
		int rowsAffected = 0;
		try (Connection connection = ConnectionPool.getConnection()) {
			PreparedStatement st = connection.prepareStatement(SQLQuery.INSERT_CAR);
			int cargo = (car.hasCargo()) ? 1 : 0;
			st.setInt(1, cargo);
			st.setInt(2, car.getCapacity());
			st.setString(3, car.getMark());
			st.setInt(4, car.getPrice());
			st.setInt(5, car.getStateId());
			rowsAffected = st.executeUpdate();
			result = (rowsAffected > 0) ? true : false;
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return result;
	}
	@Override
	public Car update(Car car) {
		try (Connection connection = ConnectionPool.getConnection()) {
			PreparedStatement st = connection.prepareStatement(SQLQuery.UPDATE_CAR);
			int cargo = (car.hasCargo()) ? 1 : 0;
			st.setInt(1, cargo);
			st.setInt(2, car.getCapacity());
			st.setString(3, car.getMark());
			st.setInt(4, car.getPrice());
			st.setInt(5, car.getStateId());
			st.setInt(6, car.getId());
			logger.info(st);
			st.executeUpdate();
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return car;
	}

}
