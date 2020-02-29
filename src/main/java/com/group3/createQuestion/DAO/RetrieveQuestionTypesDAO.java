package com.group3.createQuestion.DAO;

import com.group3.DBConnectivity.ObtainDataBaseConnection;
import com.group3.createQuestion.BusinessModels.questionTypes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RetrieveQuestionTypesDAO implements IRetrieveQuestionTypesDAO {
    private ArrayList<questionTypes> questionType;
    private String queryString,questionTypeText;
    private Connection databaseConnection;
    private static Logger logger = LogManager.getLogger(RetrieveQuestionTypesDAO.class);

    @Override
    public ArrayList<questionTypes> getQuestionTypes() {
        questionType = new ArrayList<>();
        queryString = "select TYPES from QUESTION_TYPE";

        try {
            databaseConnection = ObtainDataBaseConnection.obtainDatabaseConnection();
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(queryString);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                logger.info(resultSet.getObject("TYPES"));
                questionTypeText = resultSet.getObject("TYPES").toString();
                questionTypes questTypeInstance = new questionTypes();
                questTypeInstance.setQuestionType(questionTypeText);
                questionType.add(questTypeInstance);
            }
        }catch (SQLException e){
            logger.error("facing database server connectivity error");
        }
        return questionType;

    }
}
