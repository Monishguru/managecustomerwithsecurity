package com.monish.managecustomer.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.monish.managecustomer.service.JwtUserDetailsService;
import com.monish.managecustomer.util.JwtTokenUtil;

public class JwtRequestFilter extends OncePerRequestFilter {
	
	@Autowired
	JwtTokenUtil tokenUtil;
	
	@Autowired
	JwtUserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName =null;
		String jwtToken =null;
		
				
		final String requrstTokenHeader = request.getHeader("Authorization");
		if(requrstTokenHeader !=null && requrstTokenHeader.startsWith("Bearer")) {
			jwtToken = requrstTokenHeader.substring(7);
			  userName= tokenUtil.getUserName(jwtToken);
			
		}
		
		if(userName !=null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetail = this.userDetailsService.loadUserByUsername(userName);
			if(tokenUtil.validateJwtToken(jwtToken, userDetail)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetail, null,userDetail.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		filterChain.doFilter(request, response);
	}

}
