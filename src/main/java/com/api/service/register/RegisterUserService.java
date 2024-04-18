package com.api.service.register;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.dto.register.RegisterInforUserDto;
import com.api.entity.UserEntity;
import com.api.repository.register.RegisterUserRepository;



@Service
public class RegisterUserService{
	@Autowired
    RegisterUserRepository repository;
	
	
	
public UserEntity createUser(RegisterInforUserDto registerInforUserDto){
		try {
			UserEntity userInfo = new UserEntity();

			userInfo.setName(registerInforUserDto.name());
		    userInfo.setEmail(registerInforUserDto.email());
		    userInfo.setFone(registerInforUserDto.fone());
		    userInfo.setPassword(new BCryptPasswordEncoder().encode(registerInforUserDto.password()));
		    userInfo.setRole(registerInforUserDto.role());
		 
		    return repository.save(userInfo);
	    
		}catch (Exception e) {
			return null;		
		}
	}

}
