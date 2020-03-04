package com.group3.createQuestion.Services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class CurrentTimeStampGenerationServiceTest {

	private IServiceAbstractFactory serviceAbstractFactory;
	private ICurrentTimeStampGenerationService currentTimeStampGenerationService;
	public static Logger logger = LogManager.getLogger(CurrentTimeStampGenerationServiceTest.class);

	@BeforeEach
	void setUp() {

		serviceAbstractFactory = ServiceAbstractFactory.instance();
		currentTimeStampGenerationService = serviceAbstractFactory.createCurrentTimeStampGenerationService();
	}

	@Test
	void returnCurrentTimeStamp() {

		Timestamp timestamp = currentTimeStampGenerationService.returnCurrentTimeStamp();
		logger.info(timestamp);
		assertFalse(timestamp == null);
		assertTrue(timestamp != null);
	}
}