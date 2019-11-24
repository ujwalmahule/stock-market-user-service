package com.ujwal.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ujwal.model.User;
import com.ujwal.repository.UserRepository;
import com.ujwal.service.UserService;
import com.ujwal.user.exception.ResourceNotFoundException;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Invalid username or password."));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isActive(), true, true, true, getRoles(user)); 
	}

	@Override
	public User findOne(String username) {
		return userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
	}

	private List<GrantedAuthority> getRoles(User user) {
    	return Arrays.asList(new SimpleGrantedAuthority("ROLE_" + user.getUserType()));
	}
}
