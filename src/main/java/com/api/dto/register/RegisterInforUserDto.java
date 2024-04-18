package com.api.dto.register;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterInforUserDto(
		
		@NotBlank @NotNull @Size(max = 255) String name,

		@NotBlank @NotNull @Size(max = 255, min = 8)  String password,
		@NotBlank @NotNull @Size(max = 255) @Email String email,
		@NotBlank @NotNull @Size(max = 15)  String fone,
		@NotBlank @NotNull @Size(max = 15)  String role
		
		){

}
