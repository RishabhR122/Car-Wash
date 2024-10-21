package com.washerplatform.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.washerplatform.models.WasherProfile;

@Service
public interface WasherProfileService {
	public void updateDetails(String emailId, WasherProfile details);
	public List<WasherProfile> getAllWashers();
	public void deleteById(String email);
	public List<WasherProfile> getWasher(String fullName);
	public WasherProfile addWasher(WasherProfile details);
}
