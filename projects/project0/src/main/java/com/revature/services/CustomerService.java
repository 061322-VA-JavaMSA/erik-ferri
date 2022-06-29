package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.ShopItemDAO;
import com.revature.daos.ShopItemPostgres;
import com.revature.models.Customer;
import com.revature.models.ShopItem;

public class CustomerService {

	private ShopItemDAO sid = new ShopItemPostgres();
	private ShopItemService sis = new ShopItemService();
	
	public void displayCustomerItems(Customer cu) {
		List<ShopItem> shopItems = sid.retrieveShopItemsByUserId(cu.getId());
		for(int i = 0; i < shopItems.size(); i++) {
			int itemId = sis.getShopItems().get(i).getId();
				System.out.println(itemId + ": " + sid.retrieveShopItemsByUserId(cu.getId()).get(i).getItemName());
		}
	}

	public boolean makeOffer(float offer, ShopItem si, int customerID) {
		return sid.makeShopItemOffer(offer, si, customerID);
	}
}