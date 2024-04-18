package com.api.controller.register;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.register.RegisterInforUserDto;
import com.api.entity.UserEntity;
import com.api.service.register.RegisterUserService;

import jakarta.validation.Valid;

@RestController
public class RegisterController {
	private final RegisterUserService registerUserService;
    
    public RegisterController(RegisterUserService registerUserService) {
		super();
		this.registerUserService = registerUserService;
	}


	
    @PostMapping("/register")
	public ResponseEntity<String> createUser(@RequestBody @Valid RegisterInforUserDto registerInforUserDto){
	    UserEntity userRegister = registerUserService.createUser(registerInforUserDto);
		if(userRegister != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Account created!");
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already available.");
	}
}
