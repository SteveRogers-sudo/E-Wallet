package com.cg.ewallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ewallet.dao.EWalletDao;
import com.cg.ewallet.entity.Account;
import com.cg.ewallet.entity.User;
import com.cg.ewallet.repository.AccountRepository;

@Service
@Transactional
public class AddAmountImpl implements AddAmount{
	
	@Autowired
	EWalletDao eWalletDao;
	
	AccountRepository ar;

	@Override
	public void addAmount(String userId, double amount, String accountHolderName, int accountPin, long accountNumber) {
		
		User user=eWalletDao.viewUser(userId);
		
		Account account=ar.accountRepository.get(accountNumber);
		
		System.out.println("Initial Account balance "+account.getAccountBalance());
		 if(account.getAccountBalance()<amount) {
			 System.out.println("Insufficient balance");
		 }
		 else {
			 account.setAccountBalance(account.getAccountBalance()-amount);
			 user.setUserBalance(user.getUserBalance()+amount);
			 eWalletDao.editUser(user);
		 }
		 
		 System.out.println("Final Account balance "+account.getAccountBalance());
		
		
		
	}

}
