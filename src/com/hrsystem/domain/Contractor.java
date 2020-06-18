package com.hrsystem.domain;

import org.joda.time.DateTime;

public class Contractor extends Employee{
	private DateTime start;
	private DateTime end;
	private float hourlyRate;
	
	
	public Contractor(DateTime start, DateTime end, float hourlyRate) {
		super()
		this.start = start;
		this.end = end;
		this.hourlyRate = hourlyRate;
	}
	public DateTime getStart() {
		return start;
	}
	public DateTime getEnd() {
		return end;
	}
	public float getHourlyRate() {
		return hourlyRate;
	}

}
