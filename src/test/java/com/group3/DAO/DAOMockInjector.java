package com.group3.DAO;

public class DAOMockInjector implements IDAOInjector {
	
	@Override
	public IUserPasswordDAO getUserDAOObj() {
		return new UserPasswordDAOMock();
	}
	
}
