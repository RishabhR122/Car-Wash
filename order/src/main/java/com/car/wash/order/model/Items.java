package com.car.wash.order.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class Items {
	private String washPack;
	@NotEmpty
	@Min(0)
	private int price;
	@Min(1)
	private int quantity;
	private String packId;
//	public Items(String washPack, int price, int quantity, String packId) {
//		super();
//		this.washPack = washPack;
//		this.price = price;
//		this.quantity = quantity;
//		this.packId = packId;
//	}
	
	
	
	
	
	public Items() {
		super();
	}

	public Items(String washPack, @NotEmpty @Min(0) int price, @Min(1) int quantity, String packId) {
	super();
	this.washPack = washPack;
	this.price = price;
	this.quantity = quantity;
	this.packId = packId;
}

	public String getWashPack() {
		return washPack;
	}

	public void setWashPack(String washPack) {
		this.washPack = washPack;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPackId() {
		return packId;
	}

	public void setPackId(String packId) {
		this.packId = packId;
	}

	@Override
	public String toString() {
		return "Items [washPack=" + washPack + ", price=" + price + ", quantity=" + quantity + ", packId=" + packId
				+ "]";
	}

//	@Override
//	public String toString() {
//		return "Items [washPack=" + washPack + ", price=" + price + ", quantity=" + quantity + ", packId=" + packId
//				+ "]";
//	}
	
	
	
}
