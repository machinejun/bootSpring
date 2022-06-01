package com.example.validation.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation.Dto.User;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@GetMapping("/hello")
		public String hello() {
			
			return "<h1>hello<h1>";
		}
	
	@GetMapping("/user")
	public User User() {
		
		User user = new User();
		
		user.setName("홍길동");
		user.setAge(10);
		return user;
	}
	
}
