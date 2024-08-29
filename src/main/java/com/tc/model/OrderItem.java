package com.tc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderitemid")
    private int orderItemId;

    @Column(name="menuid")
    private int menuId;

    @Column(name="quantity")
    private int quantity;

    @Column(name="itemamount")
    private float itemAmount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="orderid", nullable = false)
    private OrderTable orderTable;

    public OrderItem() {}

    public OrderItem(int menuId, int quantity, float itemAmount) {
        this.menuId = menuId;
        this.quantity = quantity;
        this.itemAmount = itemAmount;
    }

    // Getters and Setters

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(float itemAmount) {
        this.itemAmount = itemAmount;
    }

    public OrderTable getOrderTable() {
        return orderTable;
    }

    public void setOrderTable(OrderTable orderTable) {
        this.orderTable = orderTable;
    }

    @Override
    public String toString() {
        return orderItemId + " " + menuId + " " + quantity + " " + itemAmount;
    }
}
