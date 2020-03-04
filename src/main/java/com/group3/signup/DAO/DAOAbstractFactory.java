package com.group3.signup.DAO;

import com.group3.signup.DAO.*;

public class DAOAbstractFactory implements IDAOAbstractFactory {

	public static IDAOAbstractFactory daoInjector;
	static IUserDAO userPasswordDAO;

	public static IDAOAbstractFactory instance() {
		if (null == daoInjector) {
			daoInjector = new DAOAbstractFactory();
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