package com.group3.Services;

import java.util.ArrayList;

import com.group3.BusinessModels.GuestModel;
import com.group3.DAO.IGrantInstructorAccessDAO;

public class GrantInstructorAccessService implements IGrantInstructorAccessService {
    
	private ArrayList<GuestModel> userList;
	private IGrantInstructorAccessDAO iGrantInstructorAccessDAO;
	public GrantInstructorAccessService(IGrantInstructorAccessDAO iGrantInstructorAccessDAO) {
		this.iGrantInstructorAccessDAO = iGrantInstructorAccessDAO;
		userList = new ArrayList<>();
	}
	@Override
	public ArrayList<GuestModel> returnUserList() {
		// TODO Auto-generated method stub
		userList = this.iGrantInstructorAccessDAO.returnEligibleUsersList();
		
		return userList;
	}

}
