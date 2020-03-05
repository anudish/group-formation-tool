package com.group3.AdminAndAuthorization.Services;

import static org.junit.jupiter.api.Assertions.*;

import com.group3.Services.IGrantAccessFieldsValidation;
import com.group3.Services.IServiceInjector;
import com.group3.Services.ServiceInjector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class GrantAccessFieldsValidationTest {
	
	private IGrantAccessFieldsValidation iGrantAccessFieldsValidation;
	IServiceInjector serviceInjector;
	@BeforeEach
	void setUp() throws Exception {
		 serviceInjector = new ServiceInjector();
	}

	@Test
	final void testValidateFields() {
		iGrantAccessFieldsValidation =serviceInjector.createGrantAccessFieldsValidation("CSCI6770-Graphics", "Instructor");
	    assertFalse(iGrantAccessFieldsValidation.validateFields().length() > 0);
	
	    iGrantAccessFieldsValidation =serviceInjector.createGrantAccessFieldsValidation("Select courses", "Instructor");
	    assertTrue(iGrantAccessFieldsValidation.validateFields().length() > 0);
	    
	    iGrantAccessFieldsValidation =serviceInjector.createGrantAccessFieldsValidation("CSCI6770-Graphics", "Select Role");
	    assertTrue(iGrantAccessFieldsValidation.validateFields().length() > 0);
	
	    iGrantAccessFieldsValidation =serviceInjector.createGrantAccessFieldsValidation("Select courses", "Select Role");
	    assertTrue(iGrantAccessFieldsValidation.validateFields().length() > 0);
	
	}

}
