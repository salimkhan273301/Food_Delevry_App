package com.food.model;

public class Customer {
	private int id;
	private int age;
	private String name;
	private String address;
	private String email;
	private String password;
	private int number;
	/**
	 * @param id
	 * @param age
	 * @param name
	 * @param address
	 * @param email
	 * @param password
	 * @param number
	 */
	public Customer(int id, int age, String name, String address, String email, String password, int number) {
		this.id = id;
		this.age = age;
		this.name = name;
		this.address = address;
		this.email = email;
		this.password = password;
		this.number = number;
	}
	/**
	 * @param name
	 * @param address
	 * @param number
	 */
	public Customer(int id,String name, String address, int number) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.number = number;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + number;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (number != other.number)
			return false;
		return true;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Customer [age=" + age + ", name=" + name + ", address=" + address + ", email=" + email + ", number="
				+ number + "]";
	}
	
	
}
