package com.group3.forgotPassword.DAO;

import com.group3.forgotPassword.DAO.*;

public class DAOMockInjector implements IDAOInjector {

	public static IDAOInjector daoInjector;
	public static IUserPasswordDAO userPasswordDAO;

	public static IDAOInjector instance() {
		if (null == daoInjector) {
			daoInjector = new DAOMockInjector();
		}
		return daoInjector;
	}
	
	@Override
	public IUserPasswordDAO getUserDAOObj() {
		if (null == userPasswordDAO) {
			userPasswordDAO = new UserPasswordDAOMock();
		}
		return userPasswordDAO;
	}

}