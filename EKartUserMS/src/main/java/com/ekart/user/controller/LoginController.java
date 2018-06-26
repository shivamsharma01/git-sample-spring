package com.ekart.user.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.user.dto.LoginDTO;
import com.ekart.user.dto.RegistrationDTO;
import com.ekart.user.dto.UpdateDTO;
import com.ekart.user.exception.UserInvalidException;
import com.ekart.user.exception.UserAlreadyExistsException;
import com.ekart.user.service.UserServiceImpl;

@RestController
public class LoginController {

	Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	Environment env;

	@PostMapping(value = "/login", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> login(@Valid @RequestBody LoginDTO loginDTO, BindingResult bindingResult)
			throws UserInvalidException {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(bindingResult.getFieldError().getDefaultMessage());
		}
		String result = this.userService.login(loginDTO);
		String output = env.containsProperty(result) ? env.getProperty(result) : result;
		return new ResponseEntity<String>(output, HttpStatus.OK);
	}

	@PostMapping(value = "/signup", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> register(@Valid @RequestBody RegistrationDTO registrationDTO,
			BindingResult bindingResult) throws UserAlreadyExistsException {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(bindingResult.getFieldError().getDefaultMessage());
		};
		String result = this.userService.register(registrationDTO);
		String output = env.containsProperty(result) ? env.getProperty(result) : result;
		return new ResponseEntity<String>(output, HttpStatus.OK);
	}

	@PostMapping(value = "/{userId}/update", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> register(@PathVariable("userId") String userId,
			@Valid @RequestBody UpdateDTO updateDTO, BindingResult bindingResult) throws UserInvalidException {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(bindingResult.getFieldError().getDefaultMessage());
		}
		String result = this.userService.update(userId, updateDTO);
		String output = env.containsProperty(result) ? env.getProperty(result) : result;
		return new ResponseEntity<String>(output, HttpStatus.OK);
	}

}
