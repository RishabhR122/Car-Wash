package com.Admin.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class WasherProfile {
    
    @Id
    @NotEmpty(message="Detail cannot be left empty")
    private String email;  
    @NotEmpty(message="Detail cannot be left empty")
    private String password;
    @NotEmpty(message="Detail cannot be left empty")
    private String fullName;
    @NotEmpty(message="Detail cannot be left empty")
    private String status;
    @NotEmpty(message="Detail cannot be left empty")
    private String phoneNumber;
    

    @OneToMany(mappedBy = "washer", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Ratings> ratingList;

    
    public WasherProfile() {}

    
    

    public WasherProfile(@NotEmpty(message = "Detail cannot be left empty") String email,
			@NotEmpty(message = "Detail cannot be left empty") String password,
			@NotEmpty(message = "Detail cannot be left empty") String fullName,
			@NotEmpty(message = "Detail cannot be left empty") String status,
			@NotEmpty(message = "Detail cannot be left empty") String phoneNumber, List<Ratings> ratingList) {
		super();
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.status = status;
		this.phoneNumber = phoneNumber;
		this.ratingList = ratingList;
	}




	public void addRating(Ratings rating) {
        ratingList.add(rating);
        rating.setWasher(this);  
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


	@Override
	public String toString() {
		return "WasherProfile [email=" + email + ", password=" + password + ", fullName=" + fullName + ", status="
				+ status + ", phoneNumber=" + phoneNumber + ", ratingList=" + ratingList + "]";
	}
    
}