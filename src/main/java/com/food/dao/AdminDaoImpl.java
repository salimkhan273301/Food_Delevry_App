package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

import com.food.client.Admin;
import com.food.db.dbConnect;

public class AdminDaoImpl implements AdminDao {
	private static final Logger logger = Logger.getLogger("Admin.class");

	@Override
	public Admin login(String u, String P) {
		try {
			Connection con = dbConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from administrator where userName = ? and pass = ?");
			ps.setString(1, u);
			ps.setString(2, P);
			ResultSet r = ps.executeQuery();
			if(r.next()) {
				Admin a = new Admin(r.getInt(1),r.getString(2),r.getString(3),r.getString(4));
				return a;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addNew(String name, String email, String pass) {
		logger.info("Welcome to add new Admin addNewFunc...!");
		
		try {
			Connection con = dbConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into administrator(userName,pass,adminName) "
					+ "values(?,?,?)");
			
			ps.setString(1, email);
			ps.setString(2, pass);
			ps.setString(3, name);
			return ps.execute();  // it is not returning true
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteAdmin(int id) {
logger.info("Welcome to delete Admin Data...!");
		
		try {
			Connection con = dbConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM administrator where adminId= "
					+ "?");
			
			ps.setInt(1, id);
			;
			return ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void listOfAdmin() {
		
		
logger.info("Welcome to delete Admin Data...!");
		
		try {
			Connection con = dbConnect.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from administrator ");
			
			while(rs.next()) {
				System.out.println("ID : "+rs.getInt(1));
				System.out.println("Email : "+rs.getString(2));
				System.out.println("Password : "+rs.getString(3));
				System.out.println("Admin_Name : "+rs.getString(4));
				System.out.println("===================================");
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		
		
	}

}