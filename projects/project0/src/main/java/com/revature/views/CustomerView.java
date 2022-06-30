package com.revature.views;

import java.util.Scanner;

import com.revature.models.Customer;
import com.revature.models.ShopItem;
import com.revature.services.CustomerService;
import com.revature.services.ShopItemService;
import com.revature.daos.ShopItemDAO;
import com.revature.daos.ShopItemPostgres;
import com.revature.exceptions.MakeNegativeOfferException;

public class CustomerView {
	
	static String userInput;
	CustomerService cs = new CustomerService();
	ShopItem si = new ShopItem();
	ShopItemService sis = new ShopItemService();
	ShopItemDAO sid = new ShopItemPostgres();
	Scanner scan = new Scanner(System.in);

	public void customerEntry(Customer cu) {
		
		System.out.println("============================");
		System.out.println("Welcome, " + cu.getUsername() + "!");
		System.out.println("");
		customerPortal(cu);
	}
	
	public void customerPortal(Customer cu) {
		
		System.out.println("Please select an option:");
		System.out.println("1: View items in shop");
		System.out.println("2: Make an offer for an item");
		System.out.println("3: View your items");
		System.out.println("4: Log out");
		userInput = scan.nextLine();
		
		if(userInput.equals("1")) {
			sis.displayItemList();
			System.out.println("");
			customerPortal(cu);
		} else if(userInput.equals("2")) {
			offerView(cu);
		} else if(userInput.equals("3")) {
			cs.displayCustomerItems(cu);
			
			System.out.println("");
			System.out.println("Which item would you like to view payments for?");
			userInput = scan.nextLine();
			
			 ShopItem si = sid.retrieveShopItemById(Integer.parseInt(userInput));
			 float weeklyPayment = (si.getAmtOwed() / 4);
			 System.out.println("====================================================");
			 System.out.println("You owe 4 weekly payments of $" + weeklyPayment + " for the " + si.getItemName());
			 System.out.println("====================================================");
			 System.out.println("");
			 customerPortal(cu);
		} else if(userInput.equals("4")) {
			FrontDoorView fdv = new FrontDoorView();
			fdv.welcome();
		} else {
			System.out.println("Invalid entry. Try again.");
//			Recursive
			customerPortal(cu);
		}
	}

	public void offerView(Customer cu) {
		sis.displayItemListWithOffers();
		System.out.println("");
		System.out.println("Enter the number of the item you'd like to make an offer on:");
		userInput = scan.nextLine();
		
//		idTBR = id to be retrieved
		int idTBR = Integer.parseInt(userInput);
		si = sid.retrieveShopItemById(idTBR);
		
		float standingOffer = si.getHighestOffer();
		System.out.println("======================");
		System.out.println("Standing Offer: $" + standingOffer);
		
		System.out.println("Make an offer");
		userInput = scan.nextLine();
		float offer = Float.parseFloat(userInput);

		boolean offerWentThrough;
		try {
			offerWentThrough = cs.makeOffer(offer, si, cu.getId());
			if(offerWentThrough == true) {
				System.out.println("=====================================");
				System.out.println("We have received your offer!");
				System.out.println("=====================================");
			} else {
				System.out.println("=====================================");
				System.out.println("Sorry, a higher offer has already been made on that item.");
				System.out.println("=====================================");
			}
		} catch (MakeNegativeOfferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Would you like to make another offer?");
		System.out.println("1: Yes");
		System.out.println("2: No");
		userInput = scan.nextLine();
		
		if(userInput.equals("1")) {
//			Recursive
			offerView(cu);
		} else if(userInput.equals("2")) {
			System.out.println("============================");
			customerPortal(cu);
		}
	}
}
