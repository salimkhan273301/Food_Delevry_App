package com.food.dao;

import com.food.model.Customer;
import com.food.model.Restaurants;

public interface SignUpDao {
	public boolean customer(Customer c);
	public boolean restaurant(Restaurants r);
}
