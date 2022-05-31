package com.example.validation.Controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation.Dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	// Post 방식에 대한 Valid 확인 ★★★★★★★★★ 반드시 "@Valid"를 지정해 주어야 한다.
	@PostMapping("/user")
	public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult) {
//		if(user.getAge() < 1 || user.getAge() > 110) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);    ->>>> Validation을 사용한다면 DTO에 Validation 검사를 위임할 수 있다.
//		}
		// 에러가 발생시 custom 해서 프론트 개발자가 잘 처리 할 수 있도록 설계해야한다.
		// BindingResult 가 @Valid 대한 결과값을 가지고 있다.
		if(bindingResult.hasErrors()) {
			// 여기서 처리
			StringBuilder sb = new StringBuilder();
			bindingResult.getAllErrors().forEach(error -> {
				FieldError field = (FieldError) error;
				String message = field.getDefaultMessage();
				System.out.println("field : " + field.getField());
				System.out.println("message : " + message);
				sb.append("field : " + field.getField() +"\n");
				sb.append("message : " + message + "\n");
			});
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb);
		}
		System.out.println(user);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
	}
}
