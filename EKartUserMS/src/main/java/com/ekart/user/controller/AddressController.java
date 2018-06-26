package com.ekart.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.user.dto.AddressDTO;
import com.ekart.user.exception.AddressNotFoundException;
import com.ekart.user.service.AddressService;

@RestController
public class AddressController {
	Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	private AddressService addressService;

	@Autowired
	Environment env;

	@PostMapping(value = "/{userId}/address/add", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> addAddress(@PathVariable("userId") String userId,
			@Valid @RequestBody AddressDTO addressDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(bindingResult.getFieldError().getDefaultMessage());
		}
		String result = this.addressService.addAddress(userId, addressDTO);
		String output = env.containsProperty(result) ? env.getProperty(result) : result;
		return new ResponseEntity<String>(output, HttpStatus.OK);
	}

	@PutMapping(value = "/{userId}/address/{addressId}/modify", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> modifyAddress(@PathVariable("userId") String userId,
			@PathVariable("addressId") Integer addressId, @Valid @RequestBody AddressDTO addressDTO,
			BindingResult bindingResult) throws AddressNotFoundException {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(bindingResult.getFieldError().getDefaultMessage());
		}
		String result = this.addressService.modifyAddress(addressId, addressDTO);
		String output = env.containsProperty(result) ? env.getProperty(result) : result;
		return new ResponseEntity<String>(output, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{userId}/address/{addressId}/delete", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> removeAddress(@PathVariable("userId") String userId,
			@PathVariable("addressId") Integer addressId) throws AddressNotFoundException {
		String result = this.addressService.removeAddress(userId, addressId);
		String output = env.containsProperty(result) ? env.getProperty(result) : result;
		return new ResponseEntity<String>(output, HttpStatus.OK);
	}

	@GetMapping(value = "/{userId}/address/{addressId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<AddressDTO> getOne(@PathVariable("userId") String userId,
			@PathVariable("addressId") Integer addressId) throws AddressNotFoundException {
		return new ResponseEntity<AddressDTO>(this.addressService.getOne(addressId), HttpStatus.OK);
	}

	@GetMapping(value = "/{userId}/address/", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<AddressDTO>> getAll(@PathVariable("userId") String userId)
			throws AddressNotFoundException {
		return new ResponseEntity<List<AddressDTO>>(this.addressService.getAll(userId), HttpStatus.OK);
	}
}
