package com.ekart.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.ekart.user.entity.UserEntity;
import com.ekart.user.utility.Role;

public class RegistrationDTO {

	@NotEmpty(message = "User ID cannot be empty!")
	@Email(message = "Please enter a valid email ID.")
	private String userId;

	@NotEmpty(message = "Password cannot be empty!")
	private String password;

	private String userType;

	@NotEmpty(message = "Name cannot be empty!")
	@Pattern(regexp = "^[A-Za-z\\s]+$", message = "Name can contain only space and letters from alphabet!")
	private String name;

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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static UserEntity valueOf(RegistrationDTO userData) {
		UserEntity userEntity = new UserEntity();
		userEntity.setName(userData.getName());
		userEntity.setPassword(userData.getPassword());
		userEntity.setUserId(userData.getUserId());
		userEntity.setUserType(Role.USER.getRole());
		return userEntity;
	}
}
