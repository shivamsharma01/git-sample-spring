package com.ekart.seller.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/*
 * Entity class for Sellers
 * */
@Entity
public class SellerEntity {
	@EmbeddedId
	private SellerPK sellerPK;
	public SellerPK getSellerPK() {
		return sellerPK;
	}
	public void setSellerPK(SellerPK sellerPK) {
		this.sellerPK = sellerPK;
	}
	public SellerEntity() {
		// Default Constructor
	}
}
