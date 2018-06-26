package com.ekart.product.advice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ReviewControllerAdvice {
	private static Logger logger = LogManager.getLogger(ReviewControllerAdvice.class);
	//
	// @ExceptionHandler()
	// public ResponseEntity<String> invalidAddressException() {
	// logger.error(this.getClass().getName() + " : AddressNotFoundException:" +
	// e.getMessage());
	// return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	// }

}
