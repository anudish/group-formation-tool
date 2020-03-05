package com.group3.signup.Services;

import com.group3.BusinessModels.GuestModel;
import com.group3.signup.DAO.DAOMockAbstractFactory;
import com.group3.signup.DAO.IDAOAbstractFactory;
import com.group3.signup.DAO.IUserDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDetailsServiceTest {
	@InjectMocks
    UserDetailsService useService;

	@Mock
    GuestModel mockUserModel;
	@Mock
    GuestModel mockUserBadEmailModel;

	IUserDAO userDAO;
	IDAOAbstractFactory daoInjector;
	IUserDetailsService userDetails;

	@BeforeEach
	void setUp() throws Exception {

		daoInjector = DAOMockAbstractFactory.instance();
		userDAO = daoInjector.createUserDAO();
		MockitoAnnotations.initMocks(this);
		mockUserModel = new GuestModel("lastname", "User", "User@gmail.com", "Guest", "Password@1234");
		mockUserBadEmailModel = new GuestModel("lastname", "User", "User@gmail", "Guest", "Password@1234");

	}

	@Test
	void SignUptest() {

		String message;

		userDetails = new UserDetailsService(userDAO);
		message = userDetails.saveUser(mockUserModel.getLastName(), mockUserModel.getFirstName(),
			mockUserModel.getEmail(), mockUserModel.getEncryptedPassword(), mockUserModel.getEncryptedPassword());
		assertEquals(UserVerificationParameters.SIGNUP_SUCCESS, message);

		message = userDetails.saveUser(mockUserModel.getLastName(), mockUserModel.getFirstName(),
			mockUserModel.getEmail(), mockUserModel.getEncryptedPassword(), mockUserModel.getEncryptedPassword());
		assertEquals(UserVerificationParameters.USER_EXISTS, message);
	}

	@Test
	void Emailtest() {

		String message;

		userDetails = new UserDetailsService(userDAO);
		message = userDetails.saveUser(mockUserBadEmailModel.getLastName(), mockUserBadEmailModel.getFirstName(),
			mockUserBadEmailModel.getEmail(), mockUserBadEmailModel.getEncryptedPassword(),
			mockUserModel.getEncryptedPassword());
		assertEquals(UserVerificationParameters.INVALID_EMAIL, message);
	}

	@Test
	void Passwordtest() {

		String message;

		userDetails = new UserDetailsService(userDAO);
		message = userDetails.saveUser(mockUserBadEmailModel.getLastName(), mockUserBadEmailModel.getFirstName(),
			mockUserBadEmailModel.getEmail(), mockUserBadEmailModel.getEncryptedPassword(), "Aspirant@0909121");
		assertEquals(UserVerificationParameters.INVALID_PASSWORD_EMAIL, message);

		message = userDetails.saveUser(mockUserModel.getLastName(), mockUserModel.getFirstName(), "get123@dal.ca",
			mockUserModel.getEncryptedPassword(), "Aspirant@0909121");
		assertEquals(UserVerificationParameters.INVALID_PASSWORD, message);
	}
}