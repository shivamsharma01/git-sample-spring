package com.ekart.user.dto;

import javax.validation.constraints.Pattern;

import com.ekart.user.entity.AddressEntity;
import com.ekart.user.utility.In;

public class AddressDTO {
	private Integer addressId;
	private String address;
	@Pattern(regexp = "^[A-Za-z ]+$", message = "City can contain only alphabets and spaces")
	private String city;
	@In(message = "Please enter a valid state")
	private String state;
	@Pattern(regexp = "^[1-9]\\d{5}$", message = "Please enter a valid 6 digit pincode")
	private String pinCode;
	@Pattern(regexp = "^[1-9]\\d{9}$", message = "Please enter a valid 10 digit phone number")
	private String phoneNumber;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public static AddressEntity valueOf(AddressDTO addressDTO) {
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setAddress(addressDTO.getAddress());
		addressEntity.setCity(addressDTO.getCity());
		addressEntity.setState(addressDTO.getState());
		addressEntity.setPinCode(addressDTO.getPinCode());
		addressEntity.setPhoneNumber(addressDTO.getPhoneNumber());
		return addressEntity;
	}
}
