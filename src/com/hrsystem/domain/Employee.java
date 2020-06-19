package com.hrsystem.domain;

import java.util.List;

public class Employee {
	
	// Class variables (Immutable variable getters only)
	private int id;
	private String firstName;
	private String lastName;
	
	// Other added variables (These variables are mutable)
	private Phone phone;
	private Address address;
	private List<Role> roles;
	
	// Constructor
	public Employee(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
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
	
	// Roles getters and setters
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	// Immutable variable getters ONLY
	
	// Id getter
	public int getId() {
		return id;
	}

	// First name getter
	public String getFirstName() {
		return firstName;
	}

	// Last name getter
	public String getLastName() {
		return lastName;
	}

	
}
