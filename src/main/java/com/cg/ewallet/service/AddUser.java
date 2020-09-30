package com.cg.ewallet.service;

import com.cg.ewallet.dto.UserForm;
import com.cg.ewallet.entity.User;

public interface AddUser {
	
	public String addUser(UserForm userform);
	public User viewUser(String userId);

}
