package com.Admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Admin.model.Ratings;
import com.Admin.service.RatingService;

import jakarta.validation.Valid;


@RestController
@Validated
@RequestMapping("/admin")
public class RatingsController {
	
	@Autowired
	private RatingService ratingservice;
	
	 //add ratings
		@PostMapping("/addRating")
		public String addRating(@Valid @RequestBody Ratings ratings) {
			ratingservice.addRating(ratings);
			return "Ratings Added Successfully";
			
		}
		
		
		// get all ratings
		@GetMapping("/getallRatings")
		public List<Ratings> getallratings() {
			return ratingservice.getallRatings();
		}

		// get the washer specific ratings
		@GetMapping("/washerSpecificRating/{washerName}")
		public List<Ratings> washerSpecificRatingByWasherName(@PathVariable String washerName) {
			return ratingservice.getSpecificWasherRating(washerName);
		}
		
		@DeleteMapping("/deleteRating/{id}")
		public String deleteRating(@PathVariable("id") String id){
	        ratingservice.deleteRating(id);
	        return "Rating deleted successfully";
	    }

}