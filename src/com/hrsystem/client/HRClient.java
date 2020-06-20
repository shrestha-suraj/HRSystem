package com.hrsystem.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.joda.time.DateTime;

import com.hrsystem.domain.*;
import com.hrsystem.service.HRService;

public class HRClient {

	// Object of HRService to be used accross multiple methods
	static HRService hr = new HRService();

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("<-------------------Hello! Welcome to HR Database!--------------------->");
		boolean runProgram = true;
		do {
			System.out.print(
					"Are you affiliated with us?\n1) New Company\n2) Existing Company\n3) Quit Pograma\nPlease type one of the option number: ");
			int choice = keyboard.nextInt();
			if (choice == 1) {
				System.out.println("Alright, we need to create company profile in the database.");
				System.out.print("Enter company id: ");
				int companyId = keyboard.nextInt();
				keyboard.nextLine();
				System.out.print("Enter company name: ");
				String companyName = keyboard.nextLine();
				try {
					hr.addCompany(new Company(companyId, companyName, null));
					System.out.println("Company Successfully Added.");
				} catch (Exception e) {
					System.out.println("Error occured: " + e.getMessage());
				}
				System.out.println("<--------------------------------------->");
			} else if (choice == 2) {
				boolean repeat = true;
				do {
					System.out.println("---------------------------------------");
					System.out.println("Welocome back!");
					System.out.println("What do you want to do?");
					System.out.println(
							"1) Add an Employee\n2) Delete an Employee\n3) Search Employees based on name\n4) Search employee by employeeId\n5) Quit");
					System.out.println("Please type one of the option numbers: ");
					int option = keyboard.nextInt();
					if (option == 5) {
						System.out.println("Good Bye");
						break;
					}
					System.out.println("Enter all necessary informations.");
					System.out.print("Enter the company id: ");
					int companyId = keyboard.nextInt();
					keyboard.nextLine();
					if (!hr.companyExists(companyId)) {
						System.out.println("Error occured. Company ID doesnot exist.");
						continue;
					}
					switch (option) {
					case 1:
						System.out.print("Type of employee:\n1) Contarctor\n2) Full-Time\nType one choice: ");
						int typeChoice = keyboard.nextInt();
						keyboard.nextLine();
						System.out.print("Enter employee id: ");
						int empId = keyboard.nextInt();
						keyboard.nextLine();
						System.out.print("Enter employee full name: ");
						String[] empName = keyboard.nextLine().split(" ");
						System.out.print("How many roles you want to register for the employee?\nEnter a number: ");
						int rolesNumber=keyboard.nextInt();
						keyboard.nextLine();
						List<Role> roles = new ArrayList<Role>();
						for (int i = 0; i < rolesNumber; i++) {
							System.out.print("Enter Role-" + (i + 1) + " information, Format: RoleId,RoleName :  ");
							String[] token = keyboard.nextLine().split(",");
							roles.add(new Role(Integer.parseInt(token[0]), token[1]));
						}
						System.out.print("Enter phone number, Format: AreaCode,PhoneNumber,CountryCode :  ");
						String[] phoneToken = keyboard.nextLine().split(",");
						Phone empPhone = new Phone(phoneToken[0], phoneToken[1], phoneToken[2]);
						System.out.print(
								"Enter address, Format: ZipCode,Country,State,City,StreetAddress,AddressLine2 :  ");
						String[] addressToken = keyboard.nextLine().split(",");
						Address empAddress = new Address(addressToken[0], addressToken[1], addressToken[2],
								addressToken[3], addressToken[4], addressToken[5]);
						// Creating a complete employee
						Employee employee = null;
						if (typeChoice == 1) {
							System.out.println(
									"Enter contractor information i.e. StartDate EndDate and HourlySalary, Format: YYYY/MM/DD YYYY/MM/DD SalaryPerHr");
							String[] contractorToken = keyboard.nextLine().split(" ");
							String[] startDate=contractorToken[0].split("/");
							String[] endDate=contractorToken[1].split("/");
							employee = new Contractor(new DateTime(Integer.parseInt(startDate[0]),Integer.parseInt(startDate[1]),Integer.parseInt(startDate[2]),0,0),
									new DateTime(Integer.parseInt(endDate[0]),Integer.parseInt(endDate[1]),Integer.parseInt(endDate[2]),0,0), Float.parseFloat(contractorToken[2]),
									new Employee(empId, empName[0], empName[1]));
						} else {
							System.out.println(
									"Enter FullTime employee information i.e. StartDate SalaryPerYear and BonusPerYear, Format: YYYY/MM/DD YearlySalary YearlyBonus");
							String[] fulltimeToken = keyboard.nextLine().split(" ");
							String[] startDate=fulltimeToken[0].split("/");
							employee = new FullTime(new DateTime(Integer.parseInt(startDate[0]),Integer.parseInt(startDate[1]),Integer.parseInt(startDate[2]),0,0), Float.parseFloat(fulltimeToken[1]),
									Float.parseFloat(fulltimeToken[2]), new Employee(empId, empName[0], empName[1]));
						}
						employee.setRoles(roles);
						employee.setPhone(empPhone);
						employee.setAddress(empAddress);
						try {
							hr.addEmployee(companyId, employee);
							System.out.println("Employee Added Successfully");
						} catch (Exception e) {
							System.out.println("Error Occured: " + e.getMessage());
							continue;
						}
						break;
					case 2:
						System.out.print("Enter employeeId in given format: ");
						try {
							hr.removeEmployee(companyId, keyboard.nextInt());
							System.out.println("Employee removed successfully.");
						} catch (Exception e) {
							System.out.println("Error Occured: " + e.getMessage());
							continue;
						}
						break;
					case 3:
						System.out.print("Enter Employee FullName: ");
						String[] searchToken = keyboard.nextLine().split(" ");
						List<Employee> result = hr.searchEmployees(companyId, searchToken[0], searchToken[1]);
						if (result.size() != 0) {
							for (Employee each : result) {
								System.out.println("Id: " + each.getId() + ", Name: " + each.getFirstName() + " "
										+ each.getLastName());
							}
						} else {
							System.out.println("No record found!!");
						}
						break;
					case 4:
						System.out.println("Enter EmployeeID : ");
						Employee emp = hr.searchEmployee(companyId, keyboard.nextInt());
						if (emp != null) {
							System.out.println(
									"Id: " + emp.getId() + ", Name: " + emp.getFirstName() + " " + emp.getLastName());
						} else {
							System.out.println("No record found!!");
						}
						break;
					}

				} while (repeat);
			} else {
				runProgram = false;
			}

		} while (runProgram);
		System.out.println("Thank You for using the program");
	}
}
