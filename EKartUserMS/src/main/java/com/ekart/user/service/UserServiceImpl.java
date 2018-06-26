package com.ekart.user.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.user.dto.LoginDTO;
import com.ekart.user.dto.RegistrationDTO;
import com.ekart.user.dto.UpdateDTO;
import com.ekart.user.entity.UserEntity;
import com.ekart.user.exception.UserInvalidException;
import com.ekart.user.exception.UserAlreadyExistsException;
import com.ekart.user.repository.UserRespository;
import com.ekart.user.utility.Role;

@Service
public class UserServiceImpl implements UserService {

	Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	private UserRespository userRepository;

	@Override
	public String login(LoginDTO loginDTO) throws UserInvalidException {
		String result = null;
		UserEntity userEntity = userRepository.getOne(loginDTO.getUserId());
		if (userEntity == null || !loginDTO.getPassword().equals(userEntity.getPassword())) {
			throw new UserInvalidException("UserService.LOGIN_FAILED");
		}
		logger.info("User :" + loginDTO.getUserId() + " logged in Successfully, role is :" + userEntity.getUserType());
		if (userEntity.getUserType().equals(Role.SELLER.getRole())) {
			result = "Seller: " + userEntity.getName();
		} else {
			result = "UserService.LOGIN_SUCCESS";
		}
		return result;
	}

	@Override
	public String register(RegistrationDTO registrationDTO) throws UserAlreadyExistsException {
		if (userRepository.existsById(registrationDTO.getUserId())) {
			throw new UserAlreadyExistsException("UserService.REGISTER_FAILED");
		}
		userRepository.save(RegistrationDTO.valueOf(registrationDTO));
		return "UserService.REGISTER_SUCCESS";
	}

	@Override
	public String update(String userId, UpdateDTO updateDTO) throws UserInvalidException {
		UserEntity userEntity = userRepository.getOne(userId);
		if (userEntity == null) {
			throw new UserInvalidException("UserService.LOGIN_FAILED");
		}
		userEntity.setName(updateDTO.getName());
		userEntity.setPassword(updateDTO.getPassword());
		userRepository.save(userEntity);
		return "UserService.UPDATE_SUCCESS";
	}

}
