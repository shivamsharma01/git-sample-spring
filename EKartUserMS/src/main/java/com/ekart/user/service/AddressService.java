package com.ekart.user.service;

import java.util.List;

import com.ekart.user.dto.AddressDTO;
import com.ekart.user.exception.AddressNotFoundException;

public interface AddressService {
	public String addAddress(String userId, AddressDTO addressDTO);

	public String modifyAddress(Integer addressId, AddressDTO addressDTO) throws AddressNotFoundException;

	public String removeAddress(String userId, Integer addressId) throws AddressNotFoundException;

	public AddressDTO getOne(Integer addressId) throws AddressNotFoundException;

	public List<AddressDTO> getAll(String userId) throws AddressNotFoundException;
}
