package com.group3.createQuestion.Services;

import com.group3.createQuestion.DAO.DAOMockInjector;
import com.group3.createQuestion.DAO.ISaveBasicQuestionInformationDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class freeTextQuestionGenerationServiceTest {
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
    void saveFreeTextQuestionGenerationServiceInfo() {
        String id =  iQuestionService.saveBasicQuestionInformation("Design Pattern","What is memento pattern?","Free text",iSaveBasicQuestionInformationDAO);
        logger.info("id generated from mock object" +id);
        assertNotNull(id);
    }
}