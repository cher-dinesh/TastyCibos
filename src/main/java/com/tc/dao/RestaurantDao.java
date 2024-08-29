package com.tc.dao;

import java.util.List;

import com.tc.model.Restaurant;

public interface RestaurantDao {
	List<Restaurant> getAllRestaurant();
	public String getRestaurantName(int restaurantId);

}
