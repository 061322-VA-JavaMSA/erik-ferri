package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.ShopItem;
import com.revature.models.Customer;
import com.revature.services.ShopItemService;
import com.revature.util.ConnectionUtil;

public class ShopItemPostgres implements ShopItemDAO {

	private static Logger log = LogManager.getLogger(ShopItemPostgres.class);

	@Override
	public ShopItem createShopItem(ShopItem si) {
		String sql = "insert into shop_items (item_name) values (?) returning id;";
		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, si.getItemName());

			ResultSet rs = ps.executeQuery(); // return the id generated by the database
			if (rs.next()) {
				si.setId(rs.getInt("id"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return si;
	}

	@Override
	public List<ShopItem> retrieveShopItems() {
		String sql = "select * from shop_items order by id;";
		List<ShopItem> shopItems = new ArrayList<>();

		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			// no user input taken, no need for prepared statement
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				// extract each field from rs for each record, map them to a ShopItem object and
				// add them to the shopItems arraylist
				ShopItem si = new ShopItem();
//				si.setId(rs.getInt("id"));
				si.setItemName(rs.getString("item_name"));
				si.setHighestOffer(rs.getFloat("highest_offer"));
				si.setOwned(rs.getString("item_owned"));

				shopItems.add(si);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return shopItems;

	}

	@Override
	public ShopItem retrieveShopItemById(int id) {
		String sql = "select * from shop_items where id = ?;";
		ShopItem si = null;
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, id); // this refers to the 1st ? in the sql String
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				si = new ShopItem();
				si.setId(rs.getInt("id"));
				si.setItemName(rs.getString("item_name"));
				si.setHighestOffer(rs.getFloat("highest_offer"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return si;
	}

	@Override
	public List<ShopItem> retrieveShopItemsByUserId(int id) {
		String sql = "select si.id, si.item_name, si.item_description, si.item_highest_offer, si.item-owned, si.purchased_by , u.username from ShopItems si join users u on si.user_assigned_id = u.id where user_assigned_id = ?;";
		List<ShopItem> ShopItems = new ArrayList<>();

		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ShopItem si = new ShopItem();  
				si.setId(rs.getInt("id"));
				si.setItemName(rs.getString("item-name"));
				si.setItemDescription(rs.getString("item-description"));
				si.setHighestOffer(rs.getFloat("item-highest-offer"));
				si.setOwned(rs.getString("item-owned"));

				Customer cu = new Customer();
				cu.setId(rs.getInt("purchased-by"));
				cu.setUsername(rs.getString("username"));

				si.setCustomerID(cu.getId());

				ShopItems.add(si);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ShopItems;
	}

	@Override
	public boolean makeShopItemOffer(float offer, ShopItem si, int customerID) {
		String sql = "update shop_items set highest_offer = ?, customer_id = ? where id = ?;";
		int rowsChanged = -1;
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setFloat(1, offer);
			ps.setInt(2, customerID);
			ps.setInt(3, si.getId());
			
			if(offer > si.getHighestOffer()) {
				rowsChanged = ps.executeUpdate();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rowsChanged < 1) {
			return false;
		}
		return true;
	}
	
	public boolean acceptShopItemOffer(int id) {
		String sql = "update shop_items set item_owned = ? where id = ?;";
		int rowsChanged = -1;
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, "yes"); 
			ps.setInt(2, id);
			
			rowsChanged = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rowsChanged < 1) {
			return false;
		}
		return true;
	}
	
	public boolean rejectShopItemOffer(int id) {
		String sql = "update shop_items set highest_offer = null, customer_id = null where id = ?;";
		int rowsChanged = -1;
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			rowsChanged = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rowsChanged < 1) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean deleteShopItemById(int id) {
		String sql = "delete from shop_items where id = ?;";
		int rowsChanged = -1;
		try(Connection c = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			rowsChanged = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(rowsChanged < 1) {
			return false;
		}
		return true;
	}
}