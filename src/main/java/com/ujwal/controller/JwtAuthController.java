package com.ujwal.controller;

import static com.ujwal.config.Constants.TOKEN_PREFIX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ujwal.config.JwtTokenUtil;
import com.ujwal.model.ApiResponse;
import com.ujwal.model.AuthToken;
import com.ujwal.model.LoginUser;
import com.ujwal.model.User;
import com.ujwal.service.UserService;

@RestController
public class JwtAuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/authenticate")
	public ApiResponse<AuthToken> authenticate(@RequestBody LoginUser loginUser) throws AuthenticationException {
		
		final String userName = loginUser.getUsername(); 
        authenticate(userName, loginUser.getPassword());
        final User user = userService.findOne(userName);
        final String token = jwtTokenUtil.generateToken(user);
        return new ApiResponse<>(200, "success",new AuthToken(userName, TOKEN_PREFIX + token));
    }

	private void authenticate(String userName, String password) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
		
	}
}
