package com.cg.ewallet.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class UserForm {
	
	private String userName;
	
	private String password;
	
	private String userContact;
	
	private String userEmail;
	
	@DateTimeFormat(pattern="yyyy-M-d")
	private LocalDate userDob;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserContact() {
		return userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public LocalDate getUserDob() {
		return userDob;
	}

	public void setUserDob(LocalDate userDob) {
		this.userDob = userDob;
	}
	
	

}
