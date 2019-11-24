package com.ujwal.model;

public class AuthToken {

	String userName;
	String token;
	int userType;
	
	public AuthToken() {
		// for JSON
	}

	public AuthToken(String userName, int userType, String token) {
		super();
		this.userName = userName;
		this.userType = userType;
		this.token = token;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
