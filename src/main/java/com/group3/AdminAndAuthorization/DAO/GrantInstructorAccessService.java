package com.group3.AdminAndAuthorization.DAO;

import java.util.ArrayList;

import com.group3.BusinessModels.GuestModel;

public class GrantInstructorAccessService implements IGrantInstructorAccessService {
    
	private ArrayList<GuestModel> userList;
	private IGrantInstructorAccessDAO iGrantInstructorAccessDAO;
	public GrantInstructorAccessService(IGrantInstructorAccessDAO iGrantInstructorAccessDAO) {
		this.iGrantInstructorAccessDAO = iGrantInstructorAccessDAO;
		userList = new ArrayList<>();
	}
	@Override
	public ArrayList<GuestModel> returnUserList() {

		userList = this.iGrantInstructorAccessDAO.returnEligibleUsersList();
		
		return userList;
	}

}
