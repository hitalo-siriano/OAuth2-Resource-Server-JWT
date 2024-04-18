package com.api.controller.login;

import java.util.Collection;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.login.LoginAuthenticationDto;
import com.api.dto.login.LoginValidDto;
import com.api.entity.UserEntity;
import com.api.service.jwt.GenerateJwtService;
import com.api.service.login.AuthenticationService;
import jakarta.validation.Valid;

@RestController
public class LoginController{
     @Autowired
	 GenerateJwtService generateJwtService;
     @Autowired
	 AuthenticationManager authenticationManager;
     
	


	
	
	
    @PostMapping("/login")
	public ResponseEntity<String> Login(@RequestBody @Valid LoginAuthenticationDto loginAuthenticationDto) {
	   try {
    	  var usernamePassword = new UsernamePasswordAuthenticationToken(loginAuthenticationDto.email(), loginAuthenticationDto.password());
    	  var authentication = this.authenticationManager.authenticate(usernamePassword);
    	  var jwt = generateJwtService.tokenValid((UserEntity)authentication.getPrincipal());
    	  return ResponseEntity.status(HttpStatus.ACCEPTED).body(jwt);
    	  
		}catch (AuthenticationException e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas.");
			
		} 
	}
}
