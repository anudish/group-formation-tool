package com.group3.Services;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group3.BusinessModels.GuestModel;
import com.group3.DAO.DAOMockInjector;
import com.group3.DAO.IInstructorHandlerDAO;
import com.group3.DAO.IUserRoleHandlerDAO;

class AdminPageServicesTest {
	private IInstructorHandlerDAO iInstructorHandlerDAO;
    private IUserRoleHandlerDAO  iUserRoleHandlerDAO;
    private IAdminPageServices iAdminPageServices ;
	@BeforeEach
	void setUp() throws Exception {
		iInstructorHandlerDAO = new DAOMockInjector().createInstructorHandlerDAO();
		iUserRoleHandlerDAO = new DAOMockInjector().createUserRoleHandlerDAO();
		
	}

	

	@Test
	final void testAlterUserRole() {
		//Already holding same Role
		GuestModel data =  new GuestModel();
		data.setEmail("john@dal.ca");
		data.setFirstName("John");
		data.setLastName("Kellog");
		data.setUserRole("Guest");
		String previousRole = data.getUserRole();
		String expectedOutcome =  data.getFirstName()+" "+data.getLastName()+" has already holds position for "+data.getUserRole();
		iAdminPageServices = new ServiceInjector().createAdminPageServices(iInstructorHandlerDAO, iUserRoleHandlerDAO, data, "None");
		assertTrue(iAdminPageServices.alterUserRole().equals(expectedOutcome));
		
		//Altering Role
		data.setUserRole("Instructor");
		iAdminPageServices = new ServiceInjector().createAdminPageServices(iInstructorHandlerDAO, iUserRoleHandlerDAO, data, "csci5608");
		expectedOutcome= data.getFirstName()+" "+data.getLastName()+" "+" switched their role from "+previousRole+" to "+data.getUserRole();
		assertTrue(iAdminPageServices.alterUserRole().equals(expectedOutcome));
		
		
		
		//check for same instructor in same course
		data.setEmail("robert@dal.ca");
		data.setFirstName("Robert");
		data.setLastName("Hawkey");
		data.setUserRole("Instructor");
		String CourseId = "CSCI7308";
		expectedOutcome = data.getFirstName()+" "+data.getLastName()+" "+"is already an instructor for the course "+CourseId;
		iAdminPageServices = new ServiceInjector().createAdminPageServices(iInstructorHandlerDAO, iUserRoleHandlerDAO, data, CourseId);
		assertTrue(iAdminPageServices.alterUserRole().equals(expectedOutcome));
	
	}

}
