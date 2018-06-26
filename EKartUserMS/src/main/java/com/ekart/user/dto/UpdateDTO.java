package com.ekart.user.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class UpdateDTO {
	@NotEmpty(message = "Name cannot be empty!")
	@Pattern(regexp = "^[A-Za-z\\s]+$", message = "Name can contain only space and letters from alphabet!")
	private String name;

	@NotEmpty(message = "Password cannot be empty!")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[^A-Za-z0-9]).*$", message = "The password must contain at least one uppercase letter, at least one lowercase letter, at least one digit and at least one special character!")
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
