package com.group3.login.Services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();
		http.cors();

		http.anonymous().and().authorizeRequests()
			.antMatchers("/", "/home", "/formSubmit", "/**").permitAll()
			.and()
			.formLogin()
			.loginPage("/login")
			.usernameParameter("email")
			.successHandler(myAuthenticationSuccessHandler())
			.permitAll()
			.and()
			.logout()
			.permitAll();
	}

	@Override
	public void configure(AuthenticationManagerBuilder builder)
	throws Exception {

		builder.userDetailsService(new UserService());
	}

	@Bean
	public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {

		return new LoginAuthenticationSuccessHandler();
	}

}