package com.revature.views;

import java.util.Scanner;

import com.revature.daos.UserPostgres;
import com.revature.models.User;

public class LoginView {

	static String userInput;

	public static void login() {
		Scanner scan = new Scanner(System.in);
		User userTBC = new User();
		UserPostgres up = new UserPostgres();
		
		System.out.println("What is your username?");
		userInput = scan.nextLine();
		userTBC.setUsername(userInput);
		
		System.out.println("What is your password?");
		userInput = scan.nextLine();
		userTBC.setPassword(userInput);
		scan.close();
	}
}
