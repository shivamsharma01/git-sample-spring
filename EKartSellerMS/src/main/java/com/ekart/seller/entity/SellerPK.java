package com.ekart.seller.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class SellerPK implements Serializable {
	@Column(length=32)
	private String sellerId;
	@ManyToOne
	@JoinColumn(name="displayName", nullable=false)
	private ProductEntity product;
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String seller) {
		this.sellerId = seller;
	}
	public ProductEntity getProduct() {
		return product;
	}
	public void setProduct(ProductEntity product) {
		this.product = product;
	}
}
