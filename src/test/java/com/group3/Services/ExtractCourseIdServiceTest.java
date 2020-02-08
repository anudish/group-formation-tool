package com.group3.Services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExtractCourseIdServiceTest {
	IExtractCourseIdService iExtractCourseIdService;


	

	@Test
	final void testExtractCourseId() {
		
		
		//failing case 
		String inputString="csci6000-Artificial Intelligence";
		String expectedOutcome = "csci6000-"; //Not desired outcome
		iExtractCourseIdService = new ServiceInjector().createExtractCourseIdService(inputString);
		assertFalse(iExtractCourseIdService.extractCourseId().equals(expectedOutcome));
		
		//passing test
		 expectedOutcome = "csci6000"; //desired outcome
		 iExtractCourseIdService = new ServiceInjector().createExtractCourseIdService(inputString);
		 assertTrue(iExtractCourseIdService.extractCourseId().equals(expectedOutcome));
	}

}
