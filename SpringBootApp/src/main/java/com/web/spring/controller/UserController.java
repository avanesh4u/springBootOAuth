package com.web.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.model.User;
import com.web.spring.service.IUserService;

@RestController
@RequestMapping("/user/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	
	@GetMapping(path="/{userId}", produces = "application/json")
	public User getUserById (@PathVariable("userId") String userId) {
		
		return userService.getUserById(Long.parseLong(userId));
		
	}
	
	

}
