package com.Admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Admin.exceptions.NoSuchWasherException;
import com.Admin.exceptions.WasherAlreadyExistException;
import com.Admin.model.Ratings;
import com.Admin.model.WasherProfile;
import com.Admin.repository.WasherRepo;

@Service
public class WasherServiceImpl implements WasherService {
	
	@Autowired
	WasherRepo washerRepo;
	
	public List<WasherProfile> getAllWasher() {

		return washerRepo.findAll();

	}
	
	
	public WasherProfile findWasherById(String email) {
		Optional<WasherProfile> op = washerRepo.findById(email);
		if (op.isEmpty()) {
			throw new NoSuchWasherException("No washer of id:" + email + " exists");
		}
		return op.get();
	}

	public void addWasher(WasherProfile washer) {
		Optional<WasherProfile> op = washerRepo.findById(washer.getEmail());
		if (!op.isEmpty()) {
			throw new WasherAlreadyExistException("Washer of id:" + washer.getEmail() + " already exists");
		} else {
			washerRepo.save(washer);
		}
	}
	
	public void addRatingToWasher(String email, Ratings rating) {
		WasherProfile washer = washerRepo.findById(email).orElseThrow(() -> new NoSuchWasherException("Washer not found"));
	    washer.addRating(rating);  
	    washerRepo.save(washer);
	}
	
	

	public void deleteWasher(String email) {
		Optional<WasherProfile> op = washerRepo.findById(email);
		if (op.isEmpty()) {
			throw new NoSuchWasherException("washer not found");
		} else {
			washerRepo.deleteById(email);
		}
	}

	public void updateWasher(WasherProfile washer) {
		Optional<WasherProfile> op = washerRepo.findById(washer.getEmail());
		if (op.isEmpty()) {
			throw new NoSuchWasherException("No Washer of id:" + washer.getEmail() + " exists");
		} else {
			washerRepo.save(washer);
		}

	}

}