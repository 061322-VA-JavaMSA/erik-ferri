package com.revature;

import java.util.Scanner;

//import com.revature.exceptions.*;
import com.revature.models.*;
//import com.revature.services.*;
//import java.sql.Connection;

public class Driver {
	
//	static String userInput;
	
	public static void main(String[] args) {
		
//		displayInstrumentMenu();
//		handleInstrumentSelection();
//		printUser();
		
	}
	
//	public static void printUser() {
//		Scanner scan = new Scanner(System.in);
//		String username;
//		String password;
//		System.out.println("What is your username?");
//		userInput = scan.nextLine();
//		username = userInput;
//		System.out.println("What is your password?");
//		userInput = scan.nextLine();
//		password = userInput;
//		User newUser = new User(username, password);
//		System.out.println("Username: " + newUser.username);
//		System.out.println("Password: " + newUser.password);
//		scan.close();
//	}
//	
//	public static void displayInstrumentMenu() {
//		System.out.println("Welcome to the Music Store! Please enter the number associated with what you want to buy:");
//		System.out.println("1: Guitar");
//		System.out.println("2: Drums");
//		System.out.println("3: Microphone");
//		System.out.println("4: Exit Store");
//	}
//	
//	public static void handleInstrumentSelection() {
//		Scanner scan = new Scanner(System.in);
//		userInput = scan.nextLine();
//		if(userInput.equals("1")) {
//			System.out.println("You are interested in a guitar.");
//		} else if(userInput.equals("2")){
//			System.out.println("You are interested in drums.");
//		} else if(userInput.equals("3")){
//			System.out.println("You are interested in a microphone.");
//		} else if(userInput.equals("4")){
//			System.out.println("Exiting store... Goodbye!");
//			scan.close();
//		} else {
//			System.out.println("Invalid entry. Try again.");
//			displayInstrumentMenu();
//			handleInstrumentSelection(); //recursive function
//		}
//	}
}

//public class Driver {
//	
//	static Scanner scan;
//	static AuthService as;
//	static UserService us;
//	static TaskService ts;
//	
//	public static void main(String[] args) {
//		scan = new Scanner(System.in);
//		as = new AuthService();
//		us = new UserService();
//		ts = new TaskService();
//		
//		String username = null;
//		String password = null;
//		
//		System.out.println("Please enter username:");
//		username = scan.nextLine();
//		System.out.println("Please enter password:");
//		password = scan.nextLine();
//		
//		try {
//			System.out.println(as.login(username, password));
//		} catch (LoginException e) {
//			System.out.println("Invalid credentials.");
////			e.printStackTrace();
//		}
//
//		
//		List<User> users = us.getUsers();
//		for(User u : users) {
//			System.out.println(u);
//		}	
//		// "1; drop table users"
//		System.out.println("Create, username:");
//		String uname = scan.nextLine();
//		System.out.println("Create, password:");
//		String pass = scan.nextLine();
//		User userTBC = new User();
//		userTBC.setUsername(uname);
//		userTBC.setPassword(pass);
//		System.out.println(us.createUser(userTBC));
//		
//		System.out.println("Retrieve tasks for which user id?");
//		int userId = Integer.parseInt(scan.nextLine());
//		List<Task> tasksForUser = ts.getTasksByUserId(userId);
//		for(Task t : tasksForUser) {
//			System.out.println(t);
//		}
//		
//		scan.close();
//	}
//
//}