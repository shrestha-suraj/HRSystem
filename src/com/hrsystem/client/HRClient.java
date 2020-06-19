package com.hrsystem.client;

import java.util.Map;
import java.util.Scanner;
import org.joda.time.DateTime;
import com.hrsystem.domain.*;
import com.hrsystem.service.HRService;

public class HRClient {
	
	// Object of HRService to be used accross multiple methods
	static HRService hr=new HRService();

	public static void main(String[] args) {
		Scanner keyboard=new Scanner(System.in);
		System.out.println("Hello! Welcome to HR Database!");
		System.out.print("Are you affiliated with us?\n1) New Company2) Existing Company\n Please type one of the option number: ");
		int choice=keyboard.nextInt();
		if(choice==1) {
			System.out.println("Welcome, we need to create company profile in the database.");
			System.out.print("Enter company id: ");
			int companyId=keyboard.nextInt();
			System.out.print("Enter company name: ");
			String companyName=keyboard.nextLine();
			try {
				hr.addCompany(new Company(companyId,companyName,null));
			}catch(Exception e) {
				System.out.println("Error occured: "+e.getMessage());
			}
		}
		else if(choice==2) {
			System.out.println("What do you want to do?");
			System.out.println("1) Add an Employee\n2) Delete an Employee\n3) Search Employees based on name\n4) Search employee by employeeId");
			System.out.println("Please type one of the option numbers: ");
			switch(keyboard.nextInt()){
				case 1:
			}
		}	
	}
}
