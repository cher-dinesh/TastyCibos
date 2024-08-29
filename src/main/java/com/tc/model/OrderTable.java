package com.tc.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_table")
public class OrderTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderid")
    private int orderId;

    @Column(name="userid")
    private int userId;

    @Column(name="restaurantid")
    private int restaurantId;

    @Column(name="status")
    private String status;

    @Column(name="totalamount")
    private float totalAmount;

    @Column(name="ordertime")
    private LocalDateTime orderTime;

    @OneToMany(mappedBy = "orderTable", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderItem> orderItems;
    
    @OneToOne(mappedBy = "orderTable",cascade = CascadeType.ALL,orphanRemoval = true)
    private OrderHistory orderHistory;

    public OrderTable() {
    }

    public OrderTable(int userId, int restaurantId, String status, LocalDateTime orderTime, float totalAmount) {
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.status = status;
        this.orderTime = orderTime;
        this.totalAmount = totalAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return orderId + " " + restaurantId + " " + userId + " " + status + " " + totalAmount + " " + orderTime;
    }
}
