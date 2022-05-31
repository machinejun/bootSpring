package com.example.demo2.Controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.dto.RoomDto;

@RestController
@RequestMapping("api/get")
public class GetApiController {
	
	//맵핑
	@GetMapping("/home")
	public String getHome() {
		return "this is my Home";
	}
	
	//path-Variable 방식
	@GetMapping("/home/{room}/{roomNum}")
	public String getRoom(@PathVariable(name="room")String name, @PathVariable(name="roomNum")int roomNum) {
		String result = "이 방은 " + name +"입니다, \n" + "방 이름 : " + roomNum;
		return result;
	}
	
	//Query-Parameter 방식
	
	//1. 키값
	@GetMapping("q")
	public String findRoom(@RequestParam String name, @RequestParam int roomNum) {
		String result = "이방식은 파람 키값 지정방식 입니다.\r\n"
				+ "이 방은" + name +"입니다,\n\r" + "방 이름 : " + roomNum;
		return result;
	}
	
	@GetMapping("kq")
	public String findRoom(@RequestParam Map<String, String> data) {
		StringBuilder sb = new StringBuilder();
		data.entrySet().forEach(entry -> {
			sb.append("이방식은 파람 맵을 사용한 방식 입니다.\r\n"
					+ "이 방은" + entry.getValue().toString() +"입니다,\n\r" + "방 이름 : " + entry.getValue().toString());
		});
		
		return sb.toString();
	}
	
	@GetMapping("dtoq")
	public String findRoom(RoomDto room) {
		System.out.println(room.toString());
		System.out.println("방 이름: " + room.getName());
		System.out.println("방 번호: " + room.getRoomNum());
		return room.toString();
	}

}
