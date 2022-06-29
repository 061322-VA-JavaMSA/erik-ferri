package com.revature.views;

import java.util.Scanner;

import com.revature.models.ShopItem;
import com.revature.services.EmployeeService;
import com.revature.services.ShopItemService;
import com.revature.daos.ShopItemDAO;
import com.revature.daos.ShopItemPostgres;

public class EmployeeView {
	
	static String userInput;
	EmployeeService cs = new EmployeeService();
	ShopItemService sis = new ShopItemService();
	ShopItemDAO sid = new ShopItemPostgres();

	public void employeeEntry(String username, String password) {
		
		System.out.println("Welcome to the employee portal, " + username + "!");
		employeePortal();
	}
	
	public void employeePortal() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please select an option:");
		System.out.println("1: Accept/Reject Offer");
		System.out.println("2: Add item to shop");
		System.out.println("3: Remove item from shop");
		userInput = scan.nextLine();
		
		if(userInput.equals("1")) {
			System.out.println("Enter the number of the item whose offer you'd like accept/reject:");
			sis.displayItemListWithOffers();
			userInput = scan.nextLine();
			System.out.println("Would you like to accept or reject this offer?");
			System.out.println("1: Accept");
			System.out.println("2: Reject");
			
			int itemId = Integer.parseInt(userInput);
			userInput = scan.nextLine();
			
			if(userInput.equals("1")) {
				ShopItem si = sid.retrieveShopItemById(itemId);
				sid.acceptShopItemOffer(si);
			} else if(userInput.equals("2")) {
				sid.rejectShopItemOffer(itemId);
			}
			
		} else if(userInput.equals("2")) {
			System.out.println("Enter the name of the item you wish to add:");
			userInput = scan.nextLine();
			ShopItem itemTBC = new ShopItem();
			itemTBC.setItemName(userInput);
			sid.createShopItem(itemTBC);
			scan.close();
			
		} else if(userInput.equals("3")) {
			System.out.println("Enter the id of the item you wish to remove:");
			userInput = scan.nextLine();
			int itemId = Integer.parseInt(userInput);
			sid.deleteShopItemById(itemId);
			scan.close();
		} else {
			System.out.println("Invalid entry. Try again.");
//			Recursive
			employeePortal();
			
		}
	}
}
