package com.tc.daoimpl;

import java.util.Map;

import com.tc.dao.CartDAO;
import com.tc.model.Cart;

public class CartDAOImp implements CartDAO {

    // Add an item to the cart
    @Override
	public void addItemToCart(Map<Integer, Cart> cartItems, int menuId, int userId, int restaurantId, String menuName, int quantity, float price) {
        if (cartItems.containsKey(menuId)) {
            Cart existingCartItem = cartItems.get(menuId);
            existingCartItem.setQuantity(existingCartItem.getQuantity() + quantity);
            existingCartItem.setAmount(price * existingCartItem.getQuantity());
        } else {
            Cart cartItem = new Cart(menuId, userId, restaurantId, menuName, quantity, price);
            cartItems.put(menuId, cartItem);
        }
    }

    // Remove an item from the cart
    @Override
	public void removeItemFromCart(Map<Integer, Cart> cartItems, int menuId) {
        if (cartItems.containsKey(menuId)) {
            Cart existingCartItem = cartItems.get(menuId);
            int newQuantity = existingCartItem.getQuantity() - 1;
            if (newQuantity > 0) {
                existingCartItem.setQuantity(newQuantity);
                existingCartItem.setAmount(existingCartItem.getAmount() * newQuantity);
            } else {
                cartItems.remove(menuId);
            }
        }
    }

    @Override
	public void updateAddItem(Map<Integer, Cart> cartItems,int menuId,float price) {
        Cart existingCartItem = cartItems.get(menuId);
        existingCartItem.setQuantity(existingCartItem.getQuantity() + 1);
        existingCartItem.setAmount(price * existingCartItem.getQuantity());
    }
    // Get total quantity of items in the cart
    @Override
	public int getTotalQuantity(Map<Integer, Cart> cartItems) {
        return cartItems.values().stream()
                        .mapToInt(Cart::getQuantity)
                        .sum();
    }
}
