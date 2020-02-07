package com.group3.DAO;

import com.group3.BusinessModels.LoginForm;

public interface ILoginDAO {
	
	public LoginForm getUserByEmail(String email);
	public String getRoleByEmail(String email);

}
