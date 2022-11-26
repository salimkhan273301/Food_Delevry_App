package com.food.client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import com.food.dao.UserDao;
import com.food.dao.UserDaoImpl;
import com.food.model.Customer;

public class CustomerImpl extends Customer {
	private static final Logger logger = Logger.getLogger("CustomerImpl.class");

	public CustomerImpl(int id,String name, String address, int number) {
		super(id,name, address, number);
		// TODO Auto-generated constructor stub
	}
	Scanner sc = new Scanner(System.in);
	public void welcome(){
		//choice of Resturants
		// choice of Dishes
		//confirm order
		logger.info("Welcome to Restaurant page!");
		System.out.println("Hello! " + this.getName());
		UserDao ud = new UserDaoImpl();
		while(true) {
			System.out.println("Your Current address is " + this.getAddress());
			System.out.println("Do you want to change it? y/n");
			String c = sc.nextLine().toLowerCase();
			if(c.equals("y")) {
				System.out.println("Enter your new address");
				this.setAddress(sc.nextLine());
				System.out.println("Do you want to make it your preffered choice? y/n");
				c = sc.nextLine().toLowerCase();
				if(c.equals("y")) {
					if(ud.updateAddress(this.getId(),this.getAddress()))
						logger.info("Address updated to Database successfully");
					else
						logger.info("Error updating Address");
				}
			}
			System.out.println("Following Restaurants are available in your area:");
			ResultSet rs = ud.availableRes(this.getAddress());
			if(rs!=null)
				try {
					while(rs.next()) {
						int id = rs.getInt(1);
						String name = rs.getString(2);
						System.out.println("Restaurant Id : "+id+" Restaurant Name : "+name);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else {
				System.out.println("Sorry! Currently we don't deliver to your address!");
				System.out.println("But we promise we will start delivering to your address soon!");
				continue;
			}
			System.out.println("Please enter the restaurant id to see the available menu");
			int id = Integer.parseInt(sc.nextLine());
			rs = ud.getMenu(id);
			Map<Integer,Integer> hm = new HashMap<>();
			try {
				while(rs.next()) {
					id = rs.getInt(1);
					int fid = rs.getInt(3);
					int price = rs.getInt(4);
					hm.put(id, price);
					String fName = ud.getFoodName(fid);
					System.out.println("Menu Id : "+id+" Name : "+fName+" Price : "+price);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while(true) {
				System.out.println("Enter Menu id ");
				id = Integer.parseInt(sc.nextLine());
				System.out.println("Enter Quantity : ");
				int qty = Integer.parseInt(sc.nextLine());
				if(ud.addOrder(this.getId(),id,hm.getOrDefault(id, 1),qty))
					logger.info("Added Order Succssfully");
				else
					logger.info("Error while adding Orders");
				System.out.println("Do you wan to add more items? y/n");
				c = sc.nextLine().toLowerCase();
				if(c.equals("n"))break;
			}
			System.out.println("All your orders are receieved and Accepted by the Restasurant");
			System.out.println("Please wait sometime, Our delivery partner will be delivering your order soon");
			System.out.println("Thank you!");
			return;
		}
	}

	
}
