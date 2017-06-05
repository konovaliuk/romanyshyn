package com.training.pool;



import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class ConnectionPool {
	
	private static final String DATASOURCE_NAME = "jdbc/car_base";
	private static DataSource dataSource;
	
	static {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup(DATASOURCE_NAME);
			
		} catch (NamingException ex) {
			ex.printStackTrace();
		}
	}
	private ConnectionPool() {
		
	}
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	

}
