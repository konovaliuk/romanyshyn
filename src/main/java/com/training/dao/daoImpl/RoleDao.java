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

import com.training.dao.daoImpl.columns.RoleCols;
import com.training.dao.daoImpl.util.SQLQuery;
import com.training.dao.iDao.IRoleDao;
import com.training.entities.Role;
import com.training.pool.ConnectionPool;

public class RoleDao  implements IRoleDao {
	
	private static Logger logger = Logger.getLogger(RoleDao.class);
	private static RoleDao instance;
	
	private RoleDao() {
		
	}
	
	public static RoleDao getInstance() {
		if (instance == null) {
			instance = new RoleDao();
		}
		return instance;
	}
	
	@Override
	public List<Role> findAll() {
		List<Role> roles = new ArrayList<>();
		try (Connection connection = ConnectionPool.getConnection();){
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(SQLQuery.SELECT_ALL_ROLES);
			while (rs.next()) {
				Role role = new Role();
				int roleId = rs.getInt(RoleCols.ROLE_ID);
				String name = rs.getString(RoleCols.NAME);
				role.setName(name);
				role.setId(roleId);
				roles.add(role);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return roles;
	}
	
	@Override
	public Map<Integer, Role> findAllMap() {
		Map<Integer, Role> roles = new LinkedHashMap<>();
		return roles;
	}
	
	@Override
	public Role findEntityById(Integer id) {
		Role role = new Role();
		try (Connection connection = ConnectionPool.getConnection();){
			PreparedStatement statement = connection.prepareStatement(SQLQuery.FIND_ROLE_BY_ID);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {				
				int roleId = rs.getInt(RoleCols.ROLE_ID);
				String name = rs.getString(RoleCols.NAME);
				role.setName(name);
				role.setId(roleId);		
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}		
		return role;
	}
	
	@Override
	public boolean delete(Integer id) {
		boolean result = false;
		int rowsAffected = 0;
		try (Connection connection = ConnectionPool.getConnection()) {
			PreparedStatement st = connection.prepareStatement(SQLQuery.DELETE_ROLE);
			st.setInt(1, id);
			rowsAffected = st.executeUpdate();
			result = (rowsAffected > 0) ? true : false;
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return result;
	}
	
	@Override
	public boolean delete(Role role) {
		boolean result = false;
		int rowsAffected = 0;
		try (Connection connection = ConnectionPool.getConnection()) {
			PreparedStatement st = connection.prepareStatement(SQLQuery.DELETE_ROLE);
			st.setInt(1, role.getId());
			rowsAffected = st.executeUpdate();
			result = (rowsAffected > 0) ? true : false;
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return result;
	}
	
	@Override
	public boolean create(Role role) {
		boolean result = false;
		int rowsAffected = 0;
		try (Connection connection = ConnectionPool.getConnection()) {
			PreparedStatement st = connection.prepareStatement(SQLQuery.INSERT_ROLE);
			st.setString(1, role.getName());			
			rowsAffected = st.executeUpdate();
			result = (rowsAffected > 0) ? true : false;
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return result;
	}
	
	@Override
	public Role update(Role role) {
		try (Connection connection = ConnectionPool.getConnection()) {
			PreparedStatement st = connection.prepareStatement(SQLQuery.UPDATE_ROLE);			
			st.setString(1, role.getName());			
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return role;
	}
	
	

}
