package com.ujwal.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ujwal.model.User;

public interface UserService extends UserDetailsService{

	User findOne(String userName);

}
