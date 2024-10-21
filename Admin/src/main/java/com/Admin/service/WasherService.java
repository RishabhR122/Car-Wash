package com.Admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Admin.model.Ratings;
import com.Admin.model.WasherProfile;

@Service
public interface WasherService {
	
	public List<WasherProfile> getAllWasher();
	public WasherProfile findWasherById(String email);
	public void addWasher(WasherProfile washer) ;
	public void deleteWasher(String email);
	public void updateWasher(WasherProfile washer);
	public void addRatingToWasher(String email, Ratings rating);

}
