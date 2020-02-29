package com.group3.createQuestion.DAO;

import com.group3.DBConnectivity.ObtainDataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ValidationRulesLoaderDAO implements IValidationRulesLoaderDAO {
    private ArrayList<String> validationRulesList;
    private String queryString;
    private Connection databaseConnection;
    private String rule;
    private static Logger logger = LogManager.getLogger(ValidationRulesLoaderDAO.class);
    @Override
    public ArrayList<String> getValidationRules() {

        validationRulesList= new ArrayList<>();
        queryString = "select RULE from VALIDATION_RULES WHERE PACKAGE_NAME=? AND ENABLED=?";

        try {
            databaseConnection = ObtainDataBaseConnection.obtainDatabaseConnection();
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(queryString);
            preparedStatement.setString(1,"QUESTION_MANAGER");
            preparedStatement.setInt(2,1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                logger.info(resultSet.getObject("RULE"));
                rule = resultSet.getObject("RULE").toString();
                validationRulesList.add(rule);
            }
        }catch (SQLException e){
            logger.error("facing database server connectivity error");
        }
        return validationRulesList;
    }
}
