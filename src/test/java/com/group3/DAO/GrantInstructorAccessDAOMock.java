package com.group3.DAO;

import java.util.ArrayList;

import com.group3.BusinessModels.GuestModel;

public class GrantInstructorAccessDAOMock implements IGrantInstructorAccessDAO {
    ArrayList<GuestModel> userDataSet;
    public GrantInstructorAccessDAOMock() {
    	userDataSet = new ArrayList<>();
		GuestModel data =  new GuestModel();
		data.setEmail("john@dal.ca");
		data.setFirstName("John");
		data.setLastName("Kellog");
		data.setUserRole("Guest");
		userDataSet.add(data);
		
		data.setEmail("vlado@dal.ca");
		data.setFirstName("Vlado");
		data.setLastName("Keslji");
		data.setUserRole("instructor");
		userDataSet.add(data);
		
		data.setEmail("robert@dal.ca");
		data.setFirstName("Robert");
		data.setLastName("Hawkey");
		data.setUserRole("instructor");
		userDataSet.add(data);
    	
    }
	@Override
	public ArrayList<GuestModel> returnEligibleUsersList() {
		
		
		return userDataSet;
	}

}
