package com.group3.login.DAO;

import com.group3.login.DAO.*;

public class DAOInjector implements IDAOInjector {

	public static IDAOInjector daoInjector;
	public static ILoginDAO loginDAO;

	public static IDAOInjector instance() {
		if (null == daoInjector) {
			daoInjector = new DAOInjector();
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