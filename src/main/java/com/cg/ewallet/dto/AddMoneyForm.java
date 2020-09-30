package com.cg.ewallet.dto;

public class AddMoneyForm {
	
	private String userid;
	
	private long accountNumber;
	
	private double amount;
	
	private String accountHolderName;
	
	private int accountPin;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public int getAccountPin() {
		return accountPin;
	}

	public void setAccountPin(int accountPin) {
		this.accountPin = accountPin;
	}

}
