package com.revature.views;

import java.util.Scanner;

public class FrontDoorView {

	static String userInput;

	public static void welcome() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to the Music Store! Please select an option below:");
		System.out.println("1: Login");
		System.out.println("2: Sign Up");
		System.out.println("3: Exit Store");
		
		userInput = scan.nextLine();
		if(userInput.equals("2")) {
			SignUpView.signUp();
		}
		
		scan.close();
	}
}
