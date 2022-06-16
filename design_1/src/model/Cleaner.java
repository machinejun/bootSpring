package model;

import adapter.IElectronic110v;

public class Cleaner implements IElectronic110v{

	@Override
	public void connect() {
		System.out.println("청소기 연결 110v On");
		
	}

}
