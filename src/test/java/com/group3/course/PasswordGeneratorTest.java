package com.group3.course;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PasswordGeneratorTest {

	static PasswordGenerator passwordGenerator;
	
	@BeforeAll
	public static void init() {
		passwordGenerator = new PasswordGenerator();
	}
	
	@Test
	public void getNewPasswordTest(){
		assertThat(passwordGenerator.getNewPassword(10)).isNotEmpty();
		assertThat(passwordGenerator.getNewPassword(10)).isNotNull();
		assertEquals(passwordGenerator.getNewPassword(10).toString().length(), 10);
		
		assertThat(passwordGenerator.getNewPassword(5)).isNotEmpty();
		assertThat(passwordGenerator.getNewPassword(5)).isNotNull();
		assertEquals(passwordGenerator.getNewPassword(5).toString().length(), 5);
	}
	
}
