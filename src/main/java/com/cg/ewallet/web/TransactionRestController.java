package com.cg.ewallet.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ewallet.dao.EWalletDao;
import com.cg.ewallet.dto.TransactionForm;
import com.cg.ewallet.entity.User;
import com.cg.ewallet.exception.AccountException;
import com.cg.ewallet.exception.InsufficientException;
import com.cg.ewallet.service.AddUser;
import com.cg.ewallet.service.TransactionService;

@RestController
public class TransactionRestController {
	
	@Autowired
	TransactionService txnService;
	
	@Autowired
	AddUser addUserService;
	
	@Autowired
	EWalletDao eWalletDao;
	
	@CrossOrigin(origins = "http://localhost:4200")
/***********************************************************************************************************************************/
	@PostMapping("/transact")
	public String doTransaction(@RequestBody TransactionForm transactionForm) throws AccountException, InsufficientException {
		if(txnService.doTransaction(transactionForm.getFromUserId(), transactionForm.getToUserId(), transactionForm.getAmount())) {
			return "Transaction Completed !";
		}
		else {
			return "Transaction Interrupted";
		}
	}
	
/***********************************************************************************************************************************/
	
	@CrossOrigin
	@GetMapping("/viewuser/{userid}")
	public double viewUser(@PathVariable("userid") String userid) {
		User user=addUserService.viewUser(userid);
		System.out.println(user.getUserName());
		return user.getUserBalance();
	}
	
/***********************************************************************************************************************************/

	@GetMapping("/bankbalance/{accountNumber}")
	public String bankBalance(@PathVariable("accountNumber") long accountNumber) throws AccountException {
		String balance = txnService.bankBalance(accountNumber);
		
		return ""+balance;
	}
}
