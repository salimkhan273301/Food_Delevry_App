package com.food.dao;

import java.sql.ResultSet;

public interface UserDao {
	/**
	 * @param add
	 * @return ResultSet
	 */
	public ResultSet availableRes(String add);
	/**
	 * @param add
	 * @return boolean
	 */
	public boolean updateAddress(int id,String add);
	/**
	 * @param id
	 * @return ResultSet
	 */
	public ResultSet getMenu(int id);
	/**
	 * @param fid
	 * @return String
	 */
	public String getFoodName(int fid);
	/**
	 * @param id
	 * @param id2
	 * @param unit
	 * @param qty
	 * @return boolean
	 */
	public boolean addOrder(int id, int id2, int unit, int qty);
}
