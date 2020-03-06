package com.group3.AdminAndAuthorization.Services;

import static org.junit.jupiter.api.Assertions.*;

import com.group3.AdminAndAuthorization.Services.IExtractCourseIdService;
import org.junit.jupiter.api.Test;

class ExtractCourseIdServiceTest {
	IExtractCourseIdService iExtractCourseIdService;


	

	@Test
	final void testExtractCourseId() {
		
		
		//failing case 
		final String inputString="csci6000-Artificial Intelligence";
		String expectedOutcome = "csci6000-"; //Not desired outcome
		iExtractCourseIdService = new ServiceInjector().createExtractCourseIdService(inputString);
		
		System.out.println("preString "+inputString);
		assertFalse(iExtractCourseIdService.extractCourseId().equals(expectedOutcome));
		
		//passing test
		 expectedOutcome = "csci6000"; //desired outcome
		 iExtractCourseIdService = new ServiceInjector().createExtractCourseIdService(inputString);
		 
		 assertTrue(iExtractCourseIdService.extractCourseId().equals(expectedOutcome));
	}

}
