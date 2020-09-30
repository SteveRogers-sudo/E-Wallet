package com.cg.ewallet.dao;

import com.cg.ewallet.entity.Transaction;
import com.cg.ewallet.entity.User;

public interface EWalletDao {
	
	public User viewUser(String userId);
	public boolean addUser(User user);
	public boolean editUser(User user);
	public boolean addTransaction(Transaction transaction);

}
