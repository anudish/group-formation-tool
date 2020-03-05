package com.group3.createQuestion.Services;

import com.group3.createQuestion.BusinessModels.QuestionTypes;
import com.group3.createQuestion.DAO.DAOMockAbstractFactory;
import com.group3.createQuestion.DAO.IDAOAbstractFactory;
import com.group3.createQuestion.DAO.IRetrieveQuestionTypesDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ObtainAllQuestionTypesServiceTest {

	IDAOAbstractFactory daoInjector;
	IServiceAbstractFactory serviceAbstractFactory;
	IRetrieveQuestionTypesDAO retrieveQuestionTypesDAO;
	IObtainAllQuestionTypesService obtainAllQuestionTypesService;
	ArrayList<QuestionTypes> questionTypes;
	public static Logger logger = LogManager.getLogger(ObtainAllQuestionTypesServiceTest.class);

	@BeforeEach
	void setUp() {

		daoInjector = DAOMockAbstractFactory.instance();
		serviceAbstractFactory = ServiceAbstractFactory.instance();
		questionTypes = new ArrayList<>();
		retrieveQuestionTypesDAO = daoInjector.createRetrieveQuestionTypesDAO();
		logger.info(retrieveQuestionTypesDAO.getQuestionTypes().size());
		obtainAllQuestionTypesService = serviceAbstractFactory.createObtainAllQuestionTypesService(retrieveQuestionTypesDAO);
		questionTypes = obtainAllQuestionTypesService.getAllQuestionTypes();
	}

	@Test
	void getAllQuestionTypes() {

		assertTrue(questionTypes.size() > 0);
		assertFalse(questionTypes.size() == 0);
	}
}