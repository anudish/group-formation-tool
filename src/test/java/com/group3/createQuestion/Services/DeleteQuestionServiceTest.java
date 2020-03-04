package com.group3.createQuestion.Services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group3.createQuestion.DAO.*;

class DeleteQuestionServiceTest {

	private static IDAOAbstractFactory daoInjector;
	private static IRemoveQuestionDAO removeQuestionDAO;
	public static Logger logger = LogManager.getLogger(DeleteQuestionServiceTest.class);

	@BeforeEach
	public void setUp() {

		daoInjector = DAOMockAbstractFactory.instance();
		removeQuestionDAO = daoInjector.createRemoveQuestionDAO();
	}

	@Test
	public void obtainInstructorQuestionsTest() {

		boolean result = removeQuestionDAO.removeQuestionFromDatabase("1");
		assertTrue(result);
		result = removeQuestionDAO.removeQuestionFromDatabase("5");
		assertFalse(result);
	}

}