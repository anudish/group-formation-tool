package com.group3.signup.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.group3.BusinessModels.GuestModel;
import com.group3.DBConnectivity.ObtainDataBaseConnection;

public class UserDAO implements IUserDAO {
	Connection connection;
	String query;
	PreparedStatement statement;

	private static Logger logger = LogManager.getLogger(UserDAO.class);

	public boolean getSignUpDetailsofUser(GuestModel guestModel) {

		boolean checkUser = false;
		String query;
		ResultSet result;

		try {
			connection = ObtainDataBaseConnection.obtainDatabaseConnection();
			query = "SELECT count(MAIL_ID) FROM USER_DATABASE WHERE MAIL_ID = '" + guestModel.getEmail() + "';";
			statement = connection.prepareStatement(query);

			result = statement.executeQuery();
			logger.info("SELECT QUERY EXECUTED");

			while (result.next()) {
				if (result.getString(1).compareTo("0") == 0) {
					logger.info("New User");
					checkUser = true;
				} else {
					logger.error("More than one users");
					checkUser = false;
				}
			}

			if (checkUser) {
				query = "INSERT INTO USER_DATABASE(LAST_NAME,FIRST_NAME,ROLE,MAIL_ID) VALUES (?, ?, ?, ?);";
				statement = connection.prepareStatement(query);
				statement.setString(1, guestModel.getLastName());
				statement.setString(2, guestModel.getFirstName());
				statement.setString(3, guestModel.getUserRole());
				statement.setString(4, guestModel.getEmail());
				statement.execute();
				logger.info("Inserted into User Database");

				query = "INSERT INTO AUTHENTICATION_DATABASE(MAIL_ID,PASSWORD) VALUES(?,?);";
				statement = connection.prepareStatement(query);
				statement.setString(1, guestModel.getEmail());
				statement.setString(2, guestModel.getEncryptedPassword());
				statement.execute();
				logger.info("Inserted into Authentication Database");
			}

			statement.close();
			connection.close();
		} catch (Exception e) {
			logger.error(e);
		}

		return checkUser;
	}
}