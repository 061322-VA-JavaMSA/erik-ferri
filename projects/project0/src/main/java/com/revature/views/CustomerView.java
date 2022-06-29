package com.revature.views;

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
	Scanner scan = new Scanner(System.in);

	public void customerEntry(Customer cu) {
		
		System.out.println("Welcome, " + cu.getUsername() + "!");
		customerPortal(cu);
	}
	
	public void customerPortal(Customer cu) {
		
		System.out.println("Please select an option:");
		System.out.println("1: View items in shop");
		System.out.println("2: Make an offer for an item");
		System.out.println("3: View your items");
		userInput = scan.nextLine();
		
		if(userInput.equals("1")) {
			sis.displayItemList();
		} else if(userInput.equals("2")) {
			offerView(cu);
		} else if(userInput.equals("3")) {
			cs.displayCustomerItems(cu);
		}
	}

	public void offerView(Customer cu) {
		sis.displayItemListWithOffers();
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
		
		System.out.println("Would you like to make another offer?");
		System.out.println("1: Yes");
		System.out.println("2: No");
		userInput = scan.nextLine();
		
		if(userInput.equals("1")) {
//			Recursive
			offerView(cu);
		} else if(userInput.equals("2")) {
			scan.close();
		}
	}
}
