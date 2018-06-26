package com.ekart.product.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.product.service.ProductService;

@RestController
public class ProductController {
	Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	private ProductService productService;

	@Autowired
	Environment env;

	
	/* 
	 @PutMapping(value = "/{userId}/address/{addressId}/modify", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> modifyAddress(@PathVariable("userId") String userId,
			@PathVariable("addressId") String addressId, @Valid @RequestBody AddressDTO addressDTO,
			BindingResult bindingResult) throws AddressNotFoundException {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(bindingResult.getFieldError().getDefaultMessage());
		}
		String result = this.addressService.modifyAddress(addressId, addressDTO);
		return new ResponseEntity<String>(env.getProperty(result), HttpStatus.OK);
	} 
	 */
}
