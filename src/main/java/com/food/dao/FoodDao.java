package com.food.dao;

import java.sql.ResultSet;

import com.food.model.Menu;

public interface FoodDao {
	public int search(String name);
	public boolean add(String name);
	public boolean addmenu(Menu m);
	public ResultSet currentMenu(int id);

}