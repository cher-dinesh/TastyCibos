package com.tc.model;

public class Cart {

	private int menuId;
	private int userId;
	private int restaurantId;
	private String menuName;
	private int quantity;
	private float amount;

	public Cart() {}

	public Cart(int menuId, int userId, int restaurantId, String menuName, int quantity, float amount) {
		super();
		this.menuId = menuId;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.menuName = menuName;
		this.quantity = quantity;
		this.amount = amount;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Cart [menuId=" + menuId + ", userId=" + userId + ", restaurantId=" + restaurantId + ", menuName="
				+ menuName + ", quantity=" + quantity + ", amount=" + amount + "]";
	}



}
