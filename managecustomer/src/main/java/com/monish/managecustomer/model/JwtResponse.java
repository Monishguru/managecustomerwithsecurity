package com.monish.managecustomer.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JwtResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4748524377283599477L;
	
	private final String jwtToken;
	

}
