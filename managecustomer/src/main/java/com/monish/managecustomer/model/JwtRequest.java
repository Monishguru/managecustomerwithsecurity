package com.monish.managecustomer.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JwtRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3266632444202560307L;
	
	private String username;
	private String password;

}
