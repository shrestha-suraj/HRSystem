package com.hrsystem.domain;

import java.util.List;

public class Employee {
	
	// Class variables
	private int id;
	private String firstName;
	private String lastName;
	
	// Other added variables
	private Phone phone;
	private Address address;
	private List<Role> roles;
	// Constructors
	
	
	
	// Getters and setters
	
	// Address getter and setters
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}	
	// Phone getters and setters
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	
}
