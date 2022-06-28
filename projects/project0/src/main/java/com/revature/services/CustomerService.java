package com.revature.services;

//import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import com.revature.daos.UserDAO;
//import com.revature.daos.UserPostgres;
//import com.revature.models.User;
import com.revature.daos.ShopItemDAO;
import com.revature.daos.ShopItemPostgres;
import com.revature.models.ShopItem;
import com.revature.models.Customer;

public class CustomerService {

	private ShopItemDAO sid = new ShopItemPostgres();

	public boolean makeOffer(float offer, ShopItem si, int customerID) {
		
		return sid.makeShopItemOffer(offer, si, customerID);
	}
}