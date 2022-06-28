package com.revature.views;

import java.util.List;
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
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to the employee portal, " + username + "!");
		System.out.println("Please select an option:");
		System.out.println("1: Accept/Reject Offer");
		System.out.println("2: Add item to shop");
		userInput = scan.nextLine();
		
		if(userInput.equals("1")) {
			System.out.println("Enter the number of the item you'd like accept/reject");
			displayItemList();
			userInput = scan.nextLine();
			System.out.println("Would you like to accept or reject this offer?");
			System.out.println("1: Accept");
			System.out.println("2: Reject");
			
//			itemTBO = item to be owned
			int itemTBO = Integer.parseInt(userInput);
			userInput = scan.nextLine();
			
			if(userInput.equals("1")) {
				sid.acceptShopItemOffer(itemTBO);
			}
			
		} else {
			System.out.println("Enter the name of the item you wish to add:");
			userInput = scan.nextLine();
			ShopItem itemTBC = new ShopItem();
			itemTBC.setItemName(userInput);
			sid.createShopItem(itemTBC);
			scan.close();
		}
	}
	
	public void displayItemList() {
		List<ShopItem> shopItems = sis.getShopItems();
		for(int i = 0; i < shopItems.size(); i++) {
			float highestOffer = sis.getShopItems().get(i).getHighestOffer();
			if(!sis.getShopItems().get(i).getOwned().equals("yes")) {
				System.out.println((i + 1) + ": " + sis.getShopItems().get(i).getItemName() + " - " + highestOffer);
			}
		}
	}
}
