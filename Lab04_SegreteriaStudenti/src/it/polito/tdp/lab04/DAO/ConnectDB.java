package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class ConnectDB {
	private static HikariDataSource ds = null;
	
 

	public static Connection getConnection() {

		String jdbcUrl = "jdbc:mysql://localhost/iscritticorsi";
	 try {
		 if (ds==null) {
			ds= new HikariDataSource();
			ds.setJdbcUrl(jdbcUrl);
			ds.setUsername("root");
			ds.setPassword("root");
			 }
		 Connection	conn= ds.getConnection();
		 return conn;
	 }catch(SQLException se) {return null;}
	 
	
	
	
	

 }
}