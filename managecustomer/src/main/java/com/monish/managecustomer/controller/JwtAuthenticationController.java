package com.monish.managecustomer.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.monish.managecustomer.model.JwtRequest;
import com.monish.managecustomer.model.JwtResponse;
import com.monish.managecustomer.service.JwtUserDetailsService;
import com.monish.managecustomer.util.JwtTokenUtil;

@RestController
public class JwtAuthenticationController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	
	@RequestMapping(value="/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) throws Exception {
		authenticateUser(authRequest.getUsername(),authRequest.getPassword());
		
		final String token =jwtTokenUtil.generateToken(new HashMap<String, Object>(), userDetailsService.loadUserByUsername(authRequest.getUsername()).getUsername());
		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticateUser(String username, String password) throws Exception{
		// TODO Auto-generated method stub
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}
		catch (DisabledException e) {
			throw new Exception("User Disabled",e);
		}
		
		catch (BadCredentialsException e) {
			throw new Exception("User password not right",e);
		}
		
		
	}

}
