package com.cg.ewallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler(value= {LoginException.class})
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public AccountMessage handlerException1(Exception ex) {
		return new AccountMessage(ex.getMessage());
	}
	
	@ExceptionHandler(value= {AccountException.class})
	public AccountMessage handlerException2(Exception ex) {
		return new AccountMessage(ex.getMessage());
	}
	
	@ExceptionHandler(value= {InsufficientException.class})
	public AccountMessage handlerException3(Exception ex) {
		return new AccountMessage(ex.getMessage());
	}
}
