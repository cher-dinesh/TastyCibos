package com.tc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu {

	@Id
	@Column(name="menuid")
	private int menuId;

	@Column(name="restaurantid")
	private int restaurantId;

	@Column(name="menuname")
	private String menuName;

	@Column(name="description")
	private String description;

	@Column(name="price")
	private float price;

	@Column(name="isavailable")
	private boolean isAvailable;

	@Column(name="imagepath")
	private String imagePath;


	public Menu(int menuId, int restaurantId, String menuName, String description, float price, boolean isAvailable,
			String imagePath) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.menuName = menuName;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.imagePath = imagePath;
	}

	public Menu() {
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return menuId+" "+menuName+" "+restaurantId+" "+description+" "+price+" "+isAvailable+" "+imagePath;
	}


}
