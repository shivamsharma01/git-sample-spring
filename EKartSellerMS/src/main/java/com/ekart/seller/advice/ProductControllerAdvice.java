package com.ekart.seller.advice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ekart.seller.exception.NoItemException;

@ControllerAdvice
public class ProductControllerAdvice {

	private static Logger logger = LogManager.getLogger(ProductControllerAdvice.class);

	@Autowired
	Environment env;

	@ExceptionHandler(NoItemException.class)
	public ResponseEntity<String> invalidUserException(NoItemException e) {
		logger.error(this.getClass().getName() + " : NoItemException:" + e.getMessage());
		String output = env.containsProperty(e.getMessage()) ? env.getProperty(e.getMessage()) : e.getMessage();
		return ResponseEntity.badRequest().body(output);
	}

}
