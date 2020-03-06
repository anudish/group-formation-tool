package com.group3.AdminAndAuthorization.DAO;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.*;

import com.group3.BusinessModels.Guest;
import com.group3.DBConnectivity.ObtainDataBaseConnection;

public class GrantInstructorAccessDAO implements IGrantInstructorAccessDAO {
	Connection connection;
	PreparedStatement statement;
	Guest guest;
	ArrayList<Guest> userHolder;
	String query;

	private static Logger logger = LogManager.getLogger(GrantInstructorAccessDAO.class);

	public GrantInstructorAccessDAO() {
		userHolder = new ArrayList<>();
	}

	@Override
	public ArrayList<Guest> returnEligibleUsersList() {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
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
					guest = new Guest();
					guest.setFirstName(resultset.getString("FIRST_NAME"));
					guest.setLastName(resultset.getString("LAST_NAME"));
					guest.setEmail(resultset.getString("MAIL_ID"));
					guest.setUserRole(resultset.getString("ROLE"));

					userHolder.add(guest);
				}
			}
		}

		catch (SQLException e) {
			logger.log(Level.ERROR, e.getMessage());
		}finally {
			ObtainDataBaseConnection.terminateConnection();
		}

		return userHolder;
	}
}