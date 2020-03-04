package com.group3.signup.DAO;

public class DAOMockInjector implements IDAOInjector {

	public static IDAOInjector daoInjector;
	public static IUserDAO userDAO;

	public static IDAOInjector instance() {
		if (null == daoInjector) {
			daoInjector = new DAOMockInjector();
		}
		return daoInjector;
	}

	@Override
	public IUserDAO createUserDAO() {
		if (null == userDAO) {
			userDAO = new UserDAOMock();
		}
		return userDAO;
	}

}