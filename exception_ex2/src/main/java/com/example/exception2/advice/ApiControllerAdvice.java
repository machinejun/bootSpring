package com.example.exception2.advice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exception2.dto.CustomError;

import ch.qos.logback.core.joran.action.Action;

@RestControllerAdvice
public class ApiControllerAdvice {
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e){
		System.out.println("예외 발생");
		System.out.println("===================");
		System.out.println(e.getClass());
		System.out.println(e.getMessage());
		System.out.println(e.getCause());
		System.out.println("===================");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}
	
	// GET 방식에서 받아야 되는 파라메터가 없을 때 사용한다.
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<?> missExcption(MissingServletRequestParameterException e){
		System.out.println("MissingServletRequestParameterException 발생");
		String fieldName = e.getParameterName();
		String fieldType = e.getParameterType();
		String invalidValue = e.getMessage();
		
		System.out.println("field : " + fieldName);
		System.out.println("fieldtype : " + fieldType);
		System.out.println("message : " + invalidValue);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldName + "입력해야 합니다.");
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> metodArgumentNotValidException(MethodArgumentNotValidException e){
		System.out.println("MethodArgumentNotValidException");
		// 한번에 전부 들어온다.
		List<CustomError> errolist = new ArrayList<CustomError>();
		BindingResult bindingResult = e.getBindingResult();
		bindingResult.getAllErrors().forEach(action -> {
			FieldError error = (FieldError)action;
			String fieldName = error.getField();
			String message = error.getDefaultMessage();
			CustomError customError = new CustomError();
			customError.setField(fieldName);
			customError.setMessage(message);
			errolist.add(customError);
		});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errolist);
	}
		
		
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<?> constraintViolationException(ConstraintViolationException e){
		
		System.out.println("ConstraintViolationException 발생");
		List<CustomError> errorList = new ArrayList<CustomError>();
		
		e.getConstraintViolations().forEach(error -> {
			String strFiled = error.getPropertyPath().toString();
			int index = strFiled.indexOf(".");
			String fieldName = strFiled.substring(index + 1);
			String message = error.getMessage();
			CustomError customError = new CustomError();
			customError.setField(fieldName);
			customError.setMessage(message);
			errorList.add(customError);
		});
		System.out.println(errorList);
				
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	}
		

}
