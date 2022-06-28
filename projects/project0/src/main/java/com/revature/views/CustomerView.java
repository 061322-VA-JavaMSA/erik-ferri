package com.revature.views;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Customer;
import com.revature.models.ShopItem;
import com.revature.services.CustomerService;
import com.revature.services.ShopItemService;
import com.revature.daos.ShopItemDAO;
import com.revature.daos.ShopItemPostgres;

public class CustomerView {
	
	static String userInput;
	CustomerService cs = new CustomerService();
	ShopItem si = new ShopItem();
	ShopItemService sis = new ShopItemService();
	ShopItemDAO sid = new ShopItemPostgres();

	public void customerEntry(Customer cu) {
		
		Scanner scan = new Scanner(System.in);
//		ShopItem si = new ShopItem();
		
		System.out.println("Welcome, " + cu.getUsername() + "!");
		displayItemList();
		System.out.println("Which item would you like to make an offer on");
		userInput = scan.nextLine();
		
//		idTBR = id to be retrieved
		int idTBR = Integer.parseInt(userInput);
		si = sid.retrieveShopItemById(idTBR);
		
		float standingOffer = si.getHighestOffer();		
		System.out.println("Standing Offer: " + standingOffer);
		
		System.out.println("Make an offer");
		userInput = scan.nextLine();
		float offer = Float.parseFloat(userInput);

		boolean offerWentThrough = cs.makeOffer(offer, si, cu.getId());
		if(offerWentThrough == true) {
			System.out.println("We have received your offer!");
		} else {
			System.out.println("Sorry, a higher offer has already been made on that item.");
		}
		
		
		
	}
	
	public void displayItemList() {
		List<ShopItem> shopItems = sis.getShopItems();
		for(int i = 0; i < shopItems.size(); i++) {
			System.out.println(sis.getShopItems().get(i).getItemName());
		}
	}
}
