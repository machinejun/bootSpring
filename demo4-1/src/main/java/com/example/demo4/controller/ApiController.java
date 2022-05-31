package com.example.demo4.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo4.DTO.User;

@RestController
@RequestMapping("api/")
public class ApiController {
	
	// text/planin
	@GetMapping("/text")
	public String text(@RequestParam String account) {
		return account;
	}
	
	// application/json
	@PostMapping("/json")
	// request --> Object Mapper --> object
	public User json(@RequestBody User user) {
		System.out.println(user.toString());
		return user;
	}
	
	// 202, 201 번  -> 응답을 돌려줄 때 응답 코드를 지정해서 보낼 수 있다.
	@PutMapping("/put")
	public ResponseEntity<User> put(@RequestBody User user){
		/*
		 * RespnseEntity를 통해서 status, header 등을 설정할 수 있다.
		 */
		return ResponseEntity.status(HttpStatus.OK).body(user); // 데이터 입력이 성공하면 201 코드를 반환
	}
}
