package com.revature.daos;

import java.util.List;

import com.revature.models.ShopItem;

public interface ShopItemDAO {
	ShopItem createShopItem(ShopItem si);
	List<ShopItem> retrieveShopItems();
	ShopItem retrieveShopItemById(int id);
	List<ShopItem> retrieveShopItemsById(int id);
	boolean updateShopItem(ShopItem si);
//	boolean deleteShopItemById(int id);
}