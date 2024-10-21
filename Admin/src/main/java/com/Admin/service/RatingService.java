package com.Admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Admin.model.Ratings;


@Service
public interface RatingService {
	
	 public List<Ratings> getallRatings();
	 public void addRating(Ratings ratings);
	 public List<Ratings> getSpecificWasherRating(String washerName);
	 public void deleteRating(String id);

}
