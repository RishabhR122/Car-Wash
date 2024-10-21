package com.Cart.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Cart.model.Cart;

@Repository
public interface MyRepo extends JpaRepository<Cart, Integer> {
	public Cart findById(int cartId);


}
