package com.revature;

import java.util.List;
import java.util.Scanner;

//import com.revature.exceptions.*;
import com.revature.models.*;
//import com.revature.services.*;
//import java.sql.Connection;
import com.revature.daos.*;

public class Driver {
	
//	static String userInput;
	
	public static void main(String[] args) {
		
//		displayInstrumentMenu();
//		handleInstrumentSelection();
//		printUser();
		UserPostgres up = new UserPostgres();
		User userTBC = new User();
		userTBC.setUsername("Test Username");
		userTBC.setPassword("Test Password");
		up.createUser(userTBC);
		
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
