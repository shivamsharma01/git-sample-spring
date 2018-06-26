package com.ekart.user.advice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ekart.user.exception.UserInvalidException;
import com.ekart.user.exception.UserAlreadyExistsException;

@ControllerAdvice
public class UserControllerAdvice {

	private static Logger logger = LogManager.getLogger(UserControllerAdvice.class);

	@Autowired
	Environment env;

	@ExceptionHandler(UserInvalidException.class)
	public ResponseEntity<String> invalidUserException(UserInvalidException e) {
		logger.error(this.getClass().getName() + " : InvalidUserIdPasswordException:" + e.getMessage());
		String output = env.containsProperty(e.getMessage()) ? env.getProperty(e.getMessage()) : e.getMessage();
		return ResponseEntity.badRequest().body(output);
	}

	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<String> duplicateUserException(UserAlreadyExistsException e) {
		logger.error(this.getClass().getName() + " : UserAlreadyExistsException:" + e.getMessage());
		String output = env.containsProperty(e.getMessage()) ? env.getProperty(e.getMessage()) : e.getMessage();
		return ResponseEntity.status(HttpStatus.CONFLICT).body(output);
	}

}
