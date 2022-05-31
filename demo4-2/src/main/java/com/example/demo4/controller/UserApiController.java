package com.example.demo4.controller;

import java.util.ArrayList;

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
import com.example.demo4.serverData.UserList;

@RestController
@RequestMapping("/api/user")
public class UserApiController {
	private static int id = 0;
	
	@PostMapping("/signUp")
	public User signUp(@RequestBody User user) {
		user.setId(id++);
		System.out.println(user.toString());
		UserList.getinstance().signUpUser(user);
		return user;
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> update(@RequestBody User user, @RequestParam String userName, @RequestParam String password) {
		ArrayList<User> uList = UserList.getinstance().getUserList();
		System.out.println(uList);
		for (User u : uList) {
			if(u.getUserName().equals(userName) && u.getPassword().equals(password)) {
				u.setUserName(user.getUserName());
				u.setPassword(user.getPassword());
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(u);
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@GetMapping("/getUsers")
	public ArrayList<User> getUsers(){
		return UserList.getinstance().getUserList();
	}
}
