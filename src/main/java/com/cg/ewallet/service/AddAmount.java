package com.cg.ewallet.service;

public interface AddAmount {
	public void addAmount(String userId,double amount,String accountHolderName,int accountPin,long accountNumber);
}
