package com.Admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Admin.model.Ratings;
import com.Admin.model.WasherProfile;
import com.Admin.service.WasherService;
import com.Admin.service.WasherServiceImpl;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/admin/washer")
public class WasherController {
	
	@Autowired
	WasherService washerService;
	
	@GetMapping("/all")
	public List<WasherProfile> findAllWashers() {
		return washerService.getAllWasher();
	}
	
	@GetMapping("/{email}")
	public WasherProfile findWasherById(@PathVariable String email) {
		return washerService.findWasherById(email);
	}
	
	// add details of a new customer 
	@PostMapping("/add")
	public String addWasher(@Valid @RequestBody WasherProfile washer) {
		washerService.addWasher(washer);
		return "Washer Added Successfully";
	}
	
	@PostMapping("/addRating/{email}")
	public String addRatingToWasher(@PathVariable String email, @RequestBody Ratings rating) {
		washerService.addRatingToWasher(email, rating);
		return "Rating added successfully";
	}
	

	@DeleteMapping("/delete/{email}")
	public String deleteWasher(@PathVariable String email) {
		washerService.deleteWasher(email);
		return "Washer Deleted Successfully";
    }
	
	@PutMapping("/update")
	public String updateWasher(@Valid @RequestBody WasherProfile washer) {
		washerService.updateWasher(washer);
		return "Washer Details Updated Successfully";
	}

}
