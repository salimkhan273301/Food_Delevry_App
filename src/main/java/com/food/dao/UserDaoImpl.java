package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.food.db.dbConnect;

public class UserDaoImpl implements UserDao {

	@Override
	public ResultSet availableRes(String add) {
		try {
			Connection con = dbConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from restaurants where resAddress=?");
			ps.setString(1, add);
			return ps.executeQuery();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateAddress(int id,String add) {
		try {
			Connection con = dbConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("Update users "
					+ "set userAddress = ? "
					+ "where userId = ?");
			ps.setString(1, add);
			ps.setInt(2, id);
			int stat = ps.executeUpdate();
			if(stat>0)
				return true;
			else
				return false;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ResultSet getMenu(int id) {
		try {
			Connection con = dbConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from menu where resId=?");
			ps.setInt(1, id);
			return ps.executeQuery();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getFoodName(int fid) {
		try {
			Connection con = dbConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from food where foodId=?");
			ps.setInt(1, fid);
			ResultSet rs =  ps.executeQuery();
			if(rs.next())
				return rs.getString(2);
			else return null;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addOrder(int id, int id2, int unit, int qty) {
		try {
			Connection con = dbConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into orders(userId,menuId,unitPrice,quantity)"
					+ "values(?,?,?,?)");
			ps.setInt(1, id);
			ps.setInt(2, id2);
			ps.setInt(3, unit);
			ps.setInt(4, qty);
			return ps.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
