package com.Admin.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Admin {
	
	@Id
	@NotEmpty(message ="Detail cannot be left empty")
	private String id;
	@NotEmpty(message ="Detail cannot be left empty")
	private String username;
	@NotEmpty(message ="Detail cannot be left empty")
	private String password;
	@NotEmpty(message ="Detail cannot be left empty")
	private String role;
	@NotEmpty(message ="Detail cannot be left empty")
	private String email;
	
	public Admin() {}
	
	public Admin(String id, String username, String password, String role, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.email = email;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
