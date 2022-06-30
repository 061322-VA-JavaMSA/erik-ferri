package com.revature.views;

import java.util.Scanner;

import com.revature.daos.CustomerPostgres;
import com.revature.daos.EmployeePostgres;
import com.revature.models.Customer;
import com.revature.models.Employee;

public class SignUpView {

	static String userInput;

	public static void signUp() {
		Customer customerTBC = new Customer();
		CustomerPostgres cp = new CustomerPostgres();
		CustomerView cv = new CustomerView();
		Scanner scan = new Scanner(System.in);

		System.out.println("==================================");
		System.out.println("Are you a customer or an employee?");
		System.out.println("1: Customer");
		System.out.println("2: Employee");
		userInput = scan.nextLine();

		if (userInput.equals("1")) {
			System.out.println("What is your username?");
			userInput = scan.nextLine();
			customerTBC.setUsername(userInput);
			
			System.out.println("What is your password?");
			userInput = scan.nextLine();
			customerTBC.setPassword(userInput);
			cp.createCustomer(customerTBC);
			cv.customerEntry(customerTBC);	
		} else if (userInput.equals("2")) {
			employeeSignUp();
		} else {
			System.out.println("Invalid entry. Please try again.");
//			Recursive
			signUp();
		}
	}

	public static void employeeSignUp() {
		Scanner scan = new Scanner(System.in);
		Employee employeeTBC = new Employee();
		EmployeePostgres ep = new EmployeePostgres();
		EmployeeView ev = new EmployeeView();
		FrontDoorView fdv = new FrontDoorView();
		
		System.out.println("===================================");
		System.out.println("ENTER THE SECRET EMPLOYEE PASSWORD:");
		userInput = scan.nextLine();
		if(userInput.equals("R0CKON!123")) {
			System.out.println("======================");
			System.out.println("What is your username?");
			userInput = scan.nextLine();
			employeeTBC.setUsername(userInput);
			
			System.out.println("What is your password?");
			userInput = scan.nextLine();
			employeeTBC.setPassword(userInput);
			ep.createEmployee(employeeTBC);
			ev.employeeEntry(employeeTBC);
			
		} else {
			System.out.println("==================================================================");
			System.out.println("Wrong password. Try again, or input 1 to go back to the main menu.");
			userInput = scan.nextLine();
			if (userInput.equals("1")) {
				fdv.welcome();
			}
		}
	}
}
