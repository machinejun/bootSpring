package com.example.demoex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@GetMapping("/user")
	public String user() {
		return "hello Spring";
	}
	
	@GetMapping("/home")
	public String home() {
		return "{\r\n"
				+ "	\"name\":\"홍길동\",\r\n"
				+ "	\"address\":\"부산\"\r\n"
				+ "}";
	}
}
