package com.group3.AdminAndAuthorization.DAO;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

import com.group3.AdminAndAuthorization.DAO.IGrantInstructorAccessDAO;
import com.group3.BusinessModels.GuestModel;
import com.group3.DBConnectivity.ObtainDataBaseConnection;
import com.group3.course.DAO.CourseDAO;

public class GrantInstructorAccessDAO implements IGrantInstructorAccessDAO {
	Connection connection;
	PreparedStatement statement;
	GuestModel guestModel;
	ArrayList<GuestModel> userHolder;
	String query;

	private static Logger logger = LogManager.getLogger(GrantInstructorAccessDAO.class);

	public GrantInstructorAccessDAO() {
		userHolder = new ArrayList<>();
	}

	@Override
	public ArrayList<GuestModel> returnEligibleUsersList() {
		ResultSet resultset;
		query = "select *From " + "USER_DATABASE" + " where ROLE = ? OR ROLE = ? ";
		connection = ObtainDataBaseConnection.obtainDatabaseConnection();

		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, "GUEST");
			statement.setString(2, "INSTRUCTOR");
			resultset = statement.executeQuery();

			if (resultset.next() == false) {
				logger.info("No Instructor or guest users");
			} else {
				resultset.previous();
				while (resultset.next()) {
					guestModel = new GuestModel();
					guestModel.setFirstName(resultset.getString("FIRST_NAME"));
					guestModel.setLastName(resultset.getString("LAST_NAME"));
					guestModel.setEmail(resultset.getString("MAIL_ID"));
					guestModel.setUserRole(resultset.getString("ROLE"));

					userHolder.add(guestModel);
				}
			}
		}

		catch (SQLException e) {
			logger.error(e);
		}

		finally {
			ObtainDataBaseConnection.terminateConnection();
		}

		return userHolder;
	}
}