package com.revature.views;

import java.util.List;

import com.revature.models.ShopItem;
//import com.revature.services.CustomerService;
import com.revature.services.ShopItemService;

public class EmployeeView {
	
//	CustomerService cs = new EmployeeService();
	ShopItemService sis = new ShopItemService();

	public void employeeEntry(String username, String password) {
		System.out.println("Welcome to the employee portal, " + username + "!");
		displayItemList();
	}
	
	public void displayItemList() {
		List<ShopItem> shopItems = sis.getShopItems();
		for(int i = 0; i < shopItems.size(); i++) {
			System.out.println(sis.getShopItems().get(i).getName());
		}
	}
}
