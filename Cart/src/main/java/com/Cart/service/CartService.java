package com.Cart.service;

import java.util.List;
import java.util.Optional;

import com.Cart.model.Cart;

public interface CartService {
	public Cart getCartById(int cartId);
	public Cart updateCart(int cartId,Cart cart);
	public List<Cart> getallcarts();
	public double cartTotal(Cart cart);
	public Cart addCart(Cart cart);
	void deleteCartById(int cartId);
}
