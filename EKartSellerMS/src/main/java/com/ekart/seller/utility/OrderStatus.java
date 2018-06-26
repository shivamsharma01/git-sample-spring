package com.ekart.seller.utility;

public enum OrderStatus {
	OPEN("OPEN"), DELIVERED("DELIVERED"), RETURNED("RETURNED"), CANCELLED("CANCELLED");

	private String status;

	private OrderStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

}
