package com.ekart.user.dto;

import javax.validation.constraints.NotEmpty;

import com.ekart.user.entity.UserEntity;

public class LoginDTO {
	@NotEmpty(message = "User ID cannot be empty")
	private String userId;

	@NotEmpty(message = "Password cannot be empty")
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static UserEntity valueOf(LoginDTO loginData) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(loginData.getUserId());
		userEntity.setPassword(loginData.getPassword());
		return userEntity;
	}

}
