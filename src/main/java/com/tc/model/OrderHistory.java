package com.tc.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_history")
public class OrderHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="historyid")
	private int historyId;
	
	@Column(name="userid")
	private int userId;
	
	@Column(name="orderdate")
	private LocalDate orderDate;
	
	@Column(name="totalamount")
	private float totalAmount;
	
	@Column(name="paymentmethod")
	private String paymentMethod;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="orderid")
	private OrderTable orderTable;
	
	public OrderHistory() {
	}

	public OrderHistory(int historyId, int userId, LocalDate orderDate, float totalAmount, String paymentMethod) {
		super();
		this.historyId = historyId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.paymentMethod = paymentMethod;
	}
	
	public OrderHistory(int userId, LocalDate orderDate, float totalAmount, String paymentMethod) {
		super();
		this.userId = userId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.paymentMethod = paymentMethod;
	}
	
	public int getHistoryId() {
		return historyId;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getpaymentMethod() {
		return paymentMethod;
	}

	public void setpaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public OrderTable getOrderTable() {
		return orderTable;
	}

	public void setOrderTable(OrderTable orderTable) {
		this.orderTable = orderTable;
	}
	
	

	@Override
	public String toString() {
		return "OrderHistory [historyId=" + historyId + ", userId=" + userId + ", orderDate=" + orderDate
				+ ", totalAmount=" + totalAmount + ", paymentMethod=" + paymentMethod + "]";
	} 
	

}
