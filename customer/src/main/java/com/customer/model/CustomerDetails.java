package com.customer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class CustomerDetails {
	
	
	@Id
	@NotBlank(message = "Detail cannot be left empty")
	private String id;
	
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message="Enter valid email")
	@NotBlank(message = "Detail cannot be left empty")
	private String email;
	
	@NotBlank(message = "Detail cannot be left empty")
	@Pattern(regexp = "[a-zA-z ]*",message = "Name should only contain Aplphabets")
    private String name;
	
	@NotBlank(message = "Detail cannot be left empty")
	@Size(min=10, max=10, message = "Phone number should contain only 10 Digits")
	@Pattern(regexp = "[0-9]*",message = "Phone number should contain only Digits")
    private String phoneNumber;
   
    
    
    public CustomerDetails() {
    	
    }
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public CustomerDetails(String id, String email, String name, String phoneNumber) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}


}