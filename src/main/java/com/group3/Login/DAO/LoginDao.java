package com.group3.Login.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.group3.BusinessModels.LoginForm;
import com.group3.DBConnectivity.ObtainDataBaseConnection;

public class LoginDao implements ILoginDAO {

    private static Logger logger = LogManager.getLogger(LoginDao.class);
    Connection connection;
    PreparedStatement statement;
    ResultSet resultSet;
    LoginForm user;

    @Override
    public LoginForm getUserByEmail(String email) {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        try {
            connection = ObtainDataBaseConnection.obtainDatabaseConnection();
            statement = connection.prepareStatement("select * from  AUTHENTICATION_DATABASE WHERE MAIL_ID = ?");
            statement.setString(1, email);

            resultSet = statement.executeQuery();
            resultSet.next();
            logger.info("email " + resultSet.getString("MAIL_ID"));
            user = new LoginForm(resultSet.getString("MAIL_ID"), resultSet.getString("PASSWORD"));

        } catch (SQLException e) {
            logger.error(e);
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (statement != null)
                    resultSet.close();
                if (connection != null)
                    resultSet.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }
        return user;
    }

    @Override
    public String getRoleByEmail(String email) {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        String role = new String();
        try {
            connection = ObtainDataBaseConnection.obtainDatabaseConnection();

            statement = connection.prepareStatement("select ROLE from  USER_DATABASE WHERE MAIL_ID = ?");
            statement.setString(1, email);

            resultSet = statement.executeQuery();
            resultSet.next();
            role = resultSet.getString("ROLE");
            logger.info("role " + role);

        } catch (SQLException e) {
            logger.error("Error getting role for = " + email + " " + e.getMessage() + " SQL State:" + e.getSQLState() + " Error code:" + e.getErrorCode());
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (statement != null)
                    resultSet.close();
                if (connection != null)
                    resultSet.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
        return role;
    }

}
