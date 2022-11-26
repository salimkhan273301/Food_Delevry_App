package com.food.model;

public class Food {

	private int fId;
	private String fName;
	/**
	 * @param fId
	 * @param fName
	 */
	public Food(int fId, String fName) {
		this.fId = fId;
		this.fName = fName;
	}
	/**
	 * @return the fId
	 */
	public int getfId() {
		return fId;
	}
	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}
	/**
	 * @param fId the fId to set
	 */
	public void setfId(int fId) {
		this.fId = fId;
	}
	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fId;
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
		Food other = (Food) obj;
		if (fId != other.fId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Food [fId=" + fId + ", fName=" + fName + "]";
	}
	
	
}
