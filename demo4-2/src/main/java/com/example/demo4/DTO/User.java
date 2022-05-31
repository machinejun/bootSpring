package com.example.demo4.DTO;

public class User {
	public int id;
	private String userName;
	private String password;
	

	
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName +", id: " + id +", password=" + password + "]";
	}
	
	
	
	
	
	
	
}
