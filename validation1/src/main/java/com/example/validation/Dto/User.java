package com.example.validation.Dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * {
 *		"name" : "홍길동",
 *		"age" : 0,
 *		"email : "a@naver.com",
 *		"phoneNumber" : "010-1234-1234"
 * }
 * 
 *
 */
public class User {
	@NotBlank(message="이름을 입력해주세요")
	private String name;
	@Max(value=90, message = "당신은 너무 늙었습니다.")
	@Min(value = 5, message = "애새끼 안받습니다.")
	private int age;
	
	@Email
	private String email;
	private String PhonNumber;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonNumber() {
		return PhonNumber;
	}
	public void setPhonNumber(String phonNumber) {
		PhonNumber = phonNumber;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", email=" + email + ", PhonNumber=" + PhonNumber + "]";
	}
	
	

}
