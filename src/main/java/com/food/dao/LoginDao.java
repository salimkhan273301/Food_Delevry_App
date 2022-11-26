package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.food.db.dbConnect;

public class LoginDao {

	public ResultSet customerCheck(String email,String pass) throws Exception {
		Connection con = dbConnect.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from users where userEmail = ? and userPassword = ?");
		ps.setString(1, email);
		ps.setString(2, pass);
		return ps.executeQuery();
		
	}
	
	public ResultSet restaurantCheck(String email,String pass) throws Exception {
		Connection con = dbConnect.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from restaurants where resEmail = ? and resPassword = ?");
		ps.setString(1, email);
		ps.setString(2, pass);
		return ps.executeQuery();
		
	}

}
