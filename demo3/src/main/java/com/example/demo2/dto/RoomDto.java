package com.example.demo2.dto;

public class RoomDto {
	private String name;
	private int roomNum;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	@Override
	public String toString() {
		return "RoomDto [name=" + name + ", roomNum=" + roomNum + "]";
	}
	
	

}
