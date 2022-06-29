package com.revature.daos;

import java.util.List;

import com.revature.models.ShopItem;
import com.revature.models.Customer;

public interface ShopItemDAO {
	ShopItem createShopItem(ShopItem si);
	List<ShopItem> retrieveShopItems();
	ShopItem retrieveShopItemById(int id);
	List<ShopItem> retrieveShopItemsByUserId(int id);
	boolean makeShopItemOffer(float offer, ShopItem si, int customerID);
	boolean acceptShopItemOffer(ShopItem si);
	boolean rejectShopItemOffer(int id);
	boolean deleteShopItemById(int id);
}