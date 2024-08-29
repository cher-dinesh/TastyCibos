package com.tc.dao;

import java.util.List;

import com.tc.model.Menu;

public interface MenuDAO {
	public List<Menu> getMenu(int restaurantId);
	public float getPriceByMenuId(int menuId);
}
