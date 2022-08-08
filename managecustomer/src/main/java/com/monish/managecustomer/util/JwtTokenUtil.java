package com.monish.managecustomer.util;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8428432008151803055L;
	
	@Value("${jwt.secret}")
	private String secret;
	
	//generate token
	public String generateToken(Map<String,Object> claimsInfo,String subject) {
		return Jwts.builder().setClaims(claimsInfo).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis()+100000)).setIssuer("CUSTOMERSERVICE").signWith(SignatureAlgorithm.HS512, secret).compact();
		 
	}
	
	//validate token
	
	public boolean validateJwtToken(String token,UserDetails userInformation) {
		String userName = getUserName(token);
		return (userName.equals(userInformation.getUsername()) && !isTokenExpired(token));
	}
	
	//is token expired
	private boolean isTokenExpired(String token) {
		
		return getExpiryForToken(token).before(new Date());
		
	}
	
	//get Expiration date from token
	
	public Date getExpiryForToken(String token) {
		Claims claimsInformation = decodeTokenAndGetClaims(token);
		return claimsInformation.getExpiration();
		
	}
	
	
	
	//get username from token
	
	public String getUserName(String token) {
		Claims claimsInformation = decodeTokenAndGetClaims(token);
		return claimsInformation.getSubject();
		
	}
	
	// decodeTokenand get information
	private Claims decodeTokenAndGetClaims(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		
	}

}
