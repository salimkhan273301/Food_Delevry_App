package com.food.model;

public class Restaurants {
	private int resId;
	private String resName;
	private String regNo;
	private String status;// status zero means inactive restaurants;
	private String address;
	private String email;
	private String password;
	/**
	 * @param resId
	 * @param resName
	 * @param regNo
	 * @param status
	 * @param address
	 * @param email
	 * @param password
	 */
	public Restaurants(int resId, String resName, String regNo, String status, String address, String email,
			String password) {
		this.resId = resId;
		this.resName = resName;
		this.regNo = regNo;
		this.status = status;
		this.address = address;
		this.email = email;
		this.password = password;
	}
	/**
	 * @return the resId
	 */
	public int getResId() {
		return resId;
	}
	/**
	 * @return the resName
	 */
	public String getResName() {
		return resName;
	}
	/**
	 * @return the regNo
	 */
	public String getRegNo() {
		return regNo;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
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
	 * @param resId the resId to set
	 */
	public void setResId(int resId) {
		this.resId = resId;
	}
	/**
	 * @param resName the resName to set
	 */
	public void setResName(String resName) {
		this.resName = resName;
	}
	/**
	 * @param regNo the regNo to set
	 */
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((regNo == null) ? 0 : regNo.hashCode());
		result = prime * result + resId;
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
		Restaurants other = (Restaurants) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (regNo == null) {
			if (other.regNo != null)
				return false;
		} else if (!regNo.equals(other.regNo))
			return false;
		if (resId != other.resId)
			return false;
		return true;
	}
	
	
}
