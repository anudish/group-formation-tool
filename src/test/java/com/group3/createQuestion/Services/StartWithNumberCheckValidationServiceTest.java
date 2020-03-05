package com.group3.createQuestion.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StartWithNumberCheckValidationServiceTest {

	StartWithNumberCheckValidationService startWithNumberCheckValidationService;

	@BeforeEach
	void setUp() {

		startWithNumberCheckValidationService = new StartWithNumberCheckValidationService();
	}

	@Test
	void isValid() {

		assertFalse(startWithNumberCheckValidationService.isValid("1 That's not the case"));
		assertTrue(startWithNumberCheckValidationService.isValid("How is intensity level?"));
	}
}