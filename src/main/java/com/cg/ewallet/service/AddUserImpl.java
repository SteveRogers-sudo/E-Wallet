package com.cg.ewallet.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ewallet.dao.EWalletJpaRepository;
import com.cg.ewallet.dto.UserForm;
import com.cg.ewallet.entity.User;

@Service
@Transactional
public class AddUserImpl implements AddUser{
	
	@Autowired
	EWalletJpaRepository eWalletDao;

	@Override
	public String addUser(UserForm userform) {
		
		User user=new User();
		LocalDateTime now = LocalDateTime.now();
		String userid=""+now.getYear() + now.getMonthValue() +now.getDayOfMonth()+now.getHour()+now.getMinute()+now.getSecond();		
		user.setUserBalance(0);
		user.setUserId(userid);
		user.setUserName(userform.getUserName());
		user.setUserPassword(userform.getPassword());
		user.setUserContact(userform.getUserContact());
		user.setUserEmail(userform.getUserEmail());
		user.setUserDob(userform.getUserDob());
		
		//eWalletDao.addUser(user);
		eWalletDao.save(user);
		
		return "Success";
	}
	
	@Override
	public User viewUser(String userId) {
		User user=eWalletDao.getOne(userId);
		return user;
	}

}
