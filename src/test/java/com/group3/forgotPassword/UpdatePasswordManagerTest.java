package com.group3.forgotPassword;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.group3.DAO.DAOMockInjector;
import com.group3.DAO.IDAOInjector;
import com.group3.DAO.IUserPasswordDAO;
import com.group3.DAO.UserPasswordDAOMock;
import com.group3.DAO.VerificationCodeMock;

class UpdatePasswordManagerTest {

	IDAOInjector daoInjector;
	IUserPasswordDAO userPasswordDAO;
	VerificationCodeMock verificationCodeMock;
	
	public UpdatePasswordManagerTest() {
		daoInjector = new DAOMockInjector();
		userPasswordDAO = daoInjector.getUserDAOObj();
		verificationCodeMock = new VerificationCodeMock();
	}
	
	@Test
	public void compareCode() {
		
		String generated_code = new String();
		generated_code = verificationCodeMock.getNewCode(5);
		assertEquals("TCode", generated_code);
		
	}
	
	public void updatePassword() {
		userPasswordDAO.updateNewPassword("tstark@dal.ca", "hello@123");
		String password = UserPasswordDAOMock.modelTest2.getEncryptedPassword();
		assertThat(password).isNotNull();
		assertThat(password).isNotEmpty();
		assertEquals("hello@123", password);
	}

}