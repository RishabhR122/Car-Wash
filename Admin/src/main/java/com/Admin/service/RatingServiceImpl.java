package com.Admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Admin.exceptions.NoSuchWasherException;
import com.Admin.model.Ratings;
import com.Admin.model.WasherProfile;
import com.Admin.repository.RatingRepo;
import com.Admin.repository.WasherRepo;

import jakarta.transaction.Transactional;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	RatingRepo ratingRepo;

	@Autowired
	WasherRepo washerRepo;

	// To get all the ratings
	public List<Ratings> getallRatings() {
		return ratingRepo.findAll();
	}

	public void addRating(Ratings ratings) {
		ratingRepo.save(ratings);
	}

	@Transactional
	public List<Ratings> getSpecificWasherRating(String washerName) {

		WasherProfile washer = washerRepo.findAll().stream().filter(m -> m.getFullName().contains(washerName)).toList()
				.get(0);
		return washer.getRatingList();

	}

	// To delete a rating
	public void deleteRating(String id) {
		Optional<Ratings> op = ratingRepo.findById(id);
		if (op.isEmpty()) {
			throw new NoSuchWasherException("No such washer exists");
		}
		ratingRepo.deleteById(id);
	}

}