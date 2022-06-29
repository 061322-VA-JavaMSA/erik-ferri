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
		for(int i = 0; i < shopItems.size(); i++) {
			int itemId = getShopItems().get(i).getId();
			if(!getShopItems().get(i).getOwned().equals("yes")) {
				System.out.println(itemId + ": " + getShopItems().get(i).getItemName());
			}
		}
	}
	
	public void displayItemListWithOffers() {
		List<ShopItem> shopItems = getShopItems();
		for(int i = 0; i < shopItems.size(); i++) {
			float highestOffer = getShopItems().get(i).getHighestOffer();
			int itemId = getShopItems().get(i).getId();
			if(!getShopItems().get(i).getOwned().equals("yes")) {
				System.out.println(itemId + ": " + getShopItems().get(i).getItemName() + " - " + highestOffer);
			}
		}
	}
}