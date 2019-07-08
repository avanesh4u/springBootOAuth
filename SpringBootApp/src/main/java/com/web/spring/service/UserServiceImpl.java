package com.web.spring.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.web.spring.model.User;
import com.web.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User getUserById(Long userId) {
		return userRepo.getUserById(userId);
	}

	@Override
	public User updateUserInfo(User userInfo) {
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = getUserByName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()), user.getPassword(),
				getAuthority());

	}

	private User getUserByName(String userName) {					
    	
		User user = userRepo.getAllUsers().stream().filter(u -> u.getLoginName().equals(userName)).collect(Collectors.toList()).get(0);
		
		return user;
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

}
