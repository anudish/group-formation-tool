package com.group3.createQuestion.Services;

import com.group3.createQuestion.DAO.DAOMockInjector;
import com.group3.createQuestion.DAO.IDAOInjector;
import com.group3.createQuestion.DAO.IValidationRulesLoaderDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringValidatorServiceTest {

    private IServiceAbstractFactory iServiceAbstractFactory;
    public static Logger logger = LogManager.getLogger(EmptyStringValidationService.class);
    private IStringValidatorService iStringValidatorService;
    private IDAOInjector idaoInjector;
    @BeforeEach
    void setUp() {
        idaoInjector = DAOMockInjector.getInstance();
        iServiceAbstractFactory = ObtainServiceFactoryInstance.getInstance();
        IValidationRulesLoaderDAO iValidationRulesLoaderDAO = idaoInjector.createValidationRulesLoaderDAO();
        iStringValidatorService = iServiceAbstractFactory.createStringValidatorService(iValidationRulesLoaderDAO);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isValid() {
        String emptyString= new String();
        assertFalse(iStringValidatorService.isValid(emptyString));

        String specialCharcterCheck = "@# special character";
        assertFalse(!iStringValidatorService.isValid(specialCharcterCheck));

        String numberCheck = "1 Object Creation service ?";
        assertFalse(iStringValidatorService.isValid(numberCheck));

        assertTrue(iStringValidatorService.isValid("What is memento ?"));
    }
}