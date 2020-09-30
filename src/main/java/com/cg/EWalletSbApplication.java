package com.cg;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.cg.ewallet.entity.User;

@SpringBootApplication
public class EWalletSbApplication {
	@Bean(name="authenticatemap")
	public Map<String,User> getAuthentication(){
		return new HashMap<>();
	}

	public static void main(String[] args) {
		SpringApplication.run(EWalletSbApplication.class, args);
	}

}
