package com.car.wash.order.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.car.wash.order.model.OrderDetails;
import com.car.wash.order.model.Receipt;

public interface OrderService {
	public List<OrderDetails>allDetails();
	//public String addData(OrderDetails det);
	public OrderDetails addOrder(OrderDetails data);
	public String cancelOrder(OrderDetails data);
	public List<OrderDetails> getOrdersOnUserEmailId(String userEmailId);
	public List<OrderDetails> getAllCompletedOrders();
	public List<OrderDetails> getAllPendingOrders();
	public List<OrderDetails> getAllCancelledOrders();
	public List<OrderDetails> getAllAssignedOrders();
	public List<OrderDetails> getOrdersBySpecificWasher(String washerName);
	public List<OrderDetails> getOrdersBySpecificUsers(String userName);
	public ResponseEntity<Optional<OrderDetails>> getOneOrder(String orderId);
	public ResponseEntity<Map<String,Boolean>> deleteOrder(String orderId);
	public ResponseEntity<OrderDetails> cancelOrderWithId(String orderId);
	public ResponseEntity<OrderDetails> updateStatus(String orderId);
	public OrderDetails assignWasherName(OrderDetails ord, String orderId);
	public void generateReceipt(String transactionId, Receipt receipt);
	
}