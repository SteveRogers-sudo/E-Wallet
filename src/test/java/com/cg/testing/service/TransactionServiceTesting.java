package com.cg.testing.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.ewallet.dao.EWalletTransactionJpaRepository;
import com.cg.ewallet.entity.Transaction;
import com.cg.ewallet.entity.User;
import com.cg.ewallet.exception.AccountException;
import com.cg.ewallet.exception.InsufficientException;
import com.cg.ewallet.service.TransactionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionServiceTesting {

	@Autowired
	private TransactionService txnService;
	
	@MockBean
	private EWalletTransactionJpaRepository eRepo;
	
	public Transaction transaction;
	
	public User user;
	public User user1;
	
	@BeforeEach
	public void beforeTest() {
		
		transaction=new Transaction();
		transaction.setTransaccountId(10);
		transaction.setTransType("Credit");
		transaction.setTransAmount(500);
		transaction.setTransDate(LocalDate.of(2020, 9, 20));
		
		user1=new User();
		user.setUserBalance(500.0);
		user.setUserContact("1234567890");
		user.setUserDob(LocalDate.of(1998, 2, 28));
		user.setUserEmail("bdas1683@gmail.com");
		user.setUserName("Bishal");
		user.setUserPassword("1234");
		user.setUserId("202092431111");
		
		user=new User();
		user.setUserBalance(1000.0);
		user.setUserContact("9876543210");
		user.setUserDob(LocalDate.of(1997, 12, 31));
		user.setUserEmail("yogeshupadhyay1229@gmail.com");
		user.setUserName("Yogesh");
		user.setUserPassword("4321");
		user.setUserId("20209243947");
	}
	
	@Test
	public void doTransactionTest() throws AccountException, InsufficientException {
		
		when(eRepo.getOne((long) 10)).thenReturn(transaction);
		
		assertEquals(transaction, txnService.doTransaction("20209243947", "202092431111", 500));
	}
	
	@Test
	public void doTransactionTest2() throws AccountException, InsufficientException {
		
		when(eRepo.getOne((long) 10)).thenReturn(transaction);
		
		Assertions.assertThrows(AccountException.class, ()->{txnService.doTransaction("11111111111", "202092431111", 500);});
	}
	
	
}
