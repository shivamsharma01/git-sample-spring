package com.ekart.seller.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.seller.dto.ProductDTO;
import com.ekart.seller.service.ProductService;

@RestController
public class ProductController {
	Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	private ProductService productService;

	@Autowired
	Environment env;

	@PostMapping(value = "/{sellerId}/product/add")
	public ResponseEntity<String> addProduct(@PathVariable("sellerId") String sellerId,
			@Valid @RequestBody ProductDTO productDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("Has Error");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(bindingResult.getFieldError().getDefaultMessage());
		}
		String result = this.productService.add(sellerId, productDTO);
		String output = env.containsProperty(result) ? env.getProperty(result) : result;
		return new ResponseEntity<String>(output, HttpStatus.OK);
	}

}
