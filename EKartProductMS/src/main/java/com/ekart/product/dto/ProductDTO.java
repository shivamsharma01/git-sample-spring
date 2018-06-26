package com.ekart.product.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class ProductDTO {
	private String productName;

	@NotEmpty(message = "Name cannot be empty!")
	@Pattern(regexp = "^[A-Za-z\\s]+$", message = "Name can contain only space and letters from alphabet!")
	private String displayName;
	private String shortDesc;
	private String desc;
	private String category;
	private Float price;
	private Float discount;
	private Float deliveryCharge;
	private Float offerPrice;
	private String seller;
	private Integer sellerCount;
	private Float avgRating;
	private List<ReviewDTO> reviews;
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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

	public Float getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(Float offerPrice) {
		this.offerPrice = offerPrice;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public Integer getSellerCount() {
		return sellerCount;
	}

	public void setSellerCount(Integer sellerCount) {
		this.sellerCount = sellerCount;
	}

	public Float getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(Float avgRating) {
		this.avgRating = avgRating;
	}

	public List<ReviewDTO> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewDTO> reviews) {
		this.reviews = reviews;
	}

}