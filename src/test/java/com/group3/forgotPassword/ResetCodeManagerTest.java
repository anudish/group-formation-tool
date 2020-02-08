package com.group3.forgotPassword;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.group3.BusinessModels.GuestModel;
import com.group3.DAO.DAOMockInjector;
import com.group3.DAO.IDAOInjector;
import com.group3.DAO.IUserPasswordDAO;

class ResetCodeManagerTest {

	GuestModel model = null;
	IDAOInjector daoInjector;
	IUserPasswordDAO userPasswordDAO;
	IVerificationCode verificationCode;
	GmailServiceMock gmailServiceMock;
	
	public ResetCodeManagerTest() {	
		daoInjector = new DAOMockInjector();
		userPasswordDAO = daoInjector.getUserDAOObj();
		verificationCode = new VerificationCode();
		gmailServiceMock = new GmailServiceMock();
	}
	
	@Test
	public void sendCodeEmail() {
		gmailServiceMock.setSMTPClient();
		assertThat(gmailServiceMock.properties).isNotEmpty();
		assertThat(gmailServiceMock.properties).isNotNull();
		assertThat(gmailServiceMock.session).isNotNull();
		
		gmailServiceMock.prepareMail("Test Subject", "Test Message", "Test Recepient");
		assertThat(gmailServiceMock.msg).isNotNull();
		
		assertThat(gmailServiceMock.properties).isNotNull();
		assertThat(gmailServiceMock.properties).isNotEmpty();
		
		assertThat(gmailServiceMock.msg).isNotNull();
	}
	
	@Test
	public void generateCode() {
		String code = verificationCode.getNewCode(5);
		assertThat(code).isNotNull();
		assertThat(code).isNotEmpty();
		assertEquals(code.length(),5);
	}
	
//	@Test
//	public void checkEmailIdExistance() {
//		boolean result = userPasswordDAO.isUserExist("jwick@dal.ca");
//		assertThat(result).isNotNull();
//		assertTrue(result);
//		
//		result = userPasswordDAO.isUserExist("abc@dal.ca");
//		assertThat(result).isNotNull();
//		assertFalse(result);
//	}
}
