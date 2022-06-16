package adapter;

import model.Airconditionner;
import model.Cleaner;
import model.HairDryer;

public class MyHouse {
	
	// 집에 콘센트에 연결하는 동작
	public static void homeConnect(IElectronic220v electronic220v) {
		electronic220v.connect();
	}
	
	
	
	public static void main(String[] args) {
		/*
		 *  1. 에어컨
		 *  2. 헤어드라이기
		 *  3. 청소기
		 *  
		 *  - 가전기기의 추상화를 해주세요 
		 *  = 인터페이스를 만들어 주세요 = 동작을 만들어 낸다.
		 *  = 공통적인 동작을 추상화 한다. > connect(); "사용하려면 전기를 연결하는 동작을 구현해야한다."
		 *  
		 *  문제인식
		 *  - 일본에서 친구가 제품을 사줬는데 110v짜리이다. but 우리는 220v이다
		 *  
		 */
		
		// 사용
		Airconditionner airconditionner = new Airconditionner();
		HairDryer dryer = new HairDryer();
		Cleaner cleaner = new Cleaner();
		// 집에 에어컨디셔너에 연결
		homeConnect(airconditionner);	
		homeConnect(new ElectronicAdapter(dryer));
		homeConnect(new ElectronicAdapter(cleaner));
		
		//homeConnect(cleaner);
	}

}
