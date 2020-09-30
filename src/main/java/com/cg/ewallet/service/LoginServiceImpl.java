package com.cg.ewallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ewallet.dao.EWalletJpaRepository;
import com.cg.ewallet.entity.User;
import com.cg.ewallet.exception.LoginException;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{

	@Autowired
	EWalletJpaRepository eWalletDao;
	
	public User doLogin(String userId,String password) throws LoginException {
		User user=eWalletDao.getOne(userId);
		//User user= eWalletDao.viewUser(userId);
		
		if(user!=null && user.getUserPassword().contentEquals(password)) {
			return user;
		}
		
		throw new LoginException("You are not authenticated and authorized, Please Login Again with correct Password");
	}

	
	public String encryptUser(User user) {
		
		return encryptString(user.getUserId())+"-"+encryptString(user.getUserName());
	}
	
	public String encryptString(String str) {
		char[] arr = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		int ch ;
		for (int idx=0; idx < arr.length; ++idx) {
			ch = arr[idx]+3;
			sb.append((char)ch);
		}
		return sb.toString();
	}

}
