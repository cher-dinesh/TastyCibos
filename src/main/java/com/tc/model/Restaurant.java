package com.tc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurantid")
    private int restaurantId;

    @Column(name = "restaurantname")
    private String restaurantName;

    @Column(name = "address")
    private String address;

    @Column(name = "deliverytime")
    private int deliveryTime;

    @Column(name = "cuisinetype")
    private String cuisineType;

    @Column(name = "isactive")
    private boolean isActive;

    @Column(name = "ratings")
    private float ratings;

    @Column(name = "adminid")
    private int adminId;

    @Column(name="imagepath")
    private String imagePath;

    public Restaurant() {
    }

    public Restaurant(int restaurantId, String restaurantName, String address, int deliveryTime, String cuisineType, boolean isActive, float ratings, int adminId) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.address = address;
        this.deliveryTime = deliveryTime;
        this.cuisineType = cuisineType;
        this.isActive = isActive;
        this.ratings = ratings;
        this.adminId = adminId;
    }

    public Restaurant(String restaurantName, String address, int deliveryTime, String cuisineType, boolean isActive, float ratings, int adminId) {
        this.restaurantName = restaurantName;
        this.address = address;
        this.deliveryTime = deliveryTime;
        this.cuisineType = cuisineType;
        this.isActive = isActive;
        this.ratings = ratings;
        this.adminId = adminId;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public float getRatings() {
        return ratings;
    }

    public void setRatings(float ratings) {
        this.ratings = ratings;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }



    public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
    public String toString() {
        return restaurantId + " " + restaurantName + " " + address + " " + deliveryTime + " " + cuisineType + " " + isActive + " " + ratings + " " + adminId;
    }
}
