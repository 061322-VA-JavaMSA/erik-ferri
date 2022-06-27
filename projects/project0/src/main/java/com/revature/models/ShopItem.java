package com.revature.models;

//import java.time.LocalDate;
import java.util.Objects;

public class ShopItem {

	private int id;
	private String itemName;
	private String itemDescription;
	private float highestOffer;
	private String owned;
	private Customer purchasedBy;
	
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
	
	public String getItemDescription() {
		return itemDescription;
	}
	
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
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
	
	public Customer getPurchasedBy() {
		return purchasedBy;
	}
	
	public void setPurchasedBy(Customer purchasedBy) {
		this.purchasedBy = purchasedBy;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, itemName, itemDescription, highestOffer, owned, purchasedBy);
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
		return id == other.id && Objects.equals(itemName, other.itemName) && Objects.equals(itemDescription, other.itemDescription)
				&& highestOffer == other.highestOffer && Objects.equals(owned, other.owned)
				&& Objects.equals(purchasedBy, other.purchasedBy);
	}
	
	@Override
	public String toString() {
		return "ShopItem [id=" + id + ", itemName=" + itemName + ", itemDescription=" + itemDescription + ", highestOffer=" + highestOffer
				+ ", owned=" + owned + ", purchasedBy=" + purchasedBy + "]";
	}
}