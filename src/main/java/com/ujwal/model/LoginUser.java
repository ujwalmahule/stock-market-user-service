package com.ujwal.model;

import java.io.Serializable;

public class LoginUser implements Serializable {

	private static final long serialVersionUID = -654167352334307048L;

	private String username;
	private String password;
	
	public LoginUser() {
		// TODO Auto-generated constructor stub
	}
	
	public LoginUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
