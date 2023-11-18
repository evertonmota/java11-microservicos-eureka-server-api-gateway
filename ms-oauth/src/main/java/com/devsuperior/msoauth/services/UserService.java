package com.devsuperior.msoauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.msoauth.entitites.User;
import com.devsuperior.msoauth.feignclients.UserFeignClient;

@Service
public class UserService {

	@Autowired 
	private UserFeignClient userFeignClient;
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	public User findUserByEmail(String email) {
		//return userFeignClient.findByEmail(email);
		User user =  userFeignClient.findByEmail(email).getBody();
		
		if(user == null) {
			logger .error("email not found " + email);
			throw new IllegalArgumentException("E-mail not found.");
		}
		logger.info("Email encontrado foi : " +email); 
		return user;
	}
}
