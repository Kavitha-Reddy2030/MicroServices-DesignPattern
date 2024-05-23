package com.thbs.UserService.Service;

import java.util.List;

import com.thbs.UserService.Entity.User;

public interface UserService {

	List<User> getAllUsers();
	User getUserById(Integer userId);
	void addUser(User user);
	void deleteUserById(Integer userId);
	void updateUser(Integer userId, User updateUser);
	
}
