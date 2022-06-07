package com.example.filter.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import lombok.extern.slf4j.Slf4j;


// filter >> 로깅 처리를 많이 한다.
// url 확인, 특정 코드를 집어 넣어야 할 때 사용을 많이 한다.
@Slf4j
@WebFilter(urlPatterns = "/api/*")
public class GlobalFilter implements Filter{@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("doFilter 호출");
		ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(
				(HttpServletRequest)request);
		
		ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(
				(HttpServletResponse)response);
		
		chain.doFilter(requestWrapper, responseWrapper);
		
		//req
		String url = requestWrapper.getRequestURI();
		log.info("request url : {}, request body : {}", url, requestWrapper.getContentAsByteArray());
		
		
		//res
		String resContent = new String(responseWrapper.getContentAsByteArray());
		int httpStatusCode = responseWrapper.getStatus();
		responseWrapper.copyBodyToResponse(); // 응답을 처리 하기 위해서 반드시 코드에 추가해야 한다.
		log.info("response status : {}, responseBody : {}", httpStatusCode, resContent);
		
	}
	// 메모리에 올리지 않고 작동하는 이유
	/*
	 *  스프링중에 가장 핵심 개념 1. IoC = 제어의 역전 >> 제어의 흐름을 사용자가 컨트롤 하지 않고 위임한 특별한 객체에게 맞기는 것
	 *    
	 */
	
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		
//		// servlet <== http통신 확장 클래스 , 자바 언어로 웹 프로그래밍을 하기 위해 만들어진 클래스
//		log.info("제일 먼저 request(요청)에 대해서 처리해보기");
//		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
//		log.info("req : {}", httpServletRequest.getProtocol());
//		log.info("req : {}", httpServletRequest.getHeaderNames().toString());
//		
//		// 필터를 사용하게 되면 ApiController까지 도달하지 못한다.
//		// 기본적으로 한번 읽은 request는 다시 읽을 수 없다.
//		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
//		log.info("res : {}", httpServletResponse.getBufferSize());
//		
//	}
	// Filter 기능을 활용하기 위해서는 구현 받아야 합니다.
	
	

}
