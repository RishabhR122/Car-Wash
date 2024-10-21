package com.Admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Admin.model.Ratings;

@Repository
public interface RatingRepo extends JpaRepository<Ratings, String>{
	
	

}
