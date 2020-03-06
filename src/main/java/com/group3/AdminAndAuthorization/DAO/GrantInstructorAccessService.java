package com.group3.AdminAndAuthorization.DAO;

import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.group3.BusinessModels.Guest;

public class GrantInstructorAccessService implements IGrantInstructorAccessService {
	private static Logger logger = LogManager.getLogger(GrantInstructorAccessService.class);

	private ArrayList<Guest> userList;
	private IGrantInstructorAccessDAO grantInstructorAccessDAO;
	public GrantInstructorAccessService(IGrantInstructorAccessDAO grantInstructorAccessDAO) {
		this.grantInstructorAccessDAO = grantInstructorAccessDAO;
		userList = new ArrayList<>();
	}

	@Override
	public ArrayList<Guest> returnUserList() {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		try {
		userList = this.grantInstructorAccessDAO.returnEligibleUsersList();
		} catch (NullPointerException nl) {
			logger.error(nl.getMessage());
		}
		return userList;
	}
}