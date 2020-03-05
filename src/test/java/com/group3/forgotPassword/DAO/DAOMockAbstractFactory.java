package com.group3.forgotPassword.DAO;

public class DAOMockAbstractFactory implements IDAOAbstractFactory {

	public static IDAOAbstractFactory daoInjector;
	public static IUserPasswordDAO userPasswordDAO;

	public static IDAOAbstractFactory instance() {
		if (null == daoInjector) {
			daoInjector = new DAOMockAbstractFactory();
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