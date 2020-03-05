package com.group3.createQuestion.Services;

import com.group3.createQuestion.DAO.DAOMockAbstractFactory;
import com.group3.createQuestion.DAO.IDAOAbstractFactory;
import com.group3.createQuestion.DAO.IRetrieveQuestionsDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObtainQuestionsServicesTest {

	private static IDAOAbstractFactory daoInjector;
	private static IRetrieveQuestionsDAO retrieveQuestionsDAO;
	public static Logger logger = LogManager.getLogger(ObtainQuestionsServicesTest.class);
	List<List<String>> questionList;

	@BeforeEach
	void setUp() {

		daoInjector = DAOMockAbstractFactory.instance();
		retrieveQuestionsDAO = daoInjector.createRetrieveQuestionsDAO();
		logger.info("ObtainQuestionsServiceTest setup!");
	}

	@Test
	public void obtainInstructorQuestionsTest() {

		questionList = retrieveQuestionsDAO.getQuestionsByInstructorID("1", "");
		assertTrue(questionList.size() > 0);
		assertFalse(questionList.size() == 0);

	}
}