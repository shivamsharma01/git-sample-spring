package com.ekart.seller.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ORDER_TABLE")
public class OrderEntity {
	@Column(name = "USER_ID")
	private String userId;
	@Id
	@Column(name = "ID")
	private Integer orderId;
	@Column(name = "PRODUCT_NAME")
	private String productName;
	@Column(name = "QUANTITY")
	private Integer quantity;
	@Column(name = "TOTAL_PRICE")
	private Float totalPrice;
	@Column(name = "ORDER_DATE")
	@Temporal(TemporalType.DATE)
	private Calendar orderedDate;
	@Column(name = "ORDER_STATUS")
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
