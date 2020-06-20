package com.hrsystem.service;

import org.joda.time.DateTime;

import com.hrsystem.domain.Contractor;

public class ContractorFixture {
	
	public static Contractor createContractor() {
		Contractor c=new Contractor(new DateTime(2019,02,22,0,0),new DateTime(2021,02,21,0,0),20.5f,EmployeeFixture.createEmployee());
		c.setAddress(AddressFixture.createAddress());
		c.setPhone(PhoneFixture.createPhone());
		c.setRoles(RoleFixture.createRoles());
		return c;
	}

}
