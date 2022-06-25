package com.revature.views;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.exceptions.LoginException;
//import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.UserService;
//import com.revature.daos.UserPostgres;

public class LoginView {

	static Scanner scan;
	static AuthService as;
	static UserService us;
	static CustomerView cv;
	private static Logger log = LogManager.getLogger(LoginView.class);

	public static void login() {
		scan = new Scanner(System.in);
//		userTTL = user trying to login
//		User userTTL = new User();
		as = new AuthService();
		us = new UserService();
		cv = new CustomerView();
		
		String username = null;
		String password = null;
		
		System.out.println("What is your username?");
		username = scan.nextLine();
//		userTTL.setUsername(username);
		
		System.out.println("What is your password?");
		password = scan.nextLine();
//		userTTL.setPassword(password);
		
		try {
			log.info(as.login(username, password));
		} catch (LoginException e) {
			System.out.println("Invalid credentials.");
			log.error("Login exception was thrown: " + e.fillInStackTrace());
//			e.printStackTrace();
		}
		
		cv.customerEntry(username,password);
	}
}
