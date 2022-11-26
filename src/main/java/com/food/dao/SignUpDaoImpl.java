package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.food.db.dbConnect;
import com.food.model.Customer;
import com.food.model.Restaurants;

public class SignUpDaoImpl implements SignUpDao{

	public boolean customer(Customer c) {
		try {
			Connection con = dbConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into users(userAge,userName,userAddress,userEmail,userNumber,userPassword)"
					+ "values(?,?,?,?,?,?)");
			ps.setInt(1, c.getAge());
			ps.setString(2, c.getName());
			ps.setString(3, c.getAddress());
			ps.setString(4, c.getEmail());
			ps.setInt(5, c.getNumber());
			ps.setString(6, c.getPassword());
			int  stat = ps.executeUpdate();
			if(stat>0) {
				return true;
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean restaurant(Restaurants r) {
		try {
			Connection con = dbConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into restaurants(resName,resRegNo,resStatus,resAddress,resEmail,resPassword)"
					+ "values(?,?,?,?,?,?)");
			ps.setString(1, r.getResName());
			ps.setString(2, r.getRegNo());
			ps.setString(3, r.getStatus());
			ps.setString(4, r.getAddress());
			ps.setString(5, r.getEmail());
			ps.setString(6, r.getPassword());
			int  stat = ps.executeUpdate();
			if(stat>0) {
				return true;
			}
		}catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		return false;
	}

	

}