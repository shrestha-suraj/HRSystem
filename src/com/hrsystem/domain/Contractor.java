package com.hrsystem.domain;

import org.joda.time.DateTime;
/*
 * Contactor extends Employee and hence need to call the super class
 * Employee from its constructor with required employee data
 */

public class Contractor extends Employee{
	
	// Required variables
	private DateTime start;
	private DateTime end;
	private float hourlyRate;
	
	// Constructor
	public Contractor(DateTime start, DateTime end, float hourlyRate, Employee employee) {
		// Calling super class method with requred datas
		// It is impossible to extend Employee without calling its constructor. (Constructor chaining)
		super(employee.getId(),employee.getFirstName(),employee.getLastName());
		this.start = start;
		this.end = end;
		this.hourlyRate = hourlyRate;
	}
	
	// Contactor only has getters as once the contract is made it cannot be changed
	// Hence, the variables mentioned are immutable.
	
	// startTime getter
	public DateTime getStart() {
		return start;
	}
	
	// endTime getter
	public DateTime getEnd() {
		return end;
	}
	
	// hourlyRate getter
	public float getHourlyRate() {
		return hourlyRate;
	}

}
