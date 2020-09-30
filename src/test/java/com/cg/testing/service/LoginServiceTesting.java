package com.cg.testing.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.ewallet.dao.EWalletJpaRepository;
import com.cg.ewallet.entity.User;
import com.cg.ewallet.exception.LoginException;
import com.cg.ewallet.service.LoginService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceTesting {
	
	@Autowired
	private LoginService loginService;
	
	@MockBean
	private EWalletJpaRepository eWalletDao;
	
	public User user;
	
	@BeforeEach
	public void beforeTest() {
		
		user=new User();
		user.setUserBalance(45);
		user.setUserContact("8847553354");
		user.setUserDob(LocalDate.of(1997, 12, 29));
		user.setUserEmail("yogeshupadhyay1229@gmail.com");
		user.setUserName("Jogesh");
		user.setUserPassword("jogesh@123");
		user.setUserId("2020920212241");
		
	}
	  
	//correct username and password
	@Test
	public void doLoginTest() throws LoginException {
		
		when(eWalletDao.getOne("2020920212241")).thenReturn(user);
	
		assertEquals(user,loginService.doLogin("2020920212241", "jogesh@123"));
	}
	
	//wrong password
	@Test
	public void doLoginTest1() throws LoginException {
		
		when(eWalletDao.getOne("2020920212241")).thenReturn(user);
		
		Assertions.assertThrows(LoginException.class,()->{loginService.doLogin("2020920212241", "jogesh");});
		
		
	}


}
