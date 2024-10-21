package com.customer.model;

import java.util.List;

public class WasherProfile {
	
	
    private String email;  
  
    private String password;
   
    private String fullName;
    
    private String status;
    
    private String phoneNumber;
    

   
    private List<Ratings> ratingList;

    
    public WasherProfile() {}

    
    
    public WasherProfile(String email, String password, String fullName, String status, String phoneNumber,
			List<Ratings> ratingList) {
		super();
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.status = status;
		this.phoneNumber = phoneNumber;
		this.ratingList = ratingList;
	}



	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Ratings> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Ratings> ratingList) {
        this.ratingList = ratingList;
    }

}
