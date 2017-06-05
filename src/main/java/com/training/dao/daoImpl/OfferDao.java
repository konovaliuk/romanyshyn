package com.training.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.training.dao.daoImpl.columns.OfferCols;
import com.training.dao.daoImpl.util.SQLQuery;
import com.training.dao.iDao.IOfferDao;
import com.training.entities.Offer;
import com.training.pool.ConnectionPool;

public class OfferDao implements IOfferDao {
	
	private static Logger logger = Logger.getLogger(OfferDao.class);
	private static OfferDao instance;
	
	private OfferDao() {
		
	}
	
	public static OfferDao getInstance() {
		if (instance == null) {
			instance = new OfferDao();
		}
		return instance;
	}
	
	@Override
	public List<Offer> findAll() {
		List<Offer> offers = new ArrayList<>();
		try (Connection connection = ConnectionPool.getConnection()) {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQLQuery.SELECT_ALL_OFFERS);
			while (rs.next()) {
				Offer offer = new Offer();
				int offerId = rs.getInt(OfferCols.OFFER_ID);
				String status = rs.getString(OfferCols.STATUS);
				String placeFrom = rs.getString(OfferCols.PLACE_FROM);
				String placeTo = rs.getString(OfferCols.PLACE_TO);
				int driverId = rs.getInt(OfferCols.DRIVER_ID);
				int customerId = rs.getInt(OfferCols.CUSTOMER_ID);
				Date date = rs.getDate(OfferCols.DATE);
				boolean cargo = rs.getBoolean(OfferCols.CARGO);
				int passangers = rs.getInt(OfferCols.PASSANGERS);
				int maxPrice = rs.getInt(OfferCols.MAX_PRICE);
				offer.setCargo(cargo);
				offer.setPassangers(passangers);
				offer.setMaxPrice(maxPrice);
				offer.setDate(date);
				offer.setId(offerId);
				offer.setStatus(status);
				offer.setPlaceFrom(placeFrom);
				offer.setPlaceTo(placeTo);
				offer.setDriverId(driverId);
				offer.setCustomerId(customerId);				
				offers.add(offer);
			}
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return offers;
	}

	@Override
	public Offer findEntityById(Integer id) {
		Offer offer = new Offer();
		try (Connection connection = ConnectionPool.getConnection()) {
			PreparedStatement st = connection.prepareStatement(SQLQuery.FIND_OFFER_BY_ID);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();			
			while (rs.next()) {
				int offerId = rs.getInt(OfferCols.OFFER_ID);
				String status = rs.getString(OfferCols.STATUS);
				String placeFrom = rs.getString(OfferCols.PLACE_FROM);
				String placeTo = rs.getString(OfferCols.PLACE_TO);
				int driverId = rs.getInt(OfferCols.DRIVER_ID);
				int customerId = rs.getInt(OfferCols.CUSTOMER_ID);
				Date date = rs.getDate(OfferCols.DATE);
				boolean cargo = rs.getBoolean(OfferCols.CARGO);
				int passangers = rs.getInt(OfferCols.PASSANGERS);
				int maxPrice = rs.getInt(OfferCols.MAX_PRICE);
				offer.setCargo(cargo);
				offer.setPassangers(passangers);
				offer.setMaxPrice(maxPrice);
				offer.setDate(date);
				offer.setId(offerId);
				offer.setStatus(status);
				offer.setPlaceFrom(placeFrom);
				offer.setPlaceTo(placeTo);
				offer.setDriverId(driverId);
				offer.setCustomerId(customerId);
			}
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return offer;
	}
	
	@Override
	public Offer findEntityByDriver(Integer id) {
		Offer offer = new Offer();
		try (Connection connection = ConnectionPool.getConnection()) {
			PreparedStatement st = connection.prepareStatement(SQLQuery.FIND_OFFER_BY_DRIVER);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();			
			while (rs.next()) {
				int offerId = rs.getInt(OfferCols.OFFER_ID);
				String status = rs.getString(OfferCols.STATUS);
				String placeFrom = rs.getString(OfferCols.PLACE_FROM);
				String placeTo = rs.getString(OfferCols.PLACE_TO);
				int driverId = rs.getInt(OfferCols.DRIVER_ID);
				int customerId = rs.getInt(OfferCols.CUSTOMER_ID);
				Date date = rs.getDate(OfferCols.DATE);
				boolean cargo = rs.getBoolean(OfferCols.CARGO);
				int passangers = rs.getInt(OfferCols.PASSANGERS);
				int maxPrice = rs.getInt(OfferCols.MAX_PRICE);
				offer.setCargo(cargo);
				offer.setPassangers(passangers);
				offer.setMaxPrice(maxPrice);
				offer.setDate(date);
				offer.setId(offerId);
				offer.setStatus(status);
				offer.setPlaceFrom(placeFrom);
				offer.setPlaceTo(placeTo);
				offer.setDriverId(driverId);
				offer.setCustomerId(customerId);
			}
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return offer;
	}

	@Override
	public boolean delete(Integer id) {
		boolean result = false;
		int rowsAffected = 0;
		try (Connection connection = ConnectionPool.getConnection()) {
			PreparedStatement st = connection.prepareStatement(SQLQuery.DELETE_OFFER);
			st.setInt(1, id);
			rowsAffected = st.executeUpdate();
			result = (rowsAffected > 0) ? true : false;
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return result;
	}

	@Override
	public boolean delete(Offer offer) {
		boolean result = false;
		int rowsAffected = 0;
		try (Connection connection = ConnectionPool.getConnection()) {
			PreparedStatement st = connection.prepareStatement(SQLQuery.DELETE_OFFER);
			st.setInt(1, offer.getId());
			rowsAffected = st.executeUpdate();
			result = (rowsAffected > 0) ? true : false;
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return result;
	}

	@Override
	public boolean create(Offer offer) {
		boolean result = false;
		int rowsAffected = 0;
		try (Connection connection = ConnectionPool.getConnection()) {
			PreparedStatement st = connection.prepareStatement(SQLQuery.INSERT_OFFER);
			st.setString(1, offer.getStatus());
			st.setString(2, offer.getPlaceFrom());
			st.setString(3, offer.getPlaceTo());
			st.setBoolean(4, offer.isCargo());
			st.setInt(5, offer.getCustomerId());
			st.setObject(6, offer.getDate());
			st.setInt(7, offer.getPassangers());
			st.setInt(8, offer.getMaxPrice());
			rowsAffected = st.executeUpdate();
			result = (rowsAffected > 0) ? true : false;
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return result;
	}

	@Override
	public Offer update(Offer offer) {
		try (Connection connection = ConnectionPool.getConnection()) {
			PreparedStatement st = connection.prepareStatement(SQLQuery.UPDATE_OFFER);
			st.setString(1, offer.getStatus());
			st.setString(2, offer.getPlaceFrom());
			st.setString(3, offer.getPlaceTo());
			st.setInt(4, offer.getDriverId());
			st.setInt(5, offer.getCustomerId());
			st.setObject(6, offer.getDate());
			st.setInt(7, offer.getPassangers());
			st.setInt(8, offer.getMaxPrice());
			st.setBoolean(9, offer.isCargo());
			st.setInt(10, offer.getId());
			st.executeUpdate();
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return offer;
	}

}
