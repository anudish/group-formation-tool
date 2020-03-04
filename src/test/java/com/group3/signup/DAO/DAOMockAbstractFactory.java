package com.group3.signup.DAO;

public class DAOMockAbstractFactory implements IDAOAbstractFactory {

	public static IDAOAbstractFactory daoInjector;
	public static IUserDAO userDAO;

	public static IDAOAbstractFactory instance() {
		if (null == daoInjector) {
			daoInjector = new DAOMockAbstractFactory();
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