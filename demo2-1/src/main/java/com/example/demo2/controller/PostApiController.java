package com.example.demo2.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.dto.UserRequest;

@RestController
@RequestMapping("/api2")
public class PostApiController {
	 
	/**
	 * post 방식으로 데이터를 입력할 때 Json 형식으로 데이터를 보내준다.
	 * 서버는 Json 문자열을 받는 것이다.
	 * 
	 * {
	 * 		"name" : "value"   // : 양옆에 스페이스 까먹지 말자
	 * 		"age" : value
	 * }
	 * 
	 */
	
	
	//http://localhost:9090/api2/post1 (POST 방식)
	// 1번. 맵방식
	@PostMapping("/post1")
	public String post1(@RequestBody Map<String, Object> requestData) {
		System.out.println("post1 test1");
		StringBuilder sb = new StringBuilder();
		
		requestData.entrySet().forEach(entry -> {

			System.out.println(entry.getKey() + " : " + entry.getValue());
			sb.append(entry.getKey() + "=" + entry.getValue());
		});
		return sb.toString();
	}
	
	// 2. DTO 방식
	// java / mobile
	// 네트워크 통신을 할 때 버퍼드(reader, writer)가 문자열 입력,출력( + Json parsing)
	// 왜 자동으로 문자열이 Object가 되는가 ?
	// 메세지 컨버터가 자동으로 문자열을 파싱해서  --> UserRequest에 맵핑을 해주고 있다.
	@PostMapping("/post2")
	public String post2(@RequestBody UserRequest request) {
		
		return request.toString();
	}
}
