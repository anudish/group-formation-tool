package com.group3.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.group3.BusinessModels.GuestModel;
import com.group3.DBConnectivity.ObtainDataBaseConnection;

public class UserDAO implements IUserDAO {
	Connection conn;
	String sql;
	private static Logger logger = LogManager.getLogger(UserDAO.class);
	PreparedStatement statement;

	public boolean getSignUpDetailsofUser(GuestModel guestModel) {

		Boolean checkUser = false;

		try {
			conn = ObtainDataBaseConnection.obtainDatabaseConnection();

			String sql = "SELECT count(MAIL_ID) FROM USER_DATABASE WHERE MAIL_ID = '" + guestModel.getEmail() + "';";
			statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();
			logger.info("QUERY EXECUTED");
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
				String insertData = "INSERT INTO USER_DATABASE(LAST_NAME,FIRST_NAME,ROLE,MAIL_ID) VALUES (?, ?, ?, ?);";
				statement = conn.prepareStatement(insertData);
				statement.setString(1, guestModel.getLastName());
				statement.setString(2, guestModel.getFirstName());
				statement.setString(3, guestModel.getUserRole());
				statement.setString(4, guestModel.getEmail());

				// execute the preparedstatement
				statement.execute();
				logger.info("Inserted into User Database");
				String insertPass = "INSERT INTO AUTHENTICATION_DATABASE(MAIL_ID,PASSWORD) VALUES(?,?);";
				statement = conn.prepareStatement(insertPass);
				statement.setString(1, guestModel.getEmail());
				statement.setString(2, guestModel.getEncryptedPassword());
				statement.execute();
				logger.info("Inserted into Authentication Database");

			}
			statement.close();
			conn.close();

		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e);
		}
		return checkUser;
	}
}
