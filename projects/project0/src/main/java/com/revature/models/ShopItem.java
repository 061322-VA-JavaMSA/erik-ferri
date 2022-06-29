package com.revature.models;

//import java.time.LocalDate;
import java.util.Objects;

public class ShopItem {

	private int id;
	private String itemName;
	private float highestOffer;
	private String owned;
	private int customerID;
	private float amtOwed;
	
	public ShopItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public float getHighestOffer() {
		return highestOffer;
	}
	
	public void setHighestOffer(float offer) {
		this.highestOffer = offer;
	}
	
	public String getOwned() {
		return owned;
	}
	
	public void setOwned(String owned) {
		this.owned = owned;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	public float getAmtOwed() {
		return amtOwed;
	}
	
	public void setAmtOwed(float amtOwed) {
		this.amtOwed = amtOwed;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, itemName, highestOffer, owned, customerID, amtOwed);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShopItem other = (ShopItem) obj;
		return id == other.id && Objects.equals(itemName, other.itemName)
				&& highestOffer == other.highestOffer && Objects.equals(owned, other.owned)
				&& Objects.equals(customerID, other.customerID) && amtOwed == other.amtOwed;
	}
	
	@Override
	public String toString() {
		return "ShopItem [id=" + id + ", itemName=" + itemName + ", highestOffer=" + highestOffer
				+ ", owned=" + owned + ", customerID=" + amtOwed + ", amtOwed=" + "]";
	}
}