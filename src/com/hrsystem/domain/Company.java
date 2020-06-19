package com.hrsystem.domain;

import java.util.HashMap;
import java.util.Map;

public class Company {
	// Required variables in Company
	private int companyId;
	private String companyName;
	
	// HashMap is used cause every employee has unique id
	private Map<Integer,Employee> employees;
	
	// Constructor for new company. Called once for each company
	public Company(int companyId, String companyName, Map<Integer,Employee> employees) {
			this.companyId=companyId;
			this.companyName=companyName;
			this.employees=employees==null?new HashMap<Integer,Employee>():employees;
	}
	// getter for company id
	public int getId() {
		return companyId;
	}
	
	//getter for company name
	public String getName() {
		return companyName;
	}
	// getter for list of employees in the company
	public Map<Integer,Employee> getEmployees() {
		return employees;
	}
	
	// method to add an employee to the company
	public void addEmployee(Employee employee) {
		employees.put(employee.getId(), employee);
	}
	
	//method to remove an employee from the company
	public void removeEmployee(int employeeId) {
		employees.remove(employeeId);
	}
	

}