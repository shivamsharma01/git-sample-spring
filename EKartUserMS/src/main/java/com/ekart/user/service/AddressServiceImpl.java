package com.ekart.user.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.user.dto.AddressDTO;
import com.ekart.user.entity.AddressEntity;
import com.ekart.user.exception.AddressNotFoundException;
import com.ekart.user.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public String addAddress(String userId, AddressDTO addressDTO) {
		AddressEntity addressEntity = AddressDTO.valueOf(addressDTO);
		addressEntity.setUserId(userId);
		this.addressRepository.save(addressEntity);
		return "AddressService.ADD_ADDRESS";
	}

	@Override
	public String modifyAddress(Integer addressId, AddressDTO addressDTO) throws AddressNotFoundException {
		AddressEntity addressEntity = addressRepository.getOne(addressId);
		if (addressEntity == null) {
			throw new AddressNotFoundException("AddressService.MODIFY_ADDRESS_FAILURE");
		}
		addressEntity.setAddress(addressDTO.getAddress());
		addressEntity.setCity(addressDTO.getCity());
		addressEntity.setState(addressDTO.getState());
		addressEntity.setPinCode(addressDTO.getPinCode());
		addressEntity.setPhoneNumber(addressDTO.getPhoneNumber());
		this.addressRepository.save(addressEntity);
		return "AddressService.MODIFY_ADDRESS_SUCCESS";
	}

	@Override
	public String removeAddress(String userId, Integer addressId) throws AddressNotFoundException {
		AddressEntity addressEntity = addressRepository.getOne(addressId);
		if (addressEntity == null) {
			throw new AddressNotFoundException("AddressService.REMOVE_ADDRESS_FAILURE");
		}
		addressRepository.delete(addressEntity);
		return "AddressService.REMOVE_ADDRESS_SUCCESS";
	}

	@Override
	public AddressDTO getOne(Integer addressId) throws AddressNotFoundException {
		AddressEntity addressEntity = addressRepository.getOne(addressId);
		if (addressEntity == null) {
			throw new AddressNotFoundException("AddressService.GET_ONE_ADDRESS_FAILURE");
		}
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setAddressId(addressEntity.getAddressId());
		addressDTO.setAddress(addressEntity.getAddress());
		addressDTO.setCity(addressEntity.getCity());
		addressDTO.setState(addressEntity.getState());
		addressDTO.setPhoneNumber(addressEntity.getPhoneNumber());
		addressDTO.setPinCode(addressEntity.getPinCode());
		return addressDTO;
	}

	@Override
	public List<AddressDTO> getAll(String userId) throws AddressNotFoundException {
		List<AddressEntity> listOfAddress = addressRepository.findByUserId(userId);
		if (listOfAddress.isEmpty()) {
			throw new AddressNotFoundException("AddressService.GET_ALL_ADDRESS_FAILURE");
		}
		AddressDTO addressDTO = null;
		List<AddressDTO> addressList = new ArrayList<>();
		for (AddressEntity addressEntity : listOfAddress) {
			addressDTO = new AddressDTO();
			addressDTO.setAddressId(addressEntity.getAddressId());
			addressDTO.setAddress(addressEntity.getAddress());
			addressDTO.setCity(addressEntity.getCity());
			addressDTO.setState(addressEntity.getState());
			addressDTO.setPhoneNumber(addressEntity.getPhoneNumber());
			addressDTO.setPinCode(addressEntity.getPinCode());
			addressList.add(addressDTO);
		}
		return addressList;
	}

}
