package proxy;

import java.util.concurrent.atomic.AtomicLong;

import Aop.AopBrowser;

/**
 * proxy 는 대리인 이라는 뜻으로, 무엇인가를 대신해서 처리하는 것
 * proxy class를 통해서 대신 전달하는 형태로 설계되며, 설계 client는 proxy 로 부터
 * 결과를 받는다.
 * Cache(캐쉬 : 메모리에 전달되어져 있는 친구를 빠르게 가져와 쓰는 것) 의 기능으로도 활용이 가능하다.
 * 즉, 한번 메모리에 로드 된것을 남겨 뒀다가 다시 내려줄 수 있다.
 * Spring 에서 프록시 패턴을 활용해서 Aop 를 구현 할 수 있다.
 */
public class MainTest {

	public static void main(String[] args) {
		
//		Browser browser = new Browser("www.naver.com");
//		browser.show();
//		browser.show();
//		browser.show();
//		browser.show();
		
//		BrowserProxy browserProxy = new BrowserProxy("www.naver.com");
//		browserProxy.show();
//		browserProxy.show();
//		browserProxy.show();
//		browserProxy.show();
//		browserProxy.show();
		
		
		// 동시성 문제 때문에 
		AtomicLong start = new AtomicLong();
		AtomicLong end = new AtomicLong();
		
		// 객체 생성 및 초기화
		IBrowser aopBrowser = new AopBrowser("www.naver.com", 
				() -> {
					System.out.println("before");
					start.set(System.currentTimeMillis());
				} , 
				() -> {
					System.out.println("after");
					long now = System.currentTimeMillis();
					end.set(now - start.get()); // 총 소요시간을 측정할 수 있다.
				}
		);
		
		aopBrowser.show();
		System.out.println("loading time: " + end.get()); // 첫번쨰 호출 소요시간 : 1507
		aopBrowser.show(); // 두번쨰 호출
		System.out.println("loading time: " + end.get());
		aopBrowser.show(); // 세번째 호출
		System.out.println("loading time: " + end.get());
		
		/*
		 *  Aop 란 관점 지향
		 *  AOP는 Aspect Oriented Programming의 약자로 관점 지향 프로그래밍이라고 불립니다. 
		 *  그리고 흩어진 Aspect를 모듈화할 수 있는 프로그래밍 기법입니다.
		 *  
		 *  
		 *  실제적으로 Aop를 활용하는 사례는 특정한 메서드가 있으면 그 메서드에
		 *  실행 시간을 확인, 일괄적인 request 정보, respose 정보를 확인해서 남긴다고 할때
		 *  코드에다가 개별적으로 작성하는 것이 아니라 일괄적으로 특정 클래스, 패키지에 있는
		 *  모든 메서드에 전부 전, 후에 기능을 넣을 수 있는 방법을 제공한다. 
		 */
	}

}
