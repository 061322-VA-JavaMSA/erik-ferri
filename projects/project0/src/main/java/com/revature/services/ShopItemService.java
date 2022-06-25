package com.revature.services;

import java.util.List;

import com.revature.daos.ShopItemDAO;
import com.revature.daos.ShopItemPostgres;
import com.revature.models.ShopItem;

public class ShopItemService {

	private ShopItemDAO sid = new ShopItemPostgres();
	
	public List<ShopItem> getShopItems(){
		//
		return sid.retrieveShopItems();
	}
}