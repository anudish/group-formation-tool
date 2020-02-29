package com.group3.createQuestion.DAO;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group3.DBConnectivity.ObtainDataBaseConnection;

class RemoveQuestionsDAOTest {

	private static IDAOInjector daoInjector;
	private static IRemoveQuestionDAO removeQuestionDAO;
    public static Logger logger = LogManager.getLogger(RemoveQuestionsDAOTest.class);
    
    static Connection conn;
	static String sql;
	static PreparedStatement statement;
	
	String questionId;
	boolean deleteResult;
	
	 @BeforeAll
	    public static void setUp() throws SQLException {
	    	daoInjector = DAOInjectorAbstractFactory.getInstance();
	        removeQuestionDAO = daoInjector.createRemoveQuestionDAO();
	        logger.info("ObtainQuestionsServiceTest setup!");
	    }
	    
	    @BeforeEach
	    public void init() throws SQLException {
	    
	    	conn = ObtainDataBaseConnection.obtainDatabaseConnection();
			sql = "insert into QUESTIONS values (0,'Test Title 3','Test Text 3','Test Type 3',NULL)";
	        statement = conn.prepareStatement(sql);		
	        int result = statement.executeUpdate();
	        logger.info("Test Question Inserted!");
	        
			sql = "select MAX(QUESTION_ID) as QUESTION_ID from QUESTIONS;";
	        statement = conn.prepareStatement(sql);		
	        
	        ResultSet resultData = statement.executeQuery();
	        while(resultData.next()) {
	        	questionId = resultData.getInt("QUESTION_ID")+"";
	        }
	        logger.info("Test QuestionId retrieved for testing purpose!");
 
	        sql = "insert into MULTIPLE_CHOICE_QUESTIONS values ("+questionId+",'Test Option 1');";
	        statement = conn.prepareStatement(sql);		
	        result = statement.executeUpdate();
	        logger.info("Test Option for questionId: "+questionId+" Inserted!");
	       	        
	        sql = "insert into INSTRUCTOR_QUESTION_MAPPING values ('test@dal.ca',"+questionId+");";
	        statement = conn.prepareStatement(sql);		
	        result = statement.executeUpdate();
	        logger.info("Test Instructor for questionId: "+questionId+" Inserted!");
	        
	        sql = "insert into SURVEY_QUESTIONS values (0,"+questionId+");";
	        statement = conn.prepareStatement(sql);		
	        result = statement.executeUpdate();
	        logger.info("Test Survey Question for questionId: "+questionId+" Inserted!");
	        
	        sql = "insert into RESPONSE values (0,0,"+questionId+");";
	        statement = conn.prepareStatement(sql);		
	        result = statement.executeUpdate();
	        logger.info("Test Student Response for questionId: "+questionId+" Inserted!");
	        
	        conn.close();
	    }

	    @AfterEach
	    public void tearDown() throws SQLException {
	    	if(!conn.isClosed()) {
	    		conn.close();
	    	}
	    }
	
	@Test
	void test() {
		deleteResult = removeQuestionDAO.removeQuestionFromDatabase(questionId);
        assertTrue(deleteResult);
	}

}
