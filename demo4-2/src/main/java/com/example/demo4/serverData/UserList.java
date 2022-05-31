package com.example.demo4.serverData;

import java.util.ArrayList;

import com.example.demo4.DTO.User;

public class UserList {
	private static UserList instance;
	ArrayList<User> userList ;
	
	
	
	private UserList() {
		this.userList =new ArrayList<User>(); 
	}
	
	public static UserList getinstance() {
		if(instance == null) {
			instance = new UserList();
		}
		return instance;
	}
	
	public ArrayList<User> getUserList(){
		return userList;
	}
	
	public void signUpUser(User user) {
		userList.add(user);
	}
	
	
	
}
