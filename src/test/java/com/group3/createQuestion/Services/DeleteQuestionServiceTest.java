package com.group3.createQuestion.Services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.group3.createQuestion.DAO.DAOMockInjectorAbstractFactory;
import com.group3.createQuestion.DAO.IDAOInjector;
import com.group3.createQuestion.DAO.IRemoveQuestionDAO;
import com.group3.createQuestion.DAO.IRetrieveQuestionsDAO;

class DeleteQuestionServiceTest {

	private static IDAOInjector daoInjector;
	private static IRemoveQuestionDAO removeQuestionDAO;
    public static Logger logger = LogManager.getLogger(DeleteQuestionServiceTest.class);
    
    @BeforeAll
    public static void setUp() {
    	daoInjector = DAOMockInjectorAbstractFactory.getInstance();
        removeQuestionDAO = daoInjector.createRemoveQuestionDAO();
        logger.info("ObtainQuestionsServiceTest setup!");
    }

    @AfterAll
    public static void tearDown() {
    }

    @Test
    public void obtainInstructorQuestionsTest() {
    	
    	boolean result = removeQuestionDAO.removeQuestionFromDatabase("1");
        assertTrue(result);
        
        result = removeQuestionDAO.removeQuestionFromDatabase("5");
        assertFalse(result);
    }

}
