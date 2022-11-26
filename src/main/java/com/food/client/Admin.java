package com.food.client;

import java.util.Scanner;
import java.util.logging.Logger;

import com.food.dao.AdminDao;
import com.food.dao.AdminDaoImpl;
import com.food.model.Administrator;

public class Admin extends Administrator {
	private static final Logger logger = Logger.getLogger("Admin.class");
	/**
	 * @param id
	 * @param uName
	 * @param pass
	 * @param name
	 */
	public Admin(int id, String uName, String pass, String name) {
		super(id, uName, pass, name);
		// TODO Auto-generated constructor stub
	}
	Scanner sc = new Scanner(System.in);
	public void welcome() {
		logger.info("Welcome to Admin page!");
		System.out.println("Hello! " + this.getName());
		while(true) {
			System.out.println("What do you wanna do Today?");
			System.out.println("1. Add New Admin");
			System.out.println("2. Delete Existing Admin");
			System.out.println("3. List of Existing Admin");
			int ch = Integer.parseInt(sc.nextLine());
			AdminDao ad  = new AdminDaoImpl();
			switch(ch) {
			case 1:
				System.out.println("Enter details of new Admin");
				System.out.println("Enter Name");
				String name = sc.nextLine();
				System.out.println("Enter Email");
				String email = sc.nextLine();
				System.out.println("Enter Password");
				String pass = sc.nextLine();
				if(!ad.addNew(name, email, pass)) {    // here i used ! because of function not returning true... 
					logger.info("New Admin added Successfully");
					System.out.println("Success!");
				}
				else {
					logger.info("Error while adding New Admin");
					System.out.println("Sorry! Please try again later");
				}
				break;
				
			case 2:
				System.out.println("Enter details of Existing Admin");
				
				System.out.println("Enter Id");
				String id  = sc.nextLine();
				int aid=Integer.parseInt(id);
				
				if(!ad.deleteAdmin(aid)) {
					logger.info("Existing Admin deleted   Successfully");
					System.out.println("Success!");
				}
				else {
					logger.info("Error while adding New Admin");
					System.out.println("Sorry! Please try again later");
				}
				break;
			case 3:
				System.out.println("---------List Of  Admin---------");
				
				
				
				ad.listOfAdmin();
				logger.info("Existing Admin List Printed   Successfully");
				
				break;
			default:
				logger.info("Logging out");
				System.out.println("Thank You! Logging you out");
				return;
				
			}
		}
	}

}
