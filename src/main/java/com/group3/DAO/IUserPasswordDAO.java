package com.group3.DAO;

public interface IUserPasswordDAO {

	public boolean isUserExist(String email);
	public void updateNewPassword(String email,String password);
}
