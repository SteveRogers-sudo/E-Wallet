package com.cg.ewallet.dto;

public class TransactionForm {
	
	
	private String fromUserId;	//The UserId from which the amount will be sent
	
	private String toUserId;	//The UserId which will receive the amount

	private double amount;		//The amount to be sent

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(String fromUserId) {
		this.fromUserId = fromUserId;
	}

	public String getToUserId() {
		return toUserId;
	}

	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}
	
	

}
