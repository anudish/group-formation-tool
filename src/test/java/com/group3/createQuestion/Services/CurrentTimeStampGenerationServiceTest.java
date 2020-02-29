package com.group3.createQuestion.Services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class CurrentTimeStampGenerationServiceTest {
    private IServiceAbstractFactory iServiceAbstractFactory;
    private ICurrentTimeStampGenerationService iCurrentTimeStampGenerationService;
    public static Logger logger = LogManager.getLogger(CurrentTimeStampGenerationServiceTest.class);
    @BeforeEach
    void setUp() {
        iServiceAbstractFactory = ObtainServiceFactoryInstance.getInstance();
        iCurrentTimeStampGenerationService = iServiceAbstractFactory.createCurrentTimeStampGenerationService();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void returnCurrentTimeStamp() {
        Timestamp timestamp = iCurrentTimeStampGenerationService.returnCurrentTimeStamp();
        logger.info(timestamp);
        assertFalse(timestamp==null);
        assertTrue(timestamp!=null);
    }
}