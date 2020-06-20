package com.hrsystem.service;

import com.hrsystem.domain.Phone;

public class PhoneFixture {
	
	public static Phone createPhone() {
		Phone phone=new Phone("214","6628012989","+1");
		return phone;
	}
}
