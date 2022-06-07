package com.example.demo3.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// @Controller --> 페이지를 리턴할 때 사용
@RestController
@RequestMapping("/api2/")
public class DeleteApiController {
	
	@DeleteMapping("/delete/{userId}")
	public String delete(@PathVariable String userId, @RequestParam String account) {
		StringBuilder br = new StringBuilder();
		br.append("userId : " + userId + "\n");
		br.append("account : " + account);
		
		return br.toString();
	}

}
