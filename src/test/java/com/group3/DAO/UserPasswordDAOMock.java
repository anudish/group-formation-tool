package com.group3.DAO;

import com.group3.BusinessModels.GuestModel;

public class UserPasswordDAOMock implements IUserPasswordDAO{

	static GuestModel model = null;
	public static GuestModel modelTest2 = null;
	
	public UserPasswordDAOMock() {

		model = new GuestModel();
		model.setFirstName("John");
		model.setLastName("Wick");
		model.setUserRole("Guest");
		model.setEmail("jwick@dal.ca");
		model.setEncryptedPassword("Ilovedogs@1234");
		
		modelTest2 = new GuestModel();
		modelTest2.setFirstName("Tony");
		modelTest2.setLastName("Stark");
		modelTest2.setUserRole("Guest");
		modelTest2.setEmail("tstark@dal.ca");
		modelTest2.setEncryptedPassword("Jarvis@1234");
		
	}
	
	@Override
	public boolean isUserExist(String email) {

		if(model.getEmail().equals(email)) {
			return true;
		}
		
		return false;
	}

	@Override
	public void updateNewPassword(String email, String password) {

		if(model.getEmail().equals(email)) {
			model.setEncryptedPassword(password);
		}else if(modelTest2.getEmail().equals(email)) {
			model.setEncryptedPassword(password);
		}
		
	}

}
