package com.cg.ewallet.entity;

public class Account {
	
	private double accountBalance;
	
	private String accountHolderName;
	
	private int accountPin;

	public Account(double accountBalance, String accountHolderName, int accountPin) {
		super();
		this.accountBalance = accountBalance;
		this.accountHolderName = accountHolderName;
		this.accountPin = accountPin;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
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
