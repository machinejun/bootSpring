package com.example.demo2.Controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.dto.RoomDto;

@RestController
@RequestMapping("/api/post")
public class PostApiController {
	
	@PostMapping("/postRoom")
	public String postRoom(@RequestBody Map<String, Object> data) {
		StringBuilder sb = new StringBuilder();
		data.entrySet().forEach(entrt -> {
			sb.append( entrt.getKey()+" : " + entrt.getValue() + "\n");
		});
		return sb.toString();
	}
	
	@PostMapping("/postRoom2")
	public String postRoom(@RequestBody RoomDto dto) {
		return dto.toString();
	}
	

}
