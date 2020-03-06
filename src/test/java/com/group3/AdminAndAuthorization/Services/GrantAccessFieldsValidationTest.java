package com.group3.AdminAndAuthorization.Services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class GrantAccessFieldsValidationTest {
	
	private IGrantAccessFieldsValidation iGrantAccessFieldsValidation;
	IServiceInjector serviceInjector;

	public GrantAccessFieldsValidationTest(){
		 serviceInjector = ServiceInjector.instance();
	}

	@Test
	final void testValidateFields() {
		iGrantAccessFieldsValidation =serviceInjector.createGrantAccessFieldsValidation("CSCI6770-Graphics", "Instructor");
	    assertFalse(iGrantAccessFieldsValidation.validateFields().length() > 0);

	}
	@Test
	final void testValidateFieldsCaseInstructor(){
		iGrantAccessFieldsValidation =serviceInjector.createGrantAccessFieldsValidation("Select courses", "Instructor");
		assertTrue(iGrantAccessFieldsValidation.validateFields().length() > 0);
	}

	@Test
	final void testValidateFieldsCaseSelectRole(){
		iGrantAccessFieldsValidation =serviceInjector.createGrantAccessFieldsValidation("CSCI6770-Graphics", "Select Role");
		assertTrue(iGrantAccessFieldsValidation.validateFields().length() > 0);
	}

	@Test
	final void testValidateFieldsCaseSelectRoleAndCourse(){
		iGrantAccessFieldsValidation =serviceInjector.createGrantAccessFieldsValidation("Select courses", "Select Role");
		assertTrue(iGrantAccessFieldsValidation.validateFields().length() > 0);
	}
}
