package com.group3.AdminAndAuthorization.Services;
import com.group3.AdminAndAuthorization.DAO.IGrantInstructorAccessService;
import com.group3.BusinessModels.GuestModel;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import com.group3.AdminAndAuthorization.DAO.DAOMockInjector;
import com.group3.AdminAndAuthorization.DAO.IDAOInjector;
import com.group3.Services.ServiceInjector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import com.group3.AdminAndAuthorization.DAO.IGrantInstructorAccessDAO;

class GrantInstructorAccessServiceTest {
	 IGrantInstructorAccessDAO  iGrantInstructorAccessDAO;
	 IGrantInstructorAccessService iGrantInstructorAccessService;
	 ArrayList<GuestModel> userDataSet;
	 
	@BeforeEach
	void setUp() throws Exception {
		iGrantInstructorAccessDAO = new DAOMockInjector().createGrantInstructorAccessDAO();
		iGrantInstructorAccessService = new ServiceInjector().createGrantInstructorAccessService(iGrantInstructorAccessDAO);
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

	

	@Test
	final void testReturnUserList() {
		ArrayList<GuestModel> userList = iGrantInstructorAccessService.returnUserList();
		for(int i=0; i<userList.size(); ++i) {
			
			GuestModel outcome = userList.get(i);
			GuestModel expectedOutcome = userDataSet.get(i);
			assertEquals(outcome.getEmail(),expectedOutcome.getEmail());
			assertEquals(outcome.getFirstName(),expectedOutcome.getFirstName());
			assertEquals(outcome.getLastName(),expectedOutcome.getLastName());
			assertEquals(outcome.getUserRole(),expectedOutcome.getUserRole());
		}
		
	}

}
