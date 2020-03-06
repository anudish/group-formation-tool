package com.group3.AdminAndAuthorization.DAO;

import java.util.ArrayList;

import com.group3.BusinessModels.GuestModel;

public class GrantInstructorAccessService implements IGrantInstructorAccessService {
	private ArrayList<GuestModel> userList;
	private IGrantInstructorAccessDAO grantInstructorAccessDAO;

	public GrantInstructorAccessService(IGrantInstructorAccessDAO grantInstructorAccessDAO) {
		this.grantInstructorAccessDAO = grantInstructorAccessDAO;
		userList = new ArrayList<>();
	}

	@Override
	public ArrayList<GuestModel> returnUserList() {
		userList = this.grantInstructorAccessDAO.returnEligibleUsersList();
		return userList;
	}
}