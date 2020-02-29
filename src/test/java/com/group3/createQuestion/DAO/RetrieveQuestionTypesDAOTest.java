package com.group3.createQuestion.DAO;


import com.group3.DBConnectivity.ObtainDataBaseConnection;
import com.group3.createQuestion.BusinessModels.questionTypes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RetrieveQuestionTypesDAOTest {
    IRetrieveQuestionTypesDAO iRetrieveQuestionTypesDAO;
    ArrayList<questionTypes> possibleQuestionType;
    Connection connection;
    String queryString,testDatabaseEntry;
    public static Logger logger;
    @BeforeEach
    void setUp() {
        logger = LogManager.getLogger(RetrieveQuestionTypesDAOTest.class);
        IDAOInjector idaoInjector = DAOInjector.getInstance();
        iRetrieveQuestionTypesDAO = idaoInjector.createRetrieveQuestionTypesDAO();
        connection = ObtainDataBaseConnection.obtainDatabaseConnection();
        queryString = "INSERT INTO QUESTION_TYPE(TYPES) VALUES(?)";
        testDatabaseEntry = "EntryQuestionTypeCheck";
        try {
            //allocate testable resource
            PreparedStatement preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setString(1,testDatabaseEntry);

        } catch (SQLException e) {
            logger.info("server connectivity problem !! (Check Internet connectivity)");
        }


    }

    @AfterEach
    void tearDown() {
        //Deallocate testable resource
        queryString = "DELETE FROM QUESTION_TYPE WHERE TYPES=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setString(1,testDatabaseEntry);
        } catch (SQLException e) {
            logger.info("server connectivity problem !! (Check Internet connectivity)");
        }
    }

    @Test
    void getQuestionTypes() {
        possibleQuestionType = this.iRetrieveQuestionTypesDAO.getQuestionTypes();
        assertNotNull(possibleQuestionType.size() > 0);
    }
}