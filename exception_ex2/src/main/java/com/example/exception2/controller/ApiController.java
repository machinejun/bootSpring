package com.example.exception2.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception2.dto.User;

@RestController
@RequestMapping("/api")
@Validated
public class ApiController {
	
	@GetMapping("/user")
	public User usr(@Size(min = 2, max = 20) @RequestParam(required = true) String name,
			@NotNull @Min(1) @RequestParam(required = true) Integer age) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		return user;
	}
	
	// get과 post의 주소가 같아도 방식이 다르기 때문에 컴파일러가 구분할 수 있다.
	// 또한 메서드 오버로딩으로 매개변수가 다르기 때문에 같은 메서드명도 구분할 수 있따.
	
	@PostMapping("/user")
	public User user(@Valid @RequestBody User user) {
		
		return user;
	}
}
