package com.group3.AdminAndAuthorization.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.group3.DBConnectivity.ObtainDataBaseConnection;

public class UserRoleHandlerDAO implements IUserRoleHandlerDAO {

	private Connection connection;
	private static Logger logger = LogManager.getLogger(UserRoleHandlerDAO.class);

	public UserRoleHandlerDAO() {
		connection = ObtainDataBaseConnection.obtainDatabaseConnection();
	}

	@Override
	public String updateUserRole(String Role, String MaildId) {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		int rowsEffected = 0;
		String query = "UPDATE USER_DATABASE SET ROLE =? WHERE MAIL_ID = ? ";
		String feedBackMessage = new String();
		PreparedStatement preparestatement;

		try {
			preparestatement = connection.prepareStatement(query);
			logger.info("The role of the user is : " + Role);
			preparestatement.setString(1, Role);
			preparestatement.setString(2, MaildId);
			rowsEffected = preparestatement.executeUpdate();
		} catch (SQLException e) {
			logger.error(
					e.getMessage() + " The SQL State is :" + e.getSQLState() + ". Error Code : " + e.getErrorCode());
		} finally {
			ObtainDataBaseConnection.terminateConnection();

		}

		if (rowsEffected > 0) {
			feedBackMessage = "Role of user is altered to " + Role;
		}

		return feedBackMessage;

	}

	@Override
	public String returnUserRole(String MailId) {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		String Role = new String();
		String returnUserRoleQuery = "SELECT ROLE FROM USER_DATABASE WHERE MAIL_ID=?";
		PreparedStatement preparestatement;

		try {
			preparestatement = ObtainDataBaseConnection.obtainDatabaseConnection()
					.prepareStatement(returnUserRoleQuery);
			preparestatement.setString(1, MailId);
			ResultSet resultset = preparestatement.executeQuery();
			resultset.next();
			Role = resultset.getString("ROLE");
			return Role;
		} catch (SQLException e) {
			logger.error(e.getMessage() + " The SQL State is :" + e.getSQLState() + ". Error Code : " + e.getErrorCode());
		} finally {
			ObtainDataBaseConnection.terminateConnection();

		}

		return Role;
	}

}
