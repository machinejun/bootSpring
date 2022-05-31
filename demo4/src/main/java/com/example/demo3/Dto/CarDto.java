package com.example.demo3.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarDto {
	
	private String name;
	@JsonProperty("car_name") // json과 변수명이 다르게 설정
	private String carName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	@Override
	public String toString() {
		return "CarDto [name=" + name + ", carName=" + carName + "]";
	}

}
