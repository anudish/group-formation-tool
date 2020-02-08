package com.group3.DAO;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group3.BusinessModels.GuestModel;


class GrantInstructorAccessDAOTest {
	 ArrayList<GuestModel> accessUserlist;
	 IGrantInstructorAccessDAO iGrantInstructorAccessDAO;
	 GuestModel falseUser,trueUser;
	@BeforeEach
	void setUp() throws Exception {
	   
		accessUserlist = new ArrayList<>();
		iGrantInstructorAccessDAO = new DAOInjector().createGrantInstructorAccessDAO();
		falseUser = new GuestModel();
		falseUser.setEmail("AtalVajpayee@dal.ca");
		falseUser.setFirstName("Atal");
		falseUser.setLastName("Vajpayee");
		falseUser.setUserRole("Guest");
		
		trueUser = new GuestModel();
		trueUser.setFirstName("Joe");
		trueUser.setLastName("Root");
		trueUser.setEmail("joe.root@dal.ca");
	}

	

	@Test
	final void testReturnEligibleUsersList() {
		 accessUserlist = this.iGrantInstructorAccessDAO.returnEligibleUsersList();
	     for(GuestModel user:accessUserlist) {
	    	 
	    	 assertFalse(falseUser.getEmail().equals(user.getEmail()));
	    	 
	    	 if(trueUser.getEmail().equals(user.getEmail())) {
	    		 
	    		 assertTrue(trueUser.getFirstName().equals(user.getFirstName()));
	    	 }
	    	 
	     }
	}

}
