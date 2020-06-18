package com.hrsystem.service;

import com.hrsystem.domain.Phone;

public class PhoneFixture {
	
	public static Phone createPhone() {
		Phone phone=new Phone(1,"214","6628012989","1");
		return phone;
	}
}
