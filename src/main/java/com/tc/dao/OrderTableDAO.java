package com.tc.dao;

import java.util.Collection;
import java.util.List;

import com.tc.model.Cart;
import com.tc.model.OrderHistory;

public interface OrderTableDAO {
	public void insertOrderDetails(int userId, int restaurantId, String status, float totalAmount,Collection<Cart> cartItems,String paymentMethod);
	public List<OrderHistory> getHistory(int userId);

}
