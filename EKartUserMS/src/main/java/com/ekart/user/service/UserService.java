package com.ekart.user.service;

import com.ekart.user.dto.LoginDTO;
import com.ekart.user.dto.RegistrationDTO;
import com.ekart.user.dto.UpdateDTO;
import com.ekart.user.exception.UserInvalidException;
import com.ekart.user.exception.UserAlreadyExistsException;

public interface UserService {
	public String login(LoginDTO loginDTO) throws UserInvalidException;

	public String register(RegistrationDTO registrationDTO) throws UserAlreadyExistsException;

	public String update(String userId, UpdateDTO updateDTO) throws UserInvalidException;
}
