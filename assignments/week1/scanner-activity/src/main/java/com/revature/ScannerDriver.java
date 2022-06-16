package com.revature;

import java.util.Scanner;

public class ScannerDriver {
	
	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome! Please enter a number between 1 and 3.");
		System.out.println("1: Get a random number between 1 and 100");
		System.out.println("2: Reverse a String");
		System.out.println("3: Exit application");
		String userInput = scan.nextLine();
		String reversedString = "";
		
		while(!userInput.equals("3")) {
			if(userInput.equals("1")) {
//				Prints random number between 1 and 100, parses to integer
				System.out.println("Random number: " + (int)Math.floor(Math.random()*100 + 1));
				System.out.println("-------------");
				System.out.println("1: Get a random number between 1 and 100");
				System.out.println("2: Reverse a String");
				System.out.println("3: Exit application");
				userInput = scan.nextLine();
			} else if(userInput.equals("2")){
				System.out.println("Type the String you would like reversed:");
				userInput = scan.nextLine();
				for(int i = userInput.length() - 1; i >= 0; i--) {
					reversedString += userInput.charAt(i);
				}
				System.out.println(reversedString);
				reversedString = "";
				System.out.println("-------------");
				System.out.println("1: Get a random number between 1 and 100");
				System.out.println("2: Reverse a String");
				System.out.println("3: Exit application");
				userInput = scan.nextLine();
			} else {
				System.out.println("Invalid entry. Try again.");
				System.out.println("-------------");
				System.out.println("1: Get a random number between 1 and 100");
				System.out.println("2: Reverse a String");
				System.out.println("3: Exit application");
				userInput = scan.nextLine();
			}
		}
		
		scan.close();
	}
	
}