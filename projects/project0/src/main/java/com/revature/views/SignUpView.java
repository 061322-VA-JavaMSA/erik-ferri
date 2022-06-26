package com.revature.views;

import java.util.Scanner;

import com.revature.daos.CustomerPostgres;
import com.revature.daos.EmployeePostgres;
import com.revature.models.Customer;
import com.revature.models.Employee;

public class SignUpView {

	static String userInput;

	public static void signUp() {
		Scanner scan = new Scanner(System.in);
		Customer customerTBC = new Customer();
		CustomerPostgres cp = new CustomerPostgres();
		Employee employeeTBC = new Employee();
		EmployeePostgres ep = new EmployeePostgres();

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
			scan.close();	
		} else if (userInput.equals("2")) {
			System.out.println("What is your username?");
			userInput = scan.nextLine();
			employeeTBC.setUsername(userInput);
			
			System.out.println("What is your password?");
			userInput = scan.nextLine();
			employeeTBC.setPassword(userInput);
			ep.createEmployee(employeeTBC);
			scan.close();	
		} else {
			System.out.println("Invalid entry. Please try again.");
//			Recursive
			signUp();
		}	
	}
}
