package com.group3.signup.Services;

import com.group3.signup.DAO.IUserDAO;

public interface IServiceAbstractFactory {
	public IUserDetailsService creatUserDetailsService(IUserDAO userDAO);
}
