package com.cg.ewallet.service;

import com.cg.ewallet.entity.User;
import com.cg.ewallet.exception.AccountException;
import com.cg.ewallet.exception.InsufficientException;

public interface TransactionService {
	
	public boolean doTransaction(String fromUserId,String toUserId,double amount) throws AccountException, InsufficientException;

	public double showBalance(String userId) throws AccountException;

	public String bankBalance(long accountNumber) throws AccountException;

}
