package com.hrsystem.service;

import com.hrsystem.domain.Employee;

public class EmployeeFixture {
	
	public static Employee createEmployee() {
		Employee employee=new Employee(1,"Suraj","Shrestha");
		return employee;
	}

}
