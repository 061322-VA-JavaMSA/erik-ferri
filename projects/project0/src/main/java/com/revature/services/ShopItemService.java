package com.revature.services;

import java.util.List;

import com.revature.daos.ShopItemDAO;
import com.revature.daos.ShopItemPostgres;
import com.revature.models.ShopItem;

public class ShopItemService {

	private ShopItemDAO sid = new ShopItemPostgres();
	
	public List<ShopItem> getShopItems(){
		return sid.retrieveShopItems();
	}
	
	public void displayItemList() {
		List<ShopItem> shopItems = getShopItems();
		System.out.println("============================================");
		System.out.println("SHOP ITEMS");
		System.out.println("============================================");
		for(int i = 0; i < shopItems.size(); i++) {
			int itemId = shopItems.get(i).getId();
			if(!shopItems.get(i).getOwned().equals("yes")) {
				System.out.println(itemId + ": " + shopItems.get(i).getItemName());
			}
		}
	}
	
	public void displayItemListWithOffers() {
		List<ShopItem> shopItems = getShopItems();
		System.out.println("=======================================================");
		System.out.println("SHOP ITEMS - HIGHEST OFFER LISTED TO RIGHT OF EACH ITEM");
		System.out.println("=======================================================");
		for(int i = 0; i < shopItems.size(); i++) {
			float highestOffer = shopItems.get(i).getHighestOffer();
			int itemId = shopItems.get(i).getId();
			if(!shopItems.get(i).getOwned().equals("yes")) {
				System.out.println(itemId + ": " + shopItems.get(i).getItemName() + " - $" + highestOffer);
			}
		}
	}
}