package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil 
{	/*
	private static Connection connection;

	private ConnectionUtil() 
	{}

	public static Connection getConnection() throws IOException, SQLException 
	{
		Properties prop = new Properties();
		InputStream in = new FileInputStream("connection.properties");
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		if(connection == null || connection.isClosed()) 
			connection = DriverManager.getConnection(url, username, password);
		
		System.out.println(connection + "Success!");
		return connection;
	}*/
	
	public static Connection getConnection() throws SQLException, IOException {
		// read in contents of a properties file - NEVER want to hardcode credentials
		Properties prop = new Properties();
		//InputStream in = new FileInputStream("connection.properties");
		prop.load(ConnectionUtil.class.getClassLoader().getResourceAsStream("connection.properties"));
		// need to provide: url to the database, username, password
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
				prop.getProperty("password"));	
	}
}