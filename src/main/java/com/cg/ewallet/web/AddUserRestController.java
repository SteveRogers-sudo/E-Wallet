package com.cg.ewallet.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ewallet.dto.UserForm;
import com.cg.ewallet.service.AddUser;



@RestController
public class AddUserRestController {
	
	@Autowired
	public AddUser addUserService;
	
	@CrossOrigin
	@PostMapping("/adduser")
	public String addUser(@RequestBody UserForm userForm) {
		return addUserService.addUser(userForm);
	}

}
