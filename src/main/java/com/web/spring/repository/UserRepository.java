package com.web.spring.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.web.spring.model.User;

@Repository
public class UserRepository {

	private static Map<Long, User> userMap = new HashMap<>();

	static {

		User userInfo = new User();
		userInfo.setId(new Long(100));
		userInfo.setFirstName("Avanesh");
		userInfo.setLastName("Sharma");
		userInfo.setLoginName("admin");
		userInfo.setDesignation("Project Leader");
		// userInfo.setPassword("admin@123");
		userInfo.setPassword("$2a$10$GjC.lkgIz7QoG/GXwMZk1Od6CEoGriQ5FEzPB5dTQQmOtXmIW10TC");// "admin@123"
		userInfo.setSalary(new Long(2000));
		userInfo.setCity("Greater Noida");
		userMap.put(userInfo.getId(), userInfo);

		userInfo = new User();
		userInfo.setId(new Long(101));
		userInfo.setFirstName("Dummy");
		userInfo.setLastName("Sharma");
		userInfo.setLoginName("dummy");
		userInfo.setDesignation("Project Leader");
		// userInfo.setPassword("dummy");
		userInfo.setPassword("$2a$10$0H/djIsU.m6CrdRnn1QmmeJm14QciEl9OnnfgUeJ2FFuT7joGClda");// "dummy"
		userInfo.setSalary(new Long(2500));
		userInfo.setCity("Greater Noida");
		userMap.put(userInfo.getId(), userInfo);

	}

	public User getUserById(Long userId) {

		List<User> userList = userMap.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
		User user = userList.stream().filter(e -> e.getId().equals(userId)).collect(Collectors.toList()).get(0);
		System.out.println("User found--> " + user.getFirstName() + " " + user.getLastName());
		return user;

	}

	public List<User> getAllUsers() {

		return userMap.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
	}

}
