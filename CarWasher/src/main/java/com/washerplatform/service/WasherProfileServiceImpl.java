package com.washerplatform.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.washerplatform.exception.WasherAlreadyExists;
import com.washerplatform.exception.WasherIdNotFound;
import com.washerplatform.models.WasherProfile;
import com.washerplatform.repository.WasherRepository;

@Service
public class WasherProfileServiceImpl implements WasherProfileService{
	@Autowired
	private WasherRepository WasherRepo;
	public WasherProfile addWasher(@RequestBody WasherProfile details) {
		if(!WasherRepo.existsById(details.getEmail())) {
			return WasherRepo.save(details);
		}
		throw new WasherAlreadyExists("Washer "+details.getEmail()+" Already Exsits...");
	}
	//update washer detail
	public void updateDetails(@PathVariable String emailId, @RequestBody WasherProfile details) {
		if(WasherRepo.existsById(emailId))
			WasherRepo.save(details);
		throw new WasherIdNotFound("Washer emailID : "+emailId+" Not Found");
	}
	//get all washers
	public List<WasherProfile> getAllWashers() {
		return WasherRepo.findAll();
	}
	//delete washer by email
	public void deleteById(String email) {
		WasherRepo.deleteById(email);

	}
	//get washer details by full name
	public List<WasherProfile> getWasher(String fullName) {
		System.out.println(fullName);

		return WasherRepo.findAll().stream().filter(x ->x.getFullName().contains(fullName)).collect(Collectors.toList());


	}
}
