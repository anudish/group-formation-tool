package com.group3.forgotPassword.Services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.group3.forgotPassword.Services.IVerificationCode;
import com.group3.forgotPassword.Services.VerificationCode;

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
		assertEquals(code.length(), 5);
	}
}