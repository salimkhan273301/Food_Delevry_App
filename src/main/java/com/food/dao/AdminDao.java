package com.food.dao;

import com.food.client.Admin;

public interface AdminDao {
	
	
		public Admin login(String u,String P);
		public boolean addNew(String name,String email,String pass);
		public boolean deleteAdmin(int id);
		public void listOfAdmin();
	}


