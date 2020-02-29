package com.group3.createQuestion.Services;

import com.group3.createQuestion.DAO.IDAOInjector;
import com.group3.createQuestion.DAO.IValidationRulesLoaderDAO;
import com.group3.createQuestion.DAOTest.DAOMockInjector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StartWithNumberCheckValidationServiceTest {
    StartWithNumberCheckValidationService startWithNumberCheckValidationService;
    @BeforeEach
    void setUp() {
        startWithNumberCheckValidationService = new StartWithNumberCheckValidationService();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isValid() {
        assertFalse(startWithNumberCheckValidationService.isValid("1 That's not the case"));
        assertTrue(startWithNumberCheckValidationService.isValid("How is intensity level?"));
    }
}