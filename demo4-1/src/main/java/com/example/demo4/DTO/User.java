package com.example.demo4.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * {
 * 	"name" : "kkk"
 * 	"age : 30,
 * 	"phone_number" : "010-1234-1234"
 * 	"addresss" : "부산시 해운대구 우동"
 * }
 * 
 *
 */

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)  // 널값은 보내지 않는다. but >> 변동이 있기에 클라이언트 불편하다
public class User {
	private String name;
	private int age;
	private String phoneNumber;
	private String addresss;
	private String idName;
	
	
	public String getIdName() {
		return idName;
	}
	public void setIdName(String idName) {
		this.idName = idName;
	}
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddresss() {
		return addresss;
	}
	public void setAddresss(String addresss) {
		this.addresss = addresss;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + ", addresss=" + addresss + "]";
	}
	
	
	
	
}
