package com.group3.signup.DAO;

import com.group3.signup.DAO.*;

public class DAOInjector implements IDAOInjector {

	public static IDAOInjector daoInjector;
	static IUserDAO userPasswordDAO;

	public static IDAOInjector instance() {
		if (null == daoInjector) {
			daoInjector = new DAOInjector();
		}
		return daoInjector;
	}

	public IUserDAO createUserDAO() {
		if (null == userPasswordDAO) {
			userPasswordDAO = new UserDAO();
		}
		return userPasswordDAO;
	}
}