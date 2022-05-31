package com.example.demo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * 주소 설계 규칙
 * http://____:9090/api/get
 * http://____:9090/api/post
 * http://____:9090/api/delete
 * http://____:9090/api/.....
 */
@RestController
@RequestMapping("/api/get")
public class ApiController {
	
	//http://localhost:9090/api/get/hello
	@GetMapping("/hello")
	public String getHello() {
		return "say hello~~";
	}
	
	/*
	 * URl : 자원을 요청하는 주소 체계방식 
	 * |
	 * URI : 식별자 방식
	 */
	
	// get방식 -> URI 방식 ( 데이터를 담아서 요청 ) --> 처리 --> 응답
	// path-variable 방식
	//http://localhost:9090/api/get/path-varialbe/[xxx]
	@GetMapping(path = "/path-variable/{name}")
	public String queryParam(@PathVariable(name = "name") String name) {
		
		System.out.println("브라우져에서 들어온 값을 받음 : " + name);
		return "[[" + name + "]]";
	}
	
	@GetMapping(path = "/path-variable/{name}/{age}")
	public String queryParam(@PathVariable(name="name") String name, @PathVariable(name="age") int age) {
		System.out.println("name: " + name +", " + "age : " + age);
		return "name: " + name +", " + "age : " + age;
	}
	@GetMapping(path ="/color/{title}")
	public String queryParam2(@PathVariable(name="title")String title) {
		return "this is "+title+"!!!!!!";
	}
	
	// 새로운 주소체계  요청 + 응답 확인
	@GetMapping(path ="/color/{title}/{entitle}")
	public String queryPara(@PathVariable(name="title") String title, @PathVariable(name="entitle") String entitle) {
		
		return "{\r\n"
				+ "	\"title\":\"" + title + "\",\r\n"
				+ "	\"entitle\":\"" +entitle+ "\"\r\n"
				+ "}";
	}
}
