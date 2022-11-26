package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.food.db.dbConnect;
import com.food.model.Menu;

public class FoodDaoImpl implements FoodDao {

	public int search(String name) {
		try {
			Connection con = dbConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from food where foodname=?");
			ps.setString(1,name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("foodId");
				return id;
			}
			else 
				return 0;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public boolean add(String name) {
		try {
			Connection con = dbConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into food(foodName) "
					+ "values(?)");
			ps.setString(1, name);
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

	public boolean addmenu(Menu m) {
		try {
			Connection con = dbConnect.getConnection();
			PreparedStatement pst = con.prepareStatement("insert into menu(resId,foodId,foodPrice) "
					+ "values(?,?,?)");
			pst.setInt(1, m.getResId());
			pst.setInt(2, m.getFoodId());
			pst.setInt(3, m.getPrice());
			int i = pst.executeUpdate();
			if(i>0)return true;
			else return false;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ResultSet currentMenu(int id) {
		try {
			Connection con = dbConnect.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from menu where resId= ?");
			pst.setInt(1,id);
			return pst.executeQuery();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
