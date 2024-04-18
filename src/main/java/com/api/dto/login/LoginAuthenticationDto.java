package com.api.dto.login;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LoginAuthenticationDto(

		@NotBlank @NotNull @Email @Size(max = 255) String email,
		@NotBlank @NotNull @Size(max = 255) String password
		
		){}
