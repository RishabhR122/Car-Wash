package com.car.wash.order.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.car.wash.order.handlers.API_reqExceptionHandling;
import com.car.wash.order.model.OrderDetails;
import com.car.wash.order.model.Receipt;
import com.car.wash.order.repositry.OrderRepo;

@Service
public class OrderServicesImpl implements OrderService {
	@Autowired
	OrderRepo repo;

	@Autowired
	RestTemplate restTemplate;

	static final String url1 = "http://localhost:8080/api/payments";
	static final String url = "http://localhost:8080/admin";


	public List<OrderDetails> allDetails() {
		return repo.findAll();
	}

//	public String addData(OrderDetails det) {
//		repo.save(det);
//		return "";
//	}
//	public String updateData(String id,OrderDetails det) {
//		for(OrderDetails ord:repo.findAll()) {
//			if(ord.getOrderId().equals(id)) {
//				ord.setOrderId(det.getOrderId());
//				ord.setUserName(det.getUserName());
//				ord.setUserEmailId(det.getUserEmailId());
//				ord.setUserPhoneNo(det.getUserPhoneNo());
//				ord.setAreaPinCode(det.getAreaPinCode());
//				ord.setWasherName(det.getWasherName());
//				ord.setWasherPack(det.getWasherPack());
//				ord.setStatus(det.getStatus());
//			}
//		}
//		return "";
//	}

	// PLACING AN ORDER
	public OrderDetails addOrder(OrderDetails data) {
		return repo.save(data);
	}

//	public String deleteData() {
//		repo.deleteAll();
//		return "";
//	}
	public String cancelOrder(OrderDetails data) {
		OrderDetails ord = repo.findById(data.getOrderId()).get();
		ord.setStatus("Cancelled");
		repo.save(ord);
		return "The order with Id - " + data.getOrderId() + " is cancelled successfully";
	}

	// To filter orders using user emailId
	public List<OrderDetails> getOrdersOnUserEmailId(String userEmailId) {
		return repo.findAll().stream().filter(x -> x.getUserEmailId().contains(userEmailId))
				.collect(Collectors.toList());
	}

	// To find all the completed orders
	public List<OrderDetails> getAllCompletedOrders() {
		return repo.findAll().stream().filter(x -> x.getStatus().contains("Completed")).collect(Collectors.toList());
	}

	// to find all the pending orders
	public List<OrderDetails> getAllPendingOrders() {
		return repo.findAll().stream().filter(x -> x.getStatus().contains("Pending")).collect(Collectors.toList());
	}

	// to find all the cancelled orders
	public List<OrderDetails> getAllCancelledOrders() {
		return repo.findAll().stream().filter(x -> x.getStatus().contains("Cancelled")).collect(Collectors.toList());
	}

	// to find all the unassigned orders
	public List<OrderDetails> getAllAssignedOrders() {
		return repo.findAll().stream().filter(x -> x.getStatus().contains("NA")).collect(Collectors.toList());
	}

	// to find all the orders by specific washer
	public List<OrderDetails> getOrdersBySpecificWasher(String washerName) {
		return repo.findAll().stream().filter(s -> s.getWasherName().contains(washerName)).collect(Collectors.toList());
	}

	// to find all the orders by specific users
	public List<OrderDetails> getOrdersBySpecificUsers(String userName) {
		return repo.findAll().stream().filter(x -> x.getUserName().contains(userName)).collect(Collectors.toList());
	}

	// find one object by id
	public ResponseEntity<Optional<OrderDetails>> getOneOrder(String orderId) {
		Optional<OrderDetails> ord = repo.findById(orderId);
		if (ord != null) {
			return ResponseEntity.ok(ord);
		} else {
			throw new API_reqExceptionHandling("Order with Id : " + orderId + " not found.");
		}
	}

	// to delete specific order id
	public ResponseEntity<Map<String, Boolean>> deleteOrder(String orderId) {
		OrderDetails ord = repo.findById(orderId).orElseThrow(() -> new API_reqExceptionHandling(
				"Order with Id : " + orderId + " not found. Unable to delete the order"));
		repo.delete(ord);
		Map<String, Boolean> res = new HashMap<>();
		res.put("Order deleted", Boolean.TRUE);
		return ResponseEntity.ok(res);
	}

	// to cancel the order with specific order
	public ResponseEntity<OrderDetails> cancelOrderWithId(String orderId) {
		OrderDetails ord = repo.findById(orderId).orElseThrow(() -> new API_reqExceptionHandling(""));
		ord.setStatus("Cancelled");
		OrderDetails order = repo.save(ord);
		return ResponseEntity.ok(order);
	}

	// to update the status of the order
	public ResponseEntity<OrderDetails> updateStatus(String orderId) {
		OrderDetails ord = repo.findById(orderId).orElseThrow(() -> new API_reqExceptionHandling(""));
		ord.setStatus("Completed");
		OrderDetails order = repo.save(ord);
		return ResponseEntity.ok(order);
	}

	// to assign the washer name
	public OrderDetails assignWasherName(OrderDetails ord, String orderId) {
		OrderDetails ords = repo.findById(ord.getOrderId()).orElse(null);
		if (!(ords==null)) {	
			ords.setWasherName(ord.getWasherName());
			return repo.save(ords);
		} else {
			throw new API_reqExceptionHandling("Order not found in database, washer not assigned");
		}
	}

	public void generateReceipt(String transactionId, Receipt receipt) {

		int amount = restTemplate.getForObject(url1 + "/getAmount/" + transactionId, Integer.class);
		receipt.setAmount(amount);
		restTemplate.postForLocation(url+"/createReceipt", receipt);
	}

}
