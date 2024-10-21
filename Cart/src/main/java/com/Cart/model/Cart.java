package com.Cart.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Cart {

	@Id
    private int cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Items> items;
    
	private int totalPrice;
	

	
public Cart() {
		super();
	}
public void addData(Items item) {
	items.add(item);
	item.setCart(this);
}
public Cart(int cartId, List<Items> items, int price) {
	super();
	this.cartId = cartId;
	this.items = items;
	this.totalPrice = price;
}
public int getCartId() {
	return cartId;
}
public void setCartId(int cartId) {
	this.cartId = cartId;
}
public List<Items> getItems() {
	return items;
}
public void setItems(List<Items> items) {
	this.items = items;
}
public int getPrice() {
	return totalPrice;
}
public void setPrice(int price) {
	this.totalPrice = price;
}


//getters and setters

	

}

