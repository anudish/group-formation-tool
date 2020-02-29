package com.group3.createQuestion.DAO;

import com.group3.DBConnectivity.ObtainDataBaseConnection;
import com.group3.createQuestion.Services.ICurrentTimeStampGenerationService;

import java.sql.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SaveBasicQuestionInformationDAO implements ISaveBasicQuestionInformationDAO {
    private String queryString,feedBackMessage,type;
    private Connection dataBaseConnection;
    private Timestamp currentTimestamp;
    private ICurrentTimeStampGenerationService iCurrentTimeStampGenerationService;
    private String questionTypeInformation;
    private ResultSet resultSet;
    private static Logger logger = LogManager.getLogger(SaveBasicQuestionInformationDAO.class);
    public SaveBasicQuestionInformationDAO(ICurrentTimeStampGenerationService iCurrentTimeStampGenerationService){
        this.iCurrentTimeStampGenerationService = iCurrentTimeStampGenerationService;
        feedBackMessage = new String();
        resultSet = null;
    }
    @Override
    public String saveDetailsAndReturnId(String title, String text,String type) {
        queryString = "INSERT INTO QUESTIONS(TITLE,TEXT,TYPE,TIMESTAMP) VALUES(?,?,?,?)";
        dataBaseConnection = ObtainDataBaseConnection.obtainDatabaseConnection();
        try {
            PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(queryString,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,text);
            preparedStatement.setString(3,type);
            this.currentTimestamp = this.iCurrentTimeStampGenerationService.returnCurrentTimeStamp();
            preparedStatement.setTimestamp(4,this.currentTimestamp);
            preparedStatement.execute();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            if (resultSet!=null){
                feedBackMessage = String.valueOf(resultSet.getInt(1));
                logger.info("returned value database : "+feedBackMessage);
            }

        } catch (SQLException e) {
            logger.error("error connecting with server !!"+e.getMessage());
        }
        return feedBackMessage;
    }
}
