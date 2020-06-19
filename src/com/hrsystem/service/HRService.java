package com.hrsystem.service;

import java.util.ArrayList;
// Domain driver design
// Uncle Bob
// cleancoders.com
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hrsystem.domain.*;

public class HRService {
	// Mappping of company id with company object
	private Map<Integer,Company> db=new HashMap<Integer,Company>();

	// Adding employee to specific company
	public void addEmployee(int companyId, Employee employee) throws Exception{
		Company company=db.get(companyId);
		if(company.getEmployees().get(employee.getId())==null) {
			company.addEmployee(employee);
		}else {
			throw new Exception("Id duplication occured.");
		}
	}
	
	//Removing employee from the company on basis of employeeId
	public void removeEmployee(int companyId, int employeeId) throws Exception {
		Company company=db.get(companyId);
		if(company.getEmployees().get(employeeId)!=null) {
			company.removeEmployee(employeeId);
		}else {
			throw new Exception("Employee doesnot exist in Company.");
		}
	}
	
	// Searching employees based on their names.. 
	// will return List of Employess as multiple employees can have same name
	public List<Employee> searchEmployees(int companyId, String firstName,String lastName){
		Map<Integer,Employee> allEmployees=db.get(companyId).getEmployees();
		List<Employee> searchedEmployees=new ArrayList<Employee>();
		for(Employee employee : allEmployees.values()) {
			if(employee.getFirstName().equalsIgnoreCase(firstName)) {
				if(employee.getLastName().equalsIgnoreCase(lastName)) {
					searchedEmployees.add(employee);
				}
			}
		}
		return searchedEmployees;
	}
	
	
	// Searching employee based on their id
	// Since, ids are unique we will have only one employee object sent
	public Employee searchEmployee(int companyId,int employeeId) {
		return db.get(companyId).getEmployees().get(employeeId);
		// this will return null if employee with that id doesnot exist
	}
	
	
	// Adding new company to the HRSystem
	public void addCompany(Company company) throws Exception {
		if(db.get(company.getId())!=null) {
			db.put(company.getId(), company);
		}else {
			throw new Exception("Company Id is taken. Try Again!\n");
		}
	}
	
	
	
	
	
	
		
}
