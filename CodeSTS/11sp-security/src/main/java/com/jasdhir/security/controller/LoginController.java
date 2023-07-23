package com.jasdhir.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login123")
	public String getLogin() {
		System.out.println("Login Called .....................");
		return "login";
	}

}
