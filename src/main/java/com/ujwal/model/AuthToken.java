package com.ujwal.model;

public class AuthToken {

	String username;
	String token;
	int userType;
	
	public AuthToken() {
		// for JSON
	}

	public AuthToken(String username, int userType, String token) {
		super();
		this.username = username;
		this.userType = userType;
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}
	
}
