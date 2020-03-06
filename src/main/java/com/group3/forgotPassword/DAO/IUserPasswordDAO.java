package com.group3.forgotPassword.DAO;

public interface IUserPasswordDAO {
	public boolean isUserExist(String email);

	public void updateNewPassword(String email, String password);
}
