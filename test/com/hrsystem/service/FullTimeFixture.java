package com.hrsystem.service;

import org.joda.time.DateTime;

import com.hrsystem.domain.FullTime;

public class FullTimeFixture {
	public static FullTime createFullTime() {
		FullTime f=new FullTime(new DateTime(2019,02,22,0,0),35000.0f,1500.00f,EmployeeFixture.createEmployee());
		f.setAddress(AddressFixture.createAddress());
		f.setPhone(PhoneFixture.createPhone());
		f.setRoles(RoleFixture.createRoles());
		return f;
	}
}
