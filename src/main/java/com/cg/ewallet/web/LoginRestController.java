package com.cg.ewallet.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ewallet.dto.LoginForm;
import com.cg.ewallet.entity.User;
import com.cg.ewallet.exception.LoginException;
import com.cg.ewallet.service.LoginService;

@RestController
public class LoginRestController {
	
	@Autowired
	@Qualifier("authenticatemap")
	private Map<String, User> authMap;
	
	@Autowired
	public LoginService loginService;
	
	@CrossOrigin
	@PostMapping("/login")
	public String getLogin(@RequestBody LoginForm loginForm) throws LoginException {
			System.out.println("login"+loginForm.getUserid());
			User user=loginService.doLogin(loginForm.getUserid(), loginForm.getPassword());
			String token=loginService.encryptUser(user);
			authMap.put(token, user);
			return token;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest req) {
		String token=req.getHeader("userId");
		authMap.remove(token);
		return "logged out";
	}
	
	@CrossOrigin
	@GetMapping("/forgetpassword/{custid}")
	public String m(@PathVariable("custid") String custId) {
		return custId;
	}
	
	
}
