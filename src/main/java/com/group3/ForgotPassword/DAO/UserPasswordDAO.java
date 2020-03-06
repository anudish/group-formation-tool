package com.group3.ForgotPassword.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.group3.DBConnectivity.ObtainDataBaseConnection;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class UserPasswordDAO implements IUserPasswordDAO {
    private static Logger logger = LogManager.getLogger(UserPasswordDAO.class);
    Connection connection;
    PreparedStatement statement;
    String query;

    public boolean isUserExist(String email) {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        boolean queryResult = false;
        ResultSet result = null;

        try {
            connection = ObtainDataBaseConnection.obtainDatabaseConnection();
            query = "SELECT * FROM AUTHENTICATION_DATABASE WHERE MAIL_ID = ?";

            statement = connection.prepareStatement(query);
            statement.setString(1, email);

            result = statement.executeQuery();
            queryResult = result.next();
            logger.debug("Resultset return is null? :" + !queryResult);

            connection.close();
            logger.info("GET EXISTING USER USING MAIL_ID= " + email + " QUERY EXECUTED");
        } catch (SQLException e) {
            logger.error("Error getting user mail_id= " + email + " " + e.getMessage() + " SQL State:" + e.getSQLState() + " Error code:" + e.getErrorCode());
        }

        return queryResult;
    }

    public void updateNewPassword(String email, String password) {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        int queryResult;
        try {
            connection = ObtainDataBaseConnection.obtainDatabaseConnection();
            query = "update AUTHENTICATION_DATABASE set PASSWORD = ? where MAIL_ID = ?";

            statement = connection.prepareStatement(query);
            statement.setString(1, password);
            statement.setString(2, email);

            queryResult = statement.executeUpdate();
            logger.debug(queryResult + " record updated during password updation of " + email);

            connection.close();
            logger.info("NEW PASSWORD UPDATED SUCCESSFULLY QUERY EXECUTED");
        } catch (SQLException e) {
            logger.error("Error updating new password for = " + email + " " + e.getMessage() + " SQL State:" + e.getSQLState() + " Error code:" + e.getErrorCode());
        }
    }
}