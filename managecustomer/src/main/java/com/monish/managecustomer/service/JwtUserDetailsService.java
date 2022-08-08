package com.monish.managecustomer.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class JwtUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		// hit the database , get the information for the user
		//hit the ldap system ,get the information 
		// hit an external usermanagement service and get the user information 
		
		
		// testpassword has been encrypted using https://www.javainuse.com/onlineBcrypt
		if("Monish".equals(username)) {
			return new User("Monish","$2a$10$ykfrklzv6CBHo/q9LOIEK..FZPABVT1zSPwJG48pjAJitl3Bgb3iu",new ArrayList<>());
		}
		else {
			throw new UsernameNotFoundException("User Not Signed Up ");
		}
	}

}
