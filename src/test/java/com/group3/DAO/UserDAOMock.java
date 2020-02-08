package com.group3.DAO;

import java.util.ArrayList;
import com.group3.DAO.IUserDAO;
import com.group3.BusinessModels.GuestModel;

public class UserDAOMock implements IUserDAO {

	static ArrayList<GuestModel> userList = new ArrayList<GuestModel>();

	public UserDAOMock() {
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		Boolean checkUniqueUser = true;

		for (GuestModel model : userList) {
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
