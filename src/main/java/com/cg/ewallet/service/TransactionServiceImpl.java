package com.cg.ewallet.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ewallet.dao.EWalletDao;
import com.cg.ewallet.dao.EWalletJpaRepository;
import com.cg.ewallet.dao.EWalletTransactionJpaRepository;
import com.cg.ewallet.entity.Account;
import com.cg.ewallet.entity.Transaction;
import com.cg.ewallet.entity.User;
import com.cg.ewallet.exception.AccountException;
import com.cg.ewallet.exception.InsufficientException;
import com.cg.ewallet.repository.AccountRepository;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	EWalletDao eWalletDao;
	
	@Autowired
	EWalletTransactionJpaRepository transRepo;
	
	@Autowired
	EWalletJpaRepository userRepo;

	AccountRepository acntRepo;
	
	/*******************************************************************************************************
	 METHOD: doTransaction
	 Description: Transfer the required amount from sender wallet to the reciever wallet 
	 
	 	@param fromUserId: Sender's userId
	 	@param toUserId: Receiver's userId
	 	@param amount: amount to be transfered
	 	@throws AccountException: it is raised if the beneficiary dosen't exist
	 	@throws InsufficientException:it is raised if the amount is greater then the account balance of the user 
	 	
	 Created By - Bishal Das
	********************************************************************************************************/
	
	@Override
	public boolean doTransaction(String fromUserId, String toUserId, double amount) throws AccountException, InsufficientException {
		
		User fromUser=eWalletDao.viewUser(fromUserId);
		User toUser=eWalletDao.viewUser(toUserId);
		
		if(fromUser==null) throw new AccountException("Invalid Account");
		if(toUser==null) throw new AccountException("Invalid Account");
		
		if(fromUser.getUserBalance()<amount) throw new InsufficientException("Insufficient balance");
		
			fromUser.setUserBalance(fromUser.getUserBalance()-amount);
			toUser.setUserBalance(toUser.getUserBalance()+amount);
			
			Transaction fromTran=new Transaction();
			fromTran.setTransAmount(amount);
			fromTran.setTransType("Debit");
			fromTran.setTransDate(LocalDate.now());
			fromTran.setUser(fromUser);
			
			Transaction toTran=new Transaction();
			toTran.setTransAmount(amount);
			toTran.setTransType("credit");
			toTran.setTransDate(LocalDate.now());
			toTran.setUser(toUser);
			
			transRepo.save(fromTran);
			transRepo.save(toTran);
			eWalletDao.editUser(fromUser);
			eWalletDao.editUser(toUser);

		return true;
	}
	
	/*******************************************************************************************************
	 METHOD: showBalance 
	 Description: fetches and returns the balance of the user wallet
	
		@param userId: User's userId
		@returns double: Balance fetched from the user wallet 
		
	 Created By - Bishal Das
	********************************************************************************************************/
	
	public double showBalance(String userId) throws AccountException
	{
		User user=eWalletDao.viewUser(userId);
		if(user==null) throw new AccountException("Invalid Account");
		double balance = user.getUserBalance();
		return balance ;
		
	}

	/*******************************************************************************************************
	 METHOD: bankBalance 
	 Description: fetches and returns the balance of the bank account
	 
	 	 @param userId: accountNumber of account
	 	 @returns String: Balance fetched from the bank account 
	 	 
	 Created By - Bishal Das
	********************************************************************************************************/
	@Override
	public String bankBalance(long accountNumber) throws AccountException 
	{
		Account account=acntRepo.accountRepository.get(accountNumber);
		if(account==null) throw new AccountException("Invalid Bank Details");
		double balance = account.getAccountBalance();
		return "Bank account balance :"+balance;
	}

}
