package com.group3.forgotPassword.DAO;

import com.group3.forgotPassword.DAO.*;

public class DAOInjector implements IDAOInjector {

	public static IDAOInjector daoInjector;
	public static IUserPasswordDAO userPasswordDAO;

	public static IDAOInjector instance() {
		if (null == daoInjector) {
			daoInjector = new DAOInjector();
		}
		return daoInjector;
	}

	public IUserPasswordDAO getUserDAOObj() {
		if (null == userPasswordDAO) {
			userPasswordDAO = new UserPasswordDAO();
		}
		return userPasswordDAO;
	}
}