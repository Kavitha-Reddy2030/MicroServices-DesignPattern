package com.thbs.UserService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thbs.UserService.Entity.User;
import com.thbs.UserService.ExceptionHandling.UserNotFoundException;
import com.thbs.UserService.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {

		return (List<User>) userRepository.findAll();
	}

	@Override
	public User getUserById(Integer userId) {
		
		Optional<User> userOpt = userRepository.findById(userId);
		if(userOpt.isPresent()) 
			return userOpt.get();
		else
			throw new UserNotFoundException("User not found with userId"+ userId);
	}

	@Override
	public void addUser(User user) {
		userRepository.save(user);

	}

	@Override
	public void deleteUserById(Integer userId) {
		User user = getUserById(userId);
		userRepository.delete(user);
	}

	@Override
	public void updateUser(Integer userId, User updateUser) {
		User user = getUserById(userId);
		user.setUserName(updateUser.getUserName());
		user.setEmailId(updateUser.getEmailId());
		user.setLocation(updateUser.getLocation());
		userRepository.save(user);
	}

}
