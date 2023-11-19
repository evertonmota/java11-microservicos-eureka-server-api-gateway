package com.devsuperior.msoauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devsuperior.msoauth.entitites.User;
import com.devsuperior.msoauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService{

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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =  userFeignClient.findByUserName(username).getBody();
		
		if(user == null) {
			logger .error("User Name not found " + username);
			throw new UsernameNotFoundException("User name not found.");
		}
		logger.info("User Name encontrado foi : " +username); 
		return user;
	}
}
