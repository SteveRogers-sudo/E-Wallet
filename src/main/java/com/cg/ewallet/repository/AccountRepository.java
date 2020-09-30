package com.cg.ewallet.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cg.ewallet.entity.Account;

@Repository
public class AccountRepository {
	
	public static Map<Long,Account> accountRepository=new HashMap<Long,Account>();
	static {
		accountRepository.put((long) 252526,new Account(15000,"Yogesh Upadhyay",2563));
		accountRepository.put((long) 252527,new Account(20000,"Bishal Das",1234));
		accountRepository.put((long) 252528,new Account(30000,"Anand Raj",4321));
		accountRepository.put((long) 252529,new Account(23500,"Souvik Debroy",1205));
		accountRepository.put((long) 252523,new Account(25350,"Anumay Sah",1405));
		
	}
	

}
