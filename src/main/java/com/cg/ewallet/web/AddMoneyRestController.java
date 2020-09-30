package com.cg.ewallet.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ewallet.dto.AddMoneyForm;
import com.cg.ewallet.service.AddAmount;

@RestController
public class AddMoneyRestController {
	
	@Autowired
	AddAmount addAmountService;
	
	@CrossOrigin
	@PostMapping("/addmoney")
	public void addMoney(@RequestBody AddMoneyForm addMoneyForm) {
		
		addAmountService.addAmount(addMoneyForm.getUserid(), addMoneyForm.getAmount(), addMoneyForm.getAccountHolderName(), addMoneyForm.getAccountPin(), addMoneyForm.getAccountNumber());
		
	}

}
