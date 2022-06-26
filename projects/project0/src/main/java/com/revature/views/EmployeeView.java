package com.revature.views;

import java.util.List;
import java.util.Scanner;

import com.revature.models.ShopItem;
import com.revature.services.EmployeeService;
import com.revature.services.ShopItemService;
import com.revature.daos.ShopItemPostgres;

public class EmployeeView {
	
	static String userInput;
	EmployeeService cs = new EmployeeService();
	ShopItemService sis = new ShopItemService();
	ShopItemPostgres sip = new ShopItemPostgres();

	public void employeeEntry(String username, String password) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to the employee portal, " + username + "!");
		System.out.println("Please select an option:");
		System.out.println("1: View items in shop");
		System.out.println("2: Add item to shop");
		userInput = scan.nextLine();
		
		if(userInput.equals("1")) {
			displayItemList();
		} else {
			System.out.println("Enter the name of the item you wish to add:");
			userInput = scan.nextLine();
			ShopItem itemTBC = new ShopItem();
			itemTBC.setName(userInput);
			sip.createShopItem(itemTBC);
			scan.close();
		}
	}
	
	public void displayItemList() {
		List<ShopItem> shopItems = sis.getShopItems();
		for(int i = 0; i < shopItems.size(); i++) {
			System.out.println(sis.getShopItems().get(i).getName());
		}
	}
}
