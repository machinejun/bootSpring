package com.example.jsp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/board")
@Controller
public class BoardController {
	@GetMapping("/index")
	public String index() {
		/*
		 *  viewresourve 라는 친구가 
		 *  prefix: /WEB-INF/views/
		 *  suffix: .jsp
		 *  /WEB-INF/views/index.jsp 찾아감
		 *  
		 */
		
		return "idnex";
	}
	
	@GetMapping("/example1")
	public String example1() {
		return "example1";
	}
	
	@GetMapping("/example2")
	public String example2() {
		return "example2";
	}
	
	@GetMapping("/if")
	public String if2(@RequestParam String color) {
		return "if";
	}

	@GetMapping("/while")
	public String while2() {
		return "while";
	}
	
	@GetMapping("/for")
	public String for2() {
		return "for";
	}
	
	@GetMapping("/round")
	public String round() {
		return "round";
	}
}

