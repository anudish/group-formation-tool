package com.group3.login.DAO;

import com.group3.login.DAO.*;

public class DAOAbstractFactory implements IDAOAbstractFactory {

	public static IDAOAbstractFactory daoInjector;
	public static ILoginDAO loginDAO;

	public static IDAOAbstractFactory instance() {
		if (null == daoInjector) {
			daoInjector = new DAOAbstractFactory();
		}
		return daoInjector;
	}

	@Override
	public ILoginDAO createLoginDAO() {
		if (null == loginDAO) {
			loginDAO = new LoginDao();
		}
		return new LoginDao();
	}

}