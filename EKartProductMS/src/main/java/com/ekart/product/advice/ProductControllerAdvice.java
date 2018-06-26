package com.ekart.product.advice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ProductControllerAdvice {

	private static Logger logger = LogManager.getLogger(ProductControllerAdvice.class);
//
//	@ExceptionHandler(UserInvalidException.class)
//	public ResponseEntity<String> invalidUserException(UserInvalidException e) {
//		logger.error(this.getClass().getName() + " : InvalidUserIdPasswordException:" + e.getMessage());
//		return ResponseEntity.badRequest().body(e.getMessage());
//	}
//
//	@ExceptionHandler(UserAlreadyExistsException.class)
//	public ResponseEntity<String> duplicateUserException(UserAlreadyExistsException e) {
//		logger.error(this.getClass().getName() + " : UserAlreadyExistsException:" + e.getMessage());
//		return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
//	}

}
