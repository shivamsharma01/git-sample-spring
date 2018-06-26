package com.ekart.product.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.product.service.ProductService;
import com.ekart.product.service.ReviewService;

@RestController
public class ReviewController {
	
	Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	private ReviewService reviewService;

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
