package com.hrsystem.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.hrsystem.domain.*;


public class HRServiceTests {
	
	private HRService hrService;
	
	@BeforeEach
	public void setup() throws Exception {
		hrService=new HRService();
		hrService.addCompany(new Company(123,"Test Company",null));
	}
	
	
	@Test
	public void testAddEmployee() throws Exception {
		Employee employee=ContractorFixture.createContractor();
		hrService.addEmployee(123,employee);
		Employee searchedEmployee =hrService.searchEmployee(123, 1);
		assertEquals(searchedEmployee.getFirstName(),employee.getFirstName());
	}
	@Test
	public void testRemoveEmployee() throws Exception{
		Employee employee=FullTimeFixture.createFullTime();
		hrService.addEmployee(123,employee);
		hrService.removeEmployee(123, 1);
		Employee searchedEmployee =hrService.searchEmployee(123, 1);
		assertEquals(searchedEmployee,null);
	}
	@Test
	public void testSearchEmployeeByName() throws Exception {
		Employee employee=ContractorFixture.createContractor();
		hrService.addEmployee(123,employee);
		List<Employee> searchedEmployee =hrService.searchEmployees(123, "Suraj", "Shrestha");
		assertEquals(searchedEmployee.get(0).getFirstName(),employee.getFirstName());
	}
	
	@Test
	public void testSearchEmployeeyId() throws Exception{
		Employee employee=FullTimeFixture.createFullTime();
		hrService.addEmployee(123,employee);
		Employee searchedEmployee =hrService.searchEmployee(123, 1);
		assertEquals(searchedEmployee.getFirstName(),employee.getFirstName());
	}
	
	@Test
	public void testCompanyNotFoundException() {
		Exception exception = assertThrows(Exception.class,()->{
			hrService.addCompany(new Company(123,"Test Company",null));
		});
		String expectedMessage="Company Id is taken. Try Again!\n";
		String actualMessage=exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
}
