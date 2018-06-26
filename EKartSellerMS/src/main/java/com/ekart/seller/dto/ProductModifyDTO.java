package com.ekart.seller.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ProductModifyDTO {
	@NotNull(message = "Price cannot be null")
	@Pattern(regexp = "[0-9.]+")
	private String price;
	@NotNull(message = "Discount cannot be null")
	@Pattern(regexp = "[0-9.]+")
	private String discount;
	@NotNull(message = "Delivery Charge cannot be null")
	@Pattern(regexp = "[0-9.]+")
	private String deliveryCharge;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(String deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

}
