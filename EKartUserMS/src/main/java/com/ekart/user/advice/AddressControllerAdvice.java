package com.ekart.user.advice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ekart.user.exception.AddressNotFoundException;

@ControllerAdvice
public class AddressControllerAdvice {
	private static Logger logger = LogManager.getLogger(AddressControllerAdvice.class);

	@Autowired
	Environment env;

	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<String> invalidAddressException(AddressNotFoundException e) {
		logger.error(this.getClass().getName() + " : AddressNotFoundException:" + e.getMessage());
		String output = env.containsProperty(e.getMessage()) ? env.getProperty(e.getMessage()) : e.getMessage();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(output);
	}

}
