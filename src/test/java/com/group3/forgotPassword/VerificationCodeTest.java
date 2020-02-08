package com.group3.forgotPassword;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VerificationCodeTest {

	IVerificationCode verificationCode;
	
	public VerificationCodeTest() {
		verificationCode = new VerificationCode();
	}
	
	@Test
	void generateNewCodeTest() {

		String code = verificationCode.getNewCode(5);
		assertThat(code).isNotNull();
		assertThat(code).isNotEmpty();
		assertEquals(code.length(),5);
		
	}

}
