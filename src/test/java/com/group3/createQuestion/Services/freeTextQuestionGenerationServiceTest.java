package com.group3.createQuestion.Services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group3.createQuestion.DAO.*;

import static org.junit.jupiter.api.Assertions.*;

class freeTextQuestionGenerationServiceTest {

	IDAOAbstractFactory daoInjector;
	IServiceAbstractFactory serviceAbstractFactory;
	IQuestionService questionService;
	ISaveBasicQuestionInformationDAO saveBasicQuestionInformationDAO;
	Logger logger = LogManager.getLogger(QuestionServiceTest.class);

	@BeforeEach
	void setUp() {

		daoInjector = DAOMockAbstractFactory.instance();
		serviceAbstractFactory = ServiceAbstractFactory.instance();
		questionService = serviceAbstractFactory.createfreeTextQuestionGenerationService();
		saveBasicQuestionInformationDAO = daoInjector.createSaveBasicQuestionInformationDAO(serviceAbstractFactory.createCurrentTimeStampGenerationService());
	}

	@Test
	void saveFreeTextQuestionGenerationServiceInfo() {

		String id = questionService.saveBasicQuestionInformation("Design Pattern", "What is memento pattern?", "Free text", saveBasicQuestionInformationDAO);
		logger.info("id generated from mock object" + id);
		assertNotNull(id);
	}
}