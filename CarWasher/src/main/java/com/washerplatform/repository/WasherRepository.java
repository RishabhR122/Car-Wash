package com.washerplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.washerplatform.models.WasherProfile;

@Repository
public interface WasherRepository extends JpaRepository<WasherProfile, String> {
	
	WasherProfile findByUsername(String username);

	boolean existsByUsername(String username);
}
