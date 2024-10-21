package com.car.wash.order.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.wash.order.model.OrderDetails;
import com.car.wash.order.model.Receipt;
import com.car.wash.order.services.OrderService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	OrderService serv;
	
	//Read Operation
	@GetMapping("/allDetails")
	public List<OrderDetails>getAllDetails(){
		return serv.allDetails();
	}
	
	//
	//Create Operation
//	@PostMapping("/addDetails")
//	public String addAllData(@Valid @RequestBody OrderDetails det) {
//		serv.addData(det);
//		return "details saved";
//	}
	
	///place an order
	@PostMapping("/placeOrder")
	public OrderDetails orderPlace( @RequestBody OrderDetails data) {
		return serv.addOrder(data);
	}
	//Update Operation
//	@PutMapping("/updateDetails/{id}")
//	public String updateUserData(@PathVariable String id, @RequestBody OrderDetails det) {
//		serv.updateData(id, det);
//		return"User details has been updated";
//	}
	
	//Delete Operation
	//@DeleteMapping("/delete")
//	public String deleteAllData() {
//		serv.deleteData();
//		return "Data has been deleted from the database";
//	}
	
	//Cancel the order
	@PutMapping("/cancelOrder")
	public String cancelOrder(@RequestBody OrderDetails data) {
		serv.cancelOrder(data);
		return "The order with ID - "+data.getOrderId()+" is cancelled Successfully.";
	}
	//Get the order details using emailId
	@GetMapping("/allDetails/{userEmailId}")
	public List<OrderDetails> getDetailsByEmailId(@PathVariable String userEmailId){
		return serv.getOrdersOnUserEmailId(userEmailId);
	}
	
	//Get all the completed orders
	@GetMapping("/findCompletedOrders")
	public List<OrderDetails> allCompletedOrders(){
		List<OrderDetails> details = serv.getAllCompletedOrders();
		if(details.isEmpty()) {
			return null;
		}
		return serv.getAllCompletedOrders();
	}
	
	
	//Get all the pending orders
	@GetMapping("/findPendingOrders")
	public List<OrderDetails> allPendingOrders(){
		return serv.getAllPendingOrders();
	}
	
	//Get all the cancelled orders
	@GetMapping("/findCancelledOrders")
	public List<OrderDetails> allCancelledOrders(){
		return serv.getAllCancelledOrders();
	}
	
	//Get all the unassigned orders
	@GetMapping("/findUnassignedOrders")
	public List<OrderDetails> allUnassignedOrders(){
		return serv.getAllAssignedOrders();
	}
	
	
	//Get all the order by specific washerName
	@GetMapping("/washerOrder/{washerName}")
	public List<OrderDetails> allOrderSpecificWashers(@PathVariable String washerName){
		return serv.getOrdersBySpecificWasher(washerName);
	}
	
	//Get all the order by specific users
	@GetMapping("findMyOrder/{userName}")
	public List<OrderDetails> allOrdersBySpecificUser(@PathVariable String userName){
		return serv.getOrdersBySpecificUsers(userName);
	}
	
	
	//Get specific order by orderId
	@GetMapping("/findOne/{orderId}")
	public ResponseEntity<Optional<OrderDetails>> allOrdersByOrderId(@PathVariable String orderId){
		return serv.getOneOrder(orderId);
	}
	
	//to delete specific order 
	@DeleteMapping("/delete/{orderId}")
	public ResponseEntity<Map<String, Boolean>> deletedOrder(@PathVariable String orderId){
		return serv.deleteOrder(orderId);
	}
	
	// to cancel the specific order
	@PutMapping("/cancelOrder/{orderId}")
	public ResponseEntity<OrderDetails> cancelOrderById(@Valid @PathVariable String orderId){
		return serv.cancelOrderWithId(orderId);
	}
	
	// to update the specific order 
	@PutMapping("/update/{orderId}")
	public ResponseEntity<OrderDetails> updateOrderStatus(@Valid @PathVariable String orderId){
		return serv.updateStatus(orderId);
	}
	
	//assign the washer name in the order
	@PutMapping("/assignWasherName/{orderId}")
	public OrderDetails addWasherName(@Valid @RequestBody OrderDetails ord, @PathVariable String orderId) {
		return serv.assignWasherName(ord, orderId);
	}
	
	@PostMapping("/createReceipt/{id}")
	public String generateReceipt(@PathVariable String id,@RequestBody Receipt receipt) {

		serv.generateReceipt(id,receipt);
		return "Receipt generated Successfully";

	}

	
	
	

}
