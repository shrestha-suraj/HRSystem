package com.hrsystem.service;

// Domain driver design
// Uncle Bob
// cleancoders.com
import java.util.HashMap;
import java.util.Map;

import com.hrsystem.domain.*;

public class HRService {
	private Map<Integer,Company> db=new HashMap<Integer,Company>();

	public void addEmployee(Employee employee) {
		db.put(employee.getId(),employee);
	}
	public int removeEmployee(int employeeId) {
		Employee employee=search(employeeId);
		if(employee!=null) {
			db.remove(employeeId);
			return employeeId;
		}
		return -1;
		
	}
//	public List<Employee> search(String firstName, String lastName){
//		
//	}
	
	public Employee search(int employeeId) {
		return db.get(employeeId);
	}
		
}
