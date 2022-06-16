package com.example.mvc_demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	
	@GetMapping("/home")
	public String home(Model model) {
		// UI 객체인 Model 객체를 조정할 수 있다.
		model.addAttribute("name", "junic");
		
		return "home";
	}
	
	@GetMapping("/spring")
	public String spring(Model model) {
		Map<String, String> mp = new HashMap<String, String>();
		mp.put("spring", "hello World");
		mp.put("study", "스프링의 이름은 왜 스프링인 걸까?");
		model.addAllAttributes(mp);
		return "spring";
	}
}
