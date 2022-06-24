package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.ShopItem;
import com.revature.models.Customer;
//import com.revature.services.CustomerService;
import com.revature.util.ConnectionUtil;

public class ShopItemPostgres implements ShopItemDAO {

	private static Logger log = LogManager.getLogger(ShopItemPostgres.class);
	
	@Override
	public ShopItem createShopItem(ShopItem si) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShopItem> retrieveShopItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShopItem retrieveShopItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShopItem> retrieveShopItemsById(int id) {
		String sql = "select si.id, si.item_name, si.item_description, si.item_highest_offer, si.item-owned, si.purchased_by , u.username from ShopItems si join users u on si.user_assigned_id = u.id where user_assigned_id = ?;";
		List<ShopItem> ShopItems = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ShopItem si = new ShopItem();
				si.setId(rs.getInt("id"));
				si.setName(rs.getString("item-name"));
				si.setDescription(rs.getString("item-description"));
				si.setHighestOffer(rs.getFloat("item-highest-offer"));
				si.setOwned(rs.getString("item-owned"));
				
				Customer cu = new Customer();
				cu.setId(rs.getInt("purchased-by"));
				cu.setUsername(rs.getString("username"));
				
				si.setPurchasedBy(cu);
				
				ShopItems.add(si);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ShopItems;
	}

	@Override
	public boolean updateShopItem(ShopItem t) {
		// TODO Auto-generated method stub
		return false;
	}

}