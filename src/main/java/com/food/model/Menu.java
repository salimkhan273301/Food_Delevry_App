package com.food.model;

public class Menu {

	private int menuId;
	private int resId;
	private int foodId;
	private int price;
	
	public Menu() {}

	/**
	 * @param menuId
	 * @param resId
	 * @param foodId
	 * @param price
	 */
	public Menu(int menuId, int resId, int foodId, int price) {
		this.menuId = menuId;
		this.resId = resId;
		this.foodId = foodId;
		this.price = price;
	}

	/**
	 * @param menuId
	 * @param foodId
	 * @param price
	 */
	public Menu(int menuId, int foodId, int price) {
		this.menuId = menuId;
		this.foodId = foodId;
		this.price = price;
	}

	/**
	 * @return the menuId
	 */
	public int getMenuId() {
		return menuId;
	}

	/**
	 * @return the resId
	 */
	public int getResId() {
		return resId;
	}

	/**
	 * @return the foodId
	 */
	public int getFoodId() {
		return foodId;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	/**
	 * @param resId the resId to set
	 */
	public void setResId(int resId) {
		this.resId = resId;
	}

	/**
	 * @param foodId the foodId to set
	 */
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + menuId;
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
		Menu other = (Menu) obj;
		if (menuId != other.menuId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Menu [resId=" + resId + ", foodId=" + foodId + ", price=" + price + "]";
	}
	
	

}
