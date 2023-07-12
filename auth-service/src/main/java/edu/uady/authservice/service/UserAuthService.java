package edu.uady.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService {
	@Autowired
	UserRepository authRepository;
	
	public UserAuth createUser(UserAuth userAuth) {
		return authRepository.save(UserAuth);
	}
	
	public UserAuth findUserAut (String userName)throws Exception{
		return authRepository.findByUserName(userName).orElseThrow();
	}
}
