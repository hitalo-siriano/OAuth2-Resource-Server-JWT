package com.api.service.login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.api.dto.login.LoginAuthenticationDto;
import com.api.dto.login.LoginValidDto;
import com.api.repository.login.LoginValidUserExistingRepository;

@Service
public class AuthenticationService implements UserDetailsService {
      private LoginValidUserExistingRepository existingRepository;
	  public AuthenticationService(LoginValidUserExistingRepository existingRepository) {
		super();
		this.existingRepository = existingRepository;
	}
	@Override
	   public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	       
	        return existingRepository.findByEmail(email);
	       
	    }    

	
}
