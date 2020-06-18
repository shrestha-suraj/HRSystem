package com.hrsystem.domain;

import org.joda.time.DateTime;

public class FullTime {
	
	private DateTime start;
	private float baseSalaryPerYear;
	private float bonusPerYear;
	
	public FullTime(DateTime start, float baseSalaryPerYear, float bonusPerYear) {
		this.start = start;
		this.baseSalaryPerYear = baseSalaryPerYear;
		this.bonusPerYear = bonusPerYear;
	}
	public DateTime getStart() {
		return start;
	}
	public float getBaseSalaryPerYear() {
		return baseSalaryPerYear;
	}
	public float getBonusPerYear() {
		return bonusPerYear;
	}

}
