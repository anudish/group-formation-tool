package com.group3.signup.DAO;

import java.util.ArrayList;

import com.group3.BusinessModels.GuestModel;
import com.group3.signup.DAO.IUserDAO;

public class UserDAOMock implements IUserDAO {

	public static ArrayList<GuestModel> userList = new ArrayList<GuestModel> ();

	public UserDAOMock() {

		GuestModel model = new GuestModel();
		model.setFirstName("Anudish");
		model.setLastName("Jain");
		model.setUserRole("Guest");
		model.setEmail("anjain@gmail.com");
		model.setEncryptedPassword("GetMeRight@1234");
		userList.add(model);
	}

	@Override
	public boolean getSignUpDetailsofUser(GuestModel guestModel) {

		boolean checkUniqueUser = true;
		for (GuestModel model: userList) {
			if (model.getEmail().equals(guestModel.getEmail())) {
				checkUniqueUser = false;
				break;
			}
		}
		if (checkUniqueUser) {
			userList.add(guestModel);
		}
		return checkUniqueUser;
	}
}