package model.copy2;

import adapter.IElectronic220v;

public class Airconditionner implements IElectronic220v{
	// 이 친구는 220v 용이다.
	
	@Override
	public void connect() {
		System.out.println("에어컨 연결 220v On");
		
	}
	
}
