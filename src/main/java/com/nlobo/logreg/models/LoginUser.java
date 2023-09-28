package com.nlobo.logreg.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginUser {

	
	@NotEmpty(message = "Please enter your email.")
	@Email(message = "Please enter a valid email.")
	private String email;
	
	@NotEmpty(message = "Please enter your password.")
	@Size(min = 8, max = 60, message = "Password must be between 8 and 60 characters.")
	private String password;
	
	public LoginUser() {}

	public LoginUser(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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
	
}
