package com.revature.services;

//import java.util.List;

import com.revature.daos.ShopItemDAO;
import com.revature.daos.ShopItemPostgres;
import com.revature.models.ShopItem;

public class EmployeeService {
	
	private ShopItemDAO sid = new ShopItemPostgres();
	
	public ShopItem addShopItem(ShopItem si){
		//
		return sid.createShopItem(si);
	}
}
