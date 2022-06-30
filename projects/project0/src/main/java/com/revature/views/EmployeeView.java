package com.revature.views;

import java.util.Scanner;

import com.revature.models.ShopItem;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import com.revature.services.ShopItemService;
import com.revature.daos.ShopItemDAO;
import com.revature.daos.ShopItemPostgres;

public class EmployeeView {
	
	static String userInput;
	EmployeeService cs = new EmployeeService();
	ShopItemService sis = new ShopItemService();
	ShopItemDAO sid = new ShopItemPostgres();

	public void employeeEntry(Employee em) {
		
		System.out.println("=======================================");
		System.out.println("Welcome to the employee portal, " + em.getUsername() + "!");
		employeePortal();
	}
	
	public void employeePortal() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("");
		System.out.println("Please select an option:");
		System.out.println("1: Accept/Reject Offer");
		System.out.println("2: Add item to shop");
		System.out.println("3: Remove item from shop");
		System.out.println("4: Log out");
		userInput = scan.nextLine();
		
		if(userInput.equals("1")) {
			sis.displayItemListWithOffers();
			System.out.println("");
			System.out.println("Enter the number of the item whose offer you'd like accept/reject:");
			userInput = scan.nextLine();
			System.out.println("==============================================");
			System.out.println("Would you like to accept or reject this offer?");
			System.out.println("1: Accept");
			System.out.println("2: Reject");
			
			int itemId = Integer.parseInt(userInput);
			userInput = scan.nextLine();
			
			if(userInput.equals("1")) {
				ShopItem si = sid.retrieveShopItemById(itemId);
				sid.acceptShopItemOffer(si);
				System.out.println("Offer accepted!");
				System.out.println("========================");
//				Recursive
				employeePortal();
			} else if(userInput.equals("2")) {
				sid.rejectShopItemOffer(itemId);
				System.out.println("REJECTED!");
				System.out.println("========================");
//				Recursive
				employeePortal();
			}
			
		} else if(userInput.equals("2")) {
			System.out.println("===========================================");
			System.out.println("Enter the name of the item you wish to add:");
			userInput = scan.nextLine();
			ShopItem itemTBC = new ShopItem();
			itemTBC.setItemName(userInput);
			sid.createShopItem(itemTBC);
			System.out.println(itemTBC.getItemName() + " added!");
			System.out.println("========================");
//			Recursive
			employeePortal();
			
		} else if(userInput.equals("3")) {
			sis.displayItemList();
			System.out.println("============================================");
			System.out.println("Enter the id of the item you wish to remove:");
			userInput = scan.nextLine();
			int itemId = Integer.parseInt(userInput);
			String itemName = sid.retrieveShopItemById(itemId).getItemName();
			sid.deleteShopItemById(itemId);
			System.out.println(itemName + " removed!");
			System.out.println("========================");
//			Recursive
			employeePortal();
			scan.close();
		} else if (userInput.equals("4")) {
			FrontDoorView fdv = new FrontDoorView();
			fdv.welcome();
		} else {
			System.out.println("Invalid entry. Try again.");
//			Recursive
			employeePortal();
		}
	}
}
