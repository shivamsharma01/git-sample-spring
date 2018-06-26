package com.ekart.seller.dto;

import java.util.Calendar;

public class OrderDTO {
	private String userId;
	private Integer orderId;
	private String productName;
	private Integer quantity;
	private Float totalPrice;
	private Calendar orderedDate;
	private String orderStatus;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Calendar getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(Calendar orderedDate) {
		this.orderedDate = orderedDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

}
