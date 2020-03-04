package com.group3.forgotPassword.Services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.group3.forgotPassword.DAO.*;
import com.group3.forgotPassword.Services.*;

class UpdatePasswordManagerTest {

	IDAOInjector daoInjector;
	IUserPasswordDAO userPasswordDAO;
	IVerificationCode verificationCodeMock;

	public UpdatePasswordManagerTest() {

		daoInjector = DAOMockInjector.instance();
		userPasswordDAO = daoInjector.getUserDAOObj();
		verificationCodeMock = new VerificationCodeMock();
	}

	@Test
	public void compareCode() {

		String generated_code = new String();
		generated_code = verificationCodeMock.getNewCode(5);
		assertEquals("TCode", generated_code);
	}

	@Test
	public void updatePassword() {

		userPasswordDAO.updateNewPassword("tstark@dal.ca", "hello@123");
		String password = UserPasswordDAOMock.model.getEncryptedPassword();
		assertThat(password).isNotNull();
		assertThat(password).isNotEmpty();
		assertEquals("hello@123", password);
	}
}