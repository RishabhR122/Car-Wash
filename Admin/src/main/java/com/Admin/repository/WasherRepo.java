package com.Admin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Admin.model.WasherProfile;

@Repository
public interface WasherRepo extends JpaRepository<WasherProfile, String>{
	
	 

}
