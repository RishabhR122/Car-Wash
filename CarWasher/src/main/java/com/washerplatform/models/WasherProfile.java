package com.washerplatform.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class WasherProfile {
	@Id
	@NotEmpty(message="email can't empty")
	private String email;
	@NotBlank(message="password can't be blank")
	private String password;
	@NotEmpty(message="name not be null")
	@Size(min=2,max=20)
	private String fullName;
	@NotEmpty(message="Phonenumber not be blank")
	private String phoneNumber;
	@Size(min=3)
	private String username;

	public WasherProfile() {

	}

	public WasherProfile(String email, String password, String fullName, String phoneNumber, String username) {
		
		this.email = email;
		
		this.password = password;
		this.fullName = fullName;

		this.phoneNumber = phoneNumber;
		this.username = username;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
