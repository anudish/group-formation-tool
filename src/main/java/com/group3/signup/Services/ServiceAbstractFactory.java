package com.group3.signup.Services;

import com.group3.signup.DAO.*;

public class ServiceAbstractFactory implements IServiceAbstractFactory {

	public static IServiceAbstractFactory serviceInjector;
	public static IUserDetailsService userDetailsService;

	public static IServiceAbstractFactory instance() {
		if (null == serviceInjector) {
			serviceInjector = new ServiceAbstractFactory();
		}
		return serviceInjector;
	}

	@Override
	public IUserDetailsService creatUserDetailsService(IUserDAO userDAO) {
		if (null == userDetailsService) {
			userDetailsService = new UserDetailsService(userDAO);
		}
		return userDetailsService;
	}
}