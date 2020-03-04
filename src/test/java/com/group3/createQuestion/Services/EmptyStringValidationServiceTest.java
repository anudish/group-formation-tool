package com.group3.createQuestion.Services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmptyStringValidationServiceTest {

	EmptyStringValidationService emptyStringValidationService;

	@BeforeEach
	void setUp() {

		emptyStringValidationService = new EmptyStringValidationService();
	}

	@Test
	void isValid() {

		String emptyString = new String();
		assertFalse(emptyStringValidationService.isValid(emptyString));
		String nonEmptyString = "Hello I am Non empty ! geeks";
		assertTrue(emptyStringValidationService.isValid(nonEmptyString));
	}
}