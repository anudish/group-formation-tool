package com.group3.createQuestion.DAO;

import com.group3.DBConnectivity.ObtainDataBaseConnection;
import com.group3.createQuestion.BusinessModels.MCQAnswers;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class SaveMCQAnswerstoDataBaseDAO implements ISaveMCQAnswerstoDataBaseDAO {
    private Connection dataBaseConnection;
    private String queryString;
    private PreparedStatement preparedStatement;
    private int successStatus=0;
    private Logger logger = LogManager.getLogger(SaveMCQAnswerstoDataBaseDAO.class);
    @Override
    public int saveOptionsToDataBase(int id, ArrayList<MCQAnswers> mcqAnswers) {
        queryString = "INSERT INTO MULTIPLE_CHOICE_QUESTIONS(QUESTION_ID,OPTION,STOREDAS) VALUES(?,?,?)";
        dataBaseConnection = ObtainDataBaseConnection.obtainDatabaseConnection();
        try {
            preparedStatement  =  dataBaseConnection.prepareStatement(queryString);
            for (MCQAnswers mcqAnsersInstance:mcqAnswers){
                preparedStatement.setInt(1,id);
                preparedStatement.setString(2,mcqAnsersInstance.getAnswer());
                preparedStatement.setString(3,mcqAnsersInstance.getStoredAs());
                preparedStatement.addBatch();
            }
            int[] rowsUpdatedCounter = preparedStatement.executeBatch();
            logger.log(Level.INFO," no of rows Appended : "+rowsUpdatedCounter.length);
            if (rowsUpdatedCounter.length == mcqAnswers.size()){
                successStatus = 1;
            }
        } catch (SQLException e) {
            logger.log(Level.INFO,"Failure reasons" +e.getSQLState());
            logger.log(Level.ERROR,"failed to apped row due to database connectivity problem "+e.getMessage());
        }
        return successStatus;
    }
}
