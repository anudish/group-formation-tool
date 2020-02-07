package com.group3.login;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.group3.BusinessModels.LoginForm;
import com.group3.DAO.LoginDao;

@Service
public class UserService implements UserDetailsService {

	@SuppressWarnings("deprecation")
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		// get email and password object from dao
		LoginDao ld = new LoginDao();
		LoginForm user = ld.getUserByEmail(email);

		if (user == null) {
			throw new UsernameNotFoundException(email);
		}

		else {
			System.out.println("email " + user.getEmail());
			System.out.println("password " + user.getPassword());

			UserDetails userDetailsUser = null;
			if (user.getEmail().equals("admin@dal.ca")) {
				userDetailsUser = User.withDefaultPasswordEncoder()
						.username(user.getEmail()).password(user.getPassword()).roles("ADMIN").build();
			}

			else {
				userDetailsUser = User.withDefaultPasswordEncoder()
						.username(user.getEmail()).password(user.getPassword()).roles("USER").build();
			}

			return userDetailsUser;
		}

	}

}
