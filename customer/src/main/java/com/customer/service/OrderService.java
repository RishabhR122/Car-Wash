package com.customer.service;

import java.util.List;

import com.customer.model.OrderDetails;
import com.customer.model.Ratings;
import com.customer.model.WashPacks;

public interface OrderService {
	
	public List<WashPacks> getAllWP();
	public WashPacks getWPByID(String id);
	public void placeOrder(OrderDetails order);
	public List<OrderDetails> seeMyOrders(String customerName);
	public void addRatingToWasher(String email, Ratings rating);
	public void cancelOrder(OrderDetails order);

}
