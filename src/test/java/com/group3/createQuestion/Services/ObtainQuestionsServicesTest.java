package com.group3.createQuestion.Services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group3.createQuestion.BusinessModels.Question;
import com.group3.createQuestion.DAO.DAOMockInjectorAbstractFactory;
import com.group3.createQuestion.DAO.IDAOInjector;
import com.group3.createQuestion.DAO.IRetrieveQuestionTypesDAO;
import com.group3.createQuestion.DAO.IRetrieveQuestionsDAO;

public class ObtainQuestionsServicesTest {
 	
    private static IDAOInjector daoInjector;
	private static IRetrieveQuestionsDAO retrieveQuestionsDAO;
    public static Logger logger = LogManager.getLogger(ObtainQuestionsServicesTest.class);
    List<List<String>> questionList;
    
    @BeforeAll
    public static void setUp() {
    	daoInjector = DAOMockInjectorAbstractFactory.getInstance();
        retrieveQuestionsDAO = daoInjector.createRetrieveQuestionsDAO();
        logger.info("ObtainQuestionsServiceTest setup!");
    }

    @AfterAll
    public static void tearDown() {
    }

    @Test
    public void obtainInstructorQuestionsTest() {
    	
    	questionList = retrieveQuestionsDAO.getQuestionsByInstructorID("1");
        assertTrue(questionList.size() > 0);
        assertFalse(questionList.size() == 0);

    }
}
