package com.jasdhir.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping("/")
	public String getHome() {
		return "home";
	}
	
	@GetMapping("/loginMe")
	public String logIn() {
		System.out.println("Login Called....");
		return "login";
	}
}
