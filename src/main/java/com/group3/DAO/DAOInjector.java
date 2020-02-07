package com.group3.DAO;


public class DAOInjector implements IDAOInjector{
	public IUserPasswordDAO getUserDAOObj()
	{
		return new UserPasswordDAO();
	}
}
