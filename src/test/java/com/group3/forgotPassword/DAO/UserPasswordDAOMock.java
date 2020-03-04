package com.group3.forgotPassword.DAO;

import com.group3.BusinessModels.GuestModel;
import com.group3.forgotPassword.DAO.IUserPasswordDAO;

public class UserPasswordDAOMock implements IUserPasswordDAO {

	public static GuestModel model = null;

	public UserPasswordDAOMock() {

		model = new GuestModel();
		model.setFirstName("John");
		model.setLastName("Wick");
		model.setUserRole("Guest");
		model.setEmail("jwick@dal.ca");
		model.setEncryptedPassword("Ilovedogs@1234");

		model.setFirstName("Tony");
		model.setLastName("Stark");
		model.setUserRole("Guest");
		model.setEmail("tstark@dal.ca");
		model.setEncryptedPassword("Jarvis@1234");
	}

	@Override
	public boolean isUserExist(String email) {

		if (model.getEmail().equals(email)) {
			return true;
		}
		return false;
	}

	@Override
	public void updateNewPassword(String email, String password) {

		if (model.getEmail().equals(email)) {
			model.setEncryptedPassword(password);
		} else if (model.getEmail().equals(email)) {
			model.setEncryptedPassword(password);
		}
	}
}