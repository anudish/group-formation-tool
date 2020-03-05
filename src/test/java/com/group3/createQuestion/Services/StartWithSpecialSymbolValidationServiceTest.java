package com.group3.createQuestion.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StartWithSpecialSymbolValidationServiceTest {

	StartWithSpecialSymbolValidationService startWithSpecialSymbolValidationService;

	@BeforeEach
	void setUp() {

		startWithSpecialSymbolValidationService = new StartWithSpecialSymbolValidationService();
	}

	@Test
	void isValid() {

		assertFalse(!startWithSpecialSymbolValidationService.isValid("@!,amnd,mn"));
		assertTrue(startWithSpecialSymbolValidationService.isValid("literals $"));
	}
}