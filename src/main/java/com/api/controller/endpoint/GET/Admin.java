package com.api.controller.endpoint.GET;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Admin {
	@GetMapping("/admin")
	public String admin() {
		return "Hello , Admin!";
	}

}
