package com.group3.forgotPassword.Services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.group3.BusinessModels.GuestModel;

import com.group3.forgotPassword.DAO.*;
import com.group3.forgotPassword.Services.*;

class ResetCodeManagerTest {

	GuestModel model = null;
	IDAOInjector daoInjector;
	IUserPasswordDAO userPasswordDAO;
	IVerificationCode verificationCode;
	GmailServiceMock gmailServiceMock;

	public ResetCodeManagerTest() {

		daoInjector = DAOMockInjector.instance();
		userPasswordDAO = daoInjector.getUserDAOObj();
		verificationCode = new VerificationCodeMock();
		gmailServiceMock = new GmailServiceMock();
	}

	@Test
	public void sendCodeEmail() {

		gmailServiceMock.setSMTPClient();
		assertThat(gmailServiceMock.properties).isNotEmpty();
		assertThat(gmailServiceMock.properties).isNotNull();
		assertThat(gmailServiceMock.session).isNotNull();
	}

	@Test
	public void generateCode() {

		String code = verificationCode.getNewCode(5);
		assertThat(code).isNotNull();
		assertThat(code).isNotEmpty();
		assertEquals(code.length(), 5);
	}

	@Test
	public void checkEmailIdExistance() {

		boolean result = userPasswordDAO.isUserExist("testmail@dal.ca");
		assertThat(result).isNotNull();
		assertFalse(result);

	}
}