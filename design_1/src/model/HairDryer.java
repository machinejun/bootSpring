package model;

import adapter.IElectronic110v;

public class HairDryer implements IElectronic110v{
	// 이 친구는 일제라서 110v이다.
	
	@Override
	public void connect() {
		System.out.println("헤어드라이기 110v On");
	}

}
