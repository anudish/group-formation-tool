package com.group3.DAO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserRoleHandlerDAOTest {
	IUserRoleHandlerDAO iUserRoleHandlerDAO;
	String mailId,role,switchedRole;
	@BeforeEach
	void setUp() throws Exception {
		iUserRoleHandlerDAO = new DAOInjector().createUserRoleHandlerDAO();
		switchedRole = "Instructor";
	}

	

	@Test
	final void testUpdateUserRole() {
		mailId = "dwane123@dal.ca";
		role = this.iUserRoleHandlerDAO.returnUserRole(mailId);
		
		
		
		assertFalse(this.iUserRoleHandlerDAO.updateUserRole(role, mailId).isEmpty());
	    assertTrue(this.iUserRoleHandlerDAO.updateUserRole(role, mailId).length() > 0);
	}

	@Test
	final void testReturnUserRole() {
		 mailId= "joe.root@dal.ca";
		 role = this.iUserRoleHandlerDAO.returnUserRole(mailId);
		 assertFalse(role.equalsIgnoreCase("TA"));
		 
		 assertTrue(role.equalsIgnoreCase("Instructor")||role.equalsIgnoreCase("Guest"));
	}

}
