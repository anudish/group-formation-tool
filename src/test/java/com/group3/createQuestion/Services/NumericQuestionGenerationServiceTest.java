package com.group3.createQuestion.Services;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group3.createQuestion.DAO.DAOMockInjector;
import com.group3.createQuestion.DAO.ISaveBasicQuestionInformationDAO;

class NumericQuestionGenerationServiceTest {
	
	IQuestionService questionService;
    ISaveBasicQuestionInformationDAO saveBasicQuestionInformationDAO;
    Logger logger = LogManager.getLogger(NumericQuestionGenerationServiceTest.class);
   
   @BeforeEach
    void intit() {
        questionService = ObtainServiceFactoryInstance.getInstance().createNumericQuestionGenerationService();
        saveBasicQuestionInformationDAO = DAOMockInjector.getInstance().createSaveBasicQuestionInformationDAO(ObtainServiceFactoryInstance.getInstance().createCurrentTimeStampGenerationService());
    }

    @Test
    void saveNumericQuestionTest() {
        String id =  questionService.saveBasicQuestionInformation("Test Title","Test Text","Numeric",saveBasicQuestionInformationDAO);
        logger.info("id generated from mock object" +id);
        assertNotNull(id);
    }

}
