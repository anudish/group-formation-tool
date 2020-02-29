package com.group3.createQuestion.Services;


import com.group3.createQuestion.DAO.ISaveBasicQuestionInformationDAO;
import com.group3.createQuestion.DAOTest.DAOMockInjector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionServiceTest {
    IQuestionService iQuestionService;
    ISaveBasicQuestionInformationDAO iSaveBasicQuestionInformationDAO;
    Logger logger = LogManager.getLogger(QuestionServiceTest.class);
    @BeforeEach
    void setUp() {
        iQuestionService = ObtainServiceFactoryInstance.getInstance().createfreeTextQuestionGenerationService();
        iSaveBasicQuestionInformationDAO = DAOMockInjector.getInstance().createSaveBasicQuestionInformationDAO(ObtainServiceFactoryInstance.getInstance().createCurrentTimeStampGenerationService());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveBasicQuestionInformation() {
        String id =  iQuestionService.saveBasicQuestionInformation("Design Pattern","What is memento pattern?","Free text",iSaveBasicQuestionInformationDAO);
        logger.info("id generated from mock" +id);
        assertNotNull(id);
    }

    @Test
    void getQuestionType() {
        QuestionGenerationServicesEnum questionGenerationServicesEnum = QuestionGenerationServicesEnum.FREE_TEXT;
        assertNotEquals(iQuestionService.getQuestionType(),QuestionGenerationServicesEnum.MCQS_MULTIPLE);

        assertEquals(questionGenerationServicesEnum,iQuestionService.getQuestionType());
    }
}