package com.Cart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Cart.exception.CartAlreadyExistsException;
import com.Cart.exception.CartNotFoundException;
import com.Cart.model.Cart;
import com.Cart.repository.MyRepo;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	MyRepo cartRepository;

	
	@Override
	public Cart getCartById(int cartId) throws CartNotFoundException {
		if (cartRepository.existsById(cartId)) {
			return cartRepository.findById(cartId);
		} else {
			throw new CartNotFoundException("CART NOT FOUND WITH ID " + cartId);
		}
	}

	@Override
	public Cart updateCart(int cartId, Cart cart) throws CartNotFoundException {
		if (cartRepository.existsById(cartId)) {
			Cart updatedCart = cartRepository.findById(cartId);
			updatedCart.setCartId(cart.getCartId());
			updatedCart.setItems(cart.getItems());
			updatedCart.setPrice(cart.getPrice());
			cartRepository.save(updatedCart);
			return updatedCart;

		}
		else
		{
			throw new CartNotFoundException("NO CART FOUND WITH ID "+cartId);
		}


	}

	@Override
	public List<Cart> getallcarts() throws CartNotFoundException {
		List<Cart> carts = cartRepository.findAll();
		if (carts.isEmpty()) {
			throw new CartNotFoundException("NO CARTS EXISTS");
		} else {
			return carts;
		}
	}

	@Override
	public double cartTotal(Cart cart) {

		return cart.getPrice();
	}

	@Override
	public Cart addCart(Cart cart) throws CartAlreadyExistsException {

		return cartRepository.save(cart);

	}

	@Override
	public void deleteCartById(int cartId)
	{
	cartRepository.deleteById(cartId);

	}
}
