package com.ekart.user.utility;

public enum Role {
	GUEST("GUEST"),USER("USER"),REGISTERED_BUYER("REGISTERED_BUYER"),SELLER("SELLER");
	private String role;
	private Role(String role) {
		this.role = role;
	}
	public String getRole() {
		return this.role;
	}
}
