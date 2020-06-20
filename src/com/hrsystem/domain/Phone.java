package com.hrsystem.domain;

public class Phone {
	private String areaCode;
	private String number;
	private String countryCode;
	public Phone(String areaCode, String number, String countryCode) {
		this.areaCode = areaCode;
		this.number = number;
		this.countryCode = countryCode;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public String getNumber() {
		return number;
	}
	public String getCountryCode() {
		return countryCode;
	}
	
	

}
