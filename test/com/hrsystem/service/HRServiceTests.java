package com.hrsystem.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.hrsystem.domain.*;


public class HRServiceTests {
	
	private HRService hrService;
	
	@BeforeEach
	public void setup() {
		hrService=new HRService();
	}
	
	
	@Test
	public void testAddEmployee() {
		Employee employee=EmployeeFixture.createEmployee();
		employee.setPhone(PhoneFixture.createPhone());
		employee.setRoles(RoleFixture.createRoles());
		hrService.addEmployee(employee);
		Employee searchedEmployee =hrService.search(1);
		assertEquals(searchedEmployee.getFirstName(),employee.getFirstName());
	}
}
