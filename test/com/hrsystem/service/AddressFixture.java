package com.hrsystem.service;

import com.hrsystem.domain.Address;

public class AddressFixture {
	
	public static Address createAddress() {
		return new Address("38655","USA","MS","Oxford","101 Test Address","Apt 1");
	}

}
