package com.ekart.seller.utility;

public enum Category {
	MOBILE("mobile"), TELEVISION("television"), CAMERA("camera"), HEADPHONE("headphone"), WATCH("watch"), LAPTOP("laptop");

	private String category;

	private Category(String category) {
		this.category = category;
	}

	public String getCategory() {
		return this.category;
	}

}
