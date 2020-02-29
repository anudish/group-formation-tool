package com.group3.createQuestion.DAOTest;

import com.group3.DBConnectivity.ObtainDataBaseConnection;
import com.group3.createQuestion.DAO.DAOInjector;
import com.group3.createQuestion.DAO.IDAOInjector;
import com.group3.createQuestion.DAO.ISaveBasicQuestionInformationDAO;
import com.group3.createQuestion.Services.ICurrentTimeStampGenerationService;
import com.group3.createQuestion.Services.IServiceAbstractFactory;
import com.group3.createQuestion.Services.ObtainServiceFactoryInstance;
import com.group3.createQuestion.Services.ServiceAbstractFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class SaveBasicQuestionInformationDAOTest {
    ISaveBasicQuestionInformationDAO iSaveBasicQuestionInformationDAO;
    String returnMessageFromDataBase,queryString;
    Connection connection;
    public static Logger logger = LogManager.getLogger(SaveBasicQuestionInformationDAOTest.class);
    @BeforeEach
    void setUp() {
        IDAOInjector idaoInjector = DAOInjector.getInstance();
        returnMessageFromDataBase = null;
        IServiceAbstractFactory iServiceAbstractFactory = ObtainServiceFactoryInstance.getInstance();
        ICurrentTimeStampGenerationService iCurrentTimeStampGenerationService = iServiceAbstractFactory.createCurrentTimeStampGenerationService();
        iSaveBasicQuestionInformationDAO = idaoInjector.createSaveBasicQuestionInformationDAO(iCurrentTimeStampGenerationService);
        
    }

    @AfterEach
    void tearDown() {
        //resource deallocation
        queryString = "DELETE FROM QUESTION WHERE QUESTION_ID=?";
        if (returnMessageFromDataBase!=null){
            try {
                connection = ObtainDataBaseConnection.obtainDatabaseConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(queryString);
                preparedStatement.setString(1,returnMessageFromDataBase);
            } catch (SQLException e) {
                logger.info("server connectivity problem !! (Check Internet connectivity)");
            }
        }

    }

    @Test
    void saveDetails() {
        returnMessageFromDataBase = iSaveBasicQuestionInformationDAO.saveDetailsAndReturnId("Programming Capacity","How many hours you can spent on programming per week ?","Free text");
        assertNotNull(returnMessageFromDataBase);
    }
}