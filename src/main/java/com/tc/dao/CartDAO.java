package com.tc.dao;

import java.util.Map;

import com.tc.model.Cart;

public interface CartDAO {
	public void addItemToCart(Map<Integer, Cart> cartItems,int menuId,int userId, int restaurantId,String menuName,int quantity,float price);
	public void removeItemFromCart(Map<Integer, Cart> cartItems, int menuId);
	public void updateAddItem(Map<Integer, Cart> cartItems,int menuId,float price);
	public int getTotalQuantity(Map<Integer, Cart> cartItems);
}
