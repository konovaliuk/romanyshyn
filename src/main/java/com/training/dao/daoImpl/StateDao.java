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

import com.training.dao.daoImpl.columns.StateCols;
import com.training.dao.daoImpl.util.SQLQuery;
import com.training.dao.iDao.IStateDao;
import com.training.entities.State;
import com.training.pool.ConnectionPool;

public class StateDao implements IStateDao {
	
	private static Logger logger = Logger.getLogger(StateDao.class);
	private static StateDao instance;
	
	private StateDao() {
		
	}
	
	public static StateDao getInstance() {
		if (instance == null) {
			instance = new StateDao();
		}
		return instance;
	}
	
	@Override
	public List<State> findAll() {
		List<State> states = new ArrayList<>();
		try (Connection connection = ConnectionPool.getConnection();){
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(SQLQuery.SELECT_ALL_STATES);
			while (rs.next()) {
				State state = new State();				
				int stateId = rs.getInt(StateCols.STATE_ID);
				String name = rs.getString(StateCols.NAME);				
				state.setName(name);
				state.setId(stateId);				
				states.add(state);				
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}		
		return states;
	}

	@Override
	public State findEntityById(Integer id) {
		State state = new State();
		try (Connection connection = ConnectionPool.getConnection();){
			PreparedStatement statement = connection.prepareStatement(SQLQuery.FIND_STATE_BY_ID);
			statement.setObject(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {				
				int stateId = rs.getInt(StateCols.STATE_ID);
				String name = rs.getString(StateCols.NAME);		
				state.setName(name);
				state.setId(stateId);				
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}		
		return state;
	}

	@Override
	public boolean delete(Integer id) {
		boolean result = false;
		int rowsAffected = 0;
		try (Connection connection = ConnectionPool.getConnection()) {
			PreparedStatement st = connection.prepareStatement(SQLQuery.DELETE_STATE);
			st.setInt(1, id);
			rowsAffected = st.executeUpdate();
			result = (rowsAffected > 0) ? true : false;
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return result;
	}

	@Override
	public boolean delete(State state) {
		boolean result = false;
		int rowsAffected = 0;
		try (Connection connection = ConnectionPool.getConnection()) {
			PreparedStatement st = connection.prepareStatement(SQLQuery.DELETE_STATE);
			st.setInt(1, state.getId());
			rowsAffected = st.executeUpdate();
			result = (rowsAffected > 0) ? true : false;
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return result;
	}

	@Override
	public boolean create(State state) {
		boolean result = false;
		int rowsAffected = 0;
		try (Connection connection = ConnectionPool.getConnection()) {
			PreparedStatement st = connection.prepareStatement(SQLQuery.INSERT_STATE);
			st.setString(1, state.getName());			
			rowsAffected = st.executeUpdate();
			result = (rowsAffected > 0) ? true : false;
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return result;
	}

	@Override
	public State update(State state) {
		try (Connection connection = ConnectionPool.getConnection()) {
			PreparedStatement st = connection.prepareStatement(SQLQuery.UPDATE_STATE);
			st.setString(1, state.getName());
			st.executeUpdate();
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return state;
	}

	@Override
	public Map<Integer, State> findAllMap() {
		Map<Integer, State> states = new LinkedHashMap<>();
		try (Connection connection = ConnectionPool.getConnection();){
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(SQLQuery.SELECT_ALL_STATES);
			while (rs.next()) {
				State state = new State();				
				int stateId = rs.getInt(StateCols.STATE_ID);
				String name = rs.getString(StateCols.NAME);				
				state.setName(name);
				state.setId(stateId);				
				states.put(stateId, state);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}		
		return states;
	}

}
