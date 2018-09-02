package com.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
//	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/onlinemealorderingdb";
//	private static final String DB_USER = "root";
//	private static final String DB_PASSWORD = "database";
//	private static Connection dbConnection;
	
	private static final String DB_CONNECTION = "jdbc:mysql://lyl3nln24eqcxxot.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306"
			+ "/qcnb94aivwion4v2";
	private static final String DB_USER = "h84o6d37hhlqepi9";
	private static final String DB_PASSWORD = "a2tpe4mf4l3t6evo";
	private static Connection dbConnection;
	
	public static PreparedStatement prepare(String stm) throws SQLException {
		PreparedStatement preparedStatement = null;
		Connection dbConnection = getDBConnection();
		preparedStatement = dbConnection.prepareStatement(stm);
		return preparedStatement;
	}
	
	private static Connection getDBConnection() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
		return dbConnection;
		
	}
}

