package com.Cart.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Items {
	private String name;
	
	private int price;
	
	private int quantity;
	@Id
	private String pack_id;


    @ManyToOne
    @JsonBackReference
    private Cart cart;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	

	public Items(String name,  int price,  int quantity, String pack_id) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.pack_id = pack_id;
	}

	public Items() {

	}

	// getters and setters
	public String getPack_id() {
		return pack_id;
	}

	public void setPack_id(String pack_id) {
		this.pack_id = pack_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "Items [name=" + name + ", price=" + price + ", quantity=" + quantity + ", pack_id=" + pack_id + "]";
	}


}

