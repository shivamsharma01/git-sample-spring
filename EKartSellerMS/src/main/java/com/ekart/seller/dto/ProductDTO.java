package com.ekart.seller.dto;

import javax.validation.constraints.NotNull;

import com.ekart.seller.utility.In;

public class ProductDTO {
	@NotNull(message = "Product name is Required")
	private String displayName;
	@NotNull(message = "Brief Description is Required")
	private String shortDesc;
	@NotNull(message = "Description is Required")
	private String description;
	@NotNull(message = "Category is Required")
	@In
	private String category;
	@NotNull(message = "Price is Required")
	private Float price;
	@NotNull(message = "Discount is Required")
	private Float discount;
	@NotNull(message = "DeliveryCharge is Required")
	private Float deliveryCharge;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Float getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(Float deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

}