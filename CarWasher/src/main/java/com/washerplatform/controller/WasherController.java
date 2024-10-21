package com.washerplatform.controller;

import java.util.List;

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

import com.washerplatform.models.OrderDetails;
import com.washerplatform.models.WasherProfile;
import com.washerplatform.service.WasherProfileService;
import com.washerplatform.service.WasherService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/washers")
public class WasherController {
	@Autowired
	WasherProfileService washerProfileService;
	
	@Autowired
	WasherService washerService;

	@PostMapping("/addNewWasher")
	public ResponseEntity addWasher(@Valid @RequestBody WasherProfile details) {
		WasherProfile createdWasher = washerProfileService.addWasher(details);
		return ResponseEntity.ok(createdWasher);
	}

	@PutMapping("/updateDetails/{email}")
	public ResponseEntity updateDetails(@PathVariable String email, @RequestBody WasherProfile details) {
		washerProfileService.updateDetails(email, details);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/getWashers")
	public List<WasherProfile> getAllWashers() {
		return washerProfileService.getAllWashers();
	}

	@GetMapping("/Washer/{fullName}")
	public List<WasherProfile> getAllWashers(@PathVariable String fullName) {
		return washerProfileService.getWasher(fullName);
	}

	@DeleteMapping("/delete/{email}")
	public void deleteproduct(@PathVariable String email) {
		washerProfileService.deleteById(email);

	}
	
	@GetMapping("/findUnassigned")
    public List<OrderDetails> getUnassignedOrders(){
        return washerService.getUnassignedOrders();
    }
    //The status of the order can be either pending or completed
    @PutMapping("/updateStatus/completed")
    public OrderDetails updateStatusoftheOrder(@RequestBody OrderDetails orderDetails){
    	return washerService.updateStatus(orderDetails);
    }
    //To assign a washer to the order by washer
    @PutMapping("/assign")
    public OrderDetails assignSelf(@RequestBody OrderDetails orderDetails){
        return washerService.assignSelf(orderDetails);
    }
}
