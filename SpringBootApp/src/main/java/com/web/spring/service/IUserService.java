package com.web.spring.service;

import com.web.spring.model.User;

public interface IUserService {

	public User getUserById(Long userId);
	
	public User updateUserInfo(User userInfo);
	
}
