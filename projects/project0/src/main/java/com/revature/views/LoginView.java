package com.revature.views;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.exceptions.LoginException;
import com.revature.services.AuthService;
import com.revature.services.UserService;
import com.revature.models.Customer;

public class LoginView {

	static Scanner scan;
	static AuthService as;
	static UserService us;
	static CustomerView cv;
	static EmployeeView ev;
	private static Logger log = LogManager.getLogger(LoginView.class);

	public static void login() {
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		cv = new CustomerView();
		ev = new EmployeeView();
		Customer cu = new Customer();
		
		String username = null;
		String password = null;
		
		System.out.println("What is your username?");
		username = scan.nextLine();
		
		System.out.println("What is your password?");
		password = scan.nextLine();
		
		try {
			log.info(as.login(username, password));
//			if the class of the login is Customer...
			if(as.login(username, password).getClass() == cu.getClass()) {
//				...take them to the customer view
				cv.customerEntry(username,password);
			} else {
//				Otherwise, take them to the employee view
				ev.employeeEntry(username,password);
			}
		} catch (LoginException e) {
			System.out.println("Invalid credentials. Try again.");
			log.error("Login exception was thrown: " + e.fillInStackTrace());
//			Recursive function
			login();
//			e.printStackTrace();
		}
		
	}
}
