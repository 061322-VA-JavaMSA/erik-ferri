package com.revature.models;

//import java.time.LocalDate;
import java.util.Objects;

public class ShopItem {

	private int id;
	private String name;
	private String description;
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

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public float getHighestOffer() {
		return highestOffer;
	}
	
	public void setHighestOffer(float highestOffer) {
		this.highestOffer = highestOffer;
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
		return Objects.hash(id, name, description, highestOffer, owned, purchasedBy);
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
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(description, other.description)
				&& highestOffer == other.highestOffer && Objects.equals(owned, other.owned)
				&& Objects.equals(purchasedBy, other.purchasedBy);
	}
	
	@Override
	public String toString() {
		return "ShopItem [id=" + id + ", name=" + name + ", description=" + description + ", highestOffer=" + highestOffer
				+ ", owned=" + owned + ", purchasedBy=" + purchasedBy + "]";
	}
}