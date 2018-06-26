package com.ekart.user.exception;

@SuppressWarnings("serial")
public class UserAlreadyExistsException extends Exception {

	public UserAlreadyExistsException(String exception) {
		super(exception);
	}

}