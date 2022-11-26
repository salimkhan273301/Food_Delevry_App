package com.food.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnect{
	
	public static Connection getConnection() throws SQLException, java.lang.ClassNotFoundException {
		// 1 registration driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2 creating Connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food", "root", "12345");
		return con;
	}

}
