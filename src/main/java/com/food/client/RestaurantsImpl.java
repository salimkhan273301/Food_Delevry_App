package com.food.client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Logger;

import com.food.dao.FoodDao;
import com.food.dao.FoodDaoImpl;
import com.food.model.Menu;
import com.food.model.Restaurants;

public class RestaurantsImpl extends Restaurants {

	private static final Logger logger = Logger.getLogger("RestaurantsImpl.class");
	
	/**
	 * @param resId
	 * @param resName
	 * @param regNo
	 * @param status
	 * @param address
	 * @param email
	 * @param password
	 */
	public RestaurantsImpl(int resId, String resName, String regNo, String status, String address, String email,
			String password) {
		super(resId, resName, regNo, status, address, email, password);
		// TODO Auto-generated constructor stub
	}
	Scanner sc = new Scanner(System.in);
	public void welcome() {
		logger.info("Welcome to Restaurant page!");
		System.out.println("Hello! " + this.getResName());
		while(true) {
			System.out.println("What do you wanna do Today?");
			System.out.println("1. Add Menu");
			System.out.println("2. View your Menu");
			System.out.println("Press anything else to LOG OUT");
			
			FoodDao fd = new FoodDaoImpl();
			int c;
			String s = sc.nextLine();
			try {
				c = Integer.parseInt(s);
			} catch (NumberFormatException e) {
				c=Integer.parseInt(sc.nextLine());
			}
			
			
			switch(c) {
			case 1:
				logger.info("adding food item");
				System.out.println("Enter your food Item Name : ");
				String foodName = sc.nextLine().toLowerCase();
				int fId = fd.search(foodName);
				if(fId == 0) {
					logger.info(foodName+" Not present in database");
					if(fd.add(foodName)) {
						logger.info("Added "+foodName);
						fId = fd.search(foodName);
					}
					else {
						logger.info("Error adding "+foodName);
					}
				}
				System.out.println("Enter your food price:");
				System.out.println("This should be including 18% GST");
				int price = sc.nextInt();
				Menu mn = new Menu(this.getResId(),fId,price);
				if(fd.addmenu(mn)) {
					logger.info("Menu added Successfully");
					System.out.println("Your Food item is added SuccessFully");
				}
				else {
					logger.info("Error adding Menu for Restaurant "+this.getResName());
					System.out.println("Something went wrong while updating your Menu! \nPlease try again later");
				}
				break;
			case 2:
				ResultSet rs = fd.currentMenu(this.getResId());
				try {
					while(rs.next()) {
						System.out.println("Food Id " +rs.getInt(2) + " Price : " + rs.getInt(4));
					}
					System.out.println("Thats all you offer to your Customers through us!");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Logging out");
				return;
			}
		}
	}

}
