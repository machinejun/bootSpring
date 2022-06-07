package com.example.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice // 컨트롤러 예외처리, 뷰리졸뷰,  data (messageConverter)
//모든 예외상황을 처리하고 싶을 때 사용
//@RestControllerAdvice(basePackages = "com.example.exception.controller")  // 특정 패키지에서만 동작시키고 싶을때

@RestControllerAdvice // 아무것도 선언하지 않으면 글로벌이 된다.
public class GlobalControllerAdvice {
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> except(Exception e){
		
		System.out.println("======================");
		System.out.println(e.getClass());
		System.out.println(e.getMessage());
		System.out.println("======================");
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("넌 어떠한 것을 잘못함");
	}
	
	// 특정 예외 상황에서는 다른 응답처리를 하고 싶을 때 or 다른 로직을 만들고 싶을 때
	// MissingServletRequestParameterException 만  예외처리를 하고 싶어
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException e){
		
		System.err.println(e.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error:  " + e.getMessage());
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e){
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("advice: " + e.getMessage());
	}
	
}
