package com.hrsystem.domain;

import org.joda.time.DateTime;
/*
 * FullTime extends Employee and hence need to call the super class
 * Employee from its constructor with required employee data
 */
public class FullTime  extends Employee{
	
	// Required variables
	private DateTime start;
	
	// Base salary and the bonus per year are mutable as it can change over time.
	// Hence we have both getters and setters for these variables.
	private float baseSalaryPerYear;
	private float bonusPerYear;
	
	// Constructor
	public FullTime(DateTime start, float baseSalaryPerYear, float bonusPerYear, Employee employee) {
		// Calling super class method with requred datas
		// It is impossible to extend Employee without calling its constructor. (Constructor chaining)
		super(employee.getId(),employee.getFirstName(),employee.getLastName());
		this.start = start;
		this.baseSalaryPerYear = baseSalaryPerYear;
		this.bonusPerYear = bonusPerYear;
	}
	// Getter for start date
	public DateTime getStart() {
		return start;
	}
	//	Getter for base salary per year
	public float getBaseSalaryPerYear() {
		return baseSalaryPerYear;
	}
	// Setter for base salary per year
	public void setBaseSalaryPerYear(float baseSalaryPerYear) {
		this.baseSalaryPerYear=baseSalaryPerYear;
	}
	// Getter for bonusPerYear
	public float getBonusPerYear() {
		return bonusPerYear;
	}
	
	// Setter for bonusPerYear
	public void setBonusPerYear(float bonusPerYear) {
		this.bonusPerYear=bonusPerYear;
	}
	

}
