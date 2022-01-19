package com.lavanya.gudimella.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String SQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://LocalHost:3306/database_schema?serverTimezone=UTC";
	private static final String user_name = "root";
	private static final String password="root";
	
	
	/**
	 * This method returns the database connection
	 * @return Connection
	 */
	public Connection getDatabaseConnection() {
		Connection connection = null;
		try {
			Class.forName(SQL_DRIVER);
			connection = DriverManager.getConnection(URL, user_name, password); 
			System.out.println("Connection to the database was established successfully");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
