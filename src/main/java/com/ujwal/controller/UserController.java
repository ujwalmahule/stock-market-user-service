package com.ujwal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ujwal.exception.UserError;
import com.ujwal.model.User;
import com.ujwal.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return repository.findAll();
	}
	
	@PostMapping("/createAdmin")
	public User createAdmin(@Valid @RequestBody User user) {
		return createUser(user, 0);
	}
	
	@PostMapping("/signup")
	public User signup(@Valid @RequestBody User user) {
		return createUser(user, 1);
	}

	private User createUser(User user, int userType) {
		repository.findByEmail(user.getEmail()).ifPresent(foundUser -> {throw new UserError("User", "Please choose a different email");});
		repository.findByUsername(user.getUsername()).ifPresent(foundUser -> {throw new UserError("User", "Please choose a different username");});
		//by default the user is deactivated and admin is active
		user.setActive(userType==0);
		user.setUserType(userType);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return repository.save(user);
	}
}
