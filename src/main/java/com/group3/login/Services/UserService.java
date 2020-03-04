package com.group3.login.Services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.group3.BusinessModels.LoginForm;
import com.group3.login.DAO.LoginDao;

@Service
public class UserService implements UserDetailsService {

	@SuppressWarnings("deprecation")
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		LoginDao ld = new LoginDao();
		LoginForm user = ld.getUserByEmail(email);
		UserDetails userDetailsUser;
		
		if (user == null) {
			throw new UsernameNotFoundException(email);
		} else {
			userDetailsUser = null;
			
			if (user.getEmail().equals("admin@dal.ca")) {
				userDetailsUser = User.withDefaultPasswordEncoder()
					.username(user.getEmail()).password(user.getPassword()).roles("ADMIN").build();
			} else {
				userDetailsUser = User.withDefaultPasswordEncoder()
					.username(user.getEmail()).password(user.getPassword()).roles("USER").build();
			}
			return userDetailsUser;
		}
	}
}