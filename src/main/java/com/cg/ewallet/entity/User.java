package com.cg.ewallet.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="user1")
public class User {
	
	@Id
	@Column(name="user_id", length=20)
	private String userId;
	
	@Column(name="user_name",length=25)
	private String userName;
	
	@Column(name="user_password",length=25)
	private String userPassword;
	
	@Column(name="user_balance")
	private double userBalance;
	
	@Column(name="user_contact", length=10, unique=true)
	private String userContact;
	
	@Column(name="user_emailid",length=30,unique=true)
	private String userEmail; 
	
	@Column(name="user_dob")
	private LocalDate userDob;

	public User() {
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public double getUserBalance() {
		return userBalance;
	}

	public void setUserBalance(double userBalance) {
		this.userBalance = userBalance;
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
	
	public boolean equals(Object obj) {
		User userObj=(User)obj;
		boolean status=false;
		if(userObj.getUserBalance()==this.userBalance && 
				userObj.getUserContact().equals(this.userContact) &&
				userObj.getUserEmail().equals(this.userEmail) &&
				userObj.getUserId().equals(this.userId ) &&
				userObj.getUserName().equals(this.userName) &&
				userObj.getUserPassword().equals(this.userPassword)) {
			status=true;
		}
			
		
		return status;
	}

}
