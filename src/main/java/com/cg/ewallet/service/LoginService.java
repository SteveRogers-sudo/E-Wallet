package com.cg.ewallet.service;


import com.cg.ewallet.entity.User;
import com.cg.ewallet.exception.LoginException;

public interface LoginService {
	public User doLogin(String userId,String password) throws LoginException;
	 public String encryptUser(User user);
}
