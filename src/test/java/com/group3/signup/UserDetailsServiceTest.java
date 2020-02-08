package com.group3.signup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.group3.BusinessModels.GuestModel;
import com.group3.DAO.DAOMockInjector;
import com.group3.DAO.IDAOInjector;
import com.group3.DAO.IUserDAO;
import com.group3.DAO.UserDAOMock;

class UserDetailsServiceTest {
	@InjectMocks
	UserDetailsService useService;

	@Mock
	GuestModel mockUserModel;
	@Mock
	GuestModel mockUserBadEmailModel;

	IUserDAO iUserDAO;
	IDAOInjector injector;
	IUserDetailsService iUserDetails;

	@BeforeEach
	void setUp() throws Exception {
		injector = new DAOMockInjector();
		iUserDAO = injector.createUserDAO();
		MockitoAnnotations.initMocks(this);
		mockUserModel = new GuestModel("lastname", "User", "User@gmail.com", "Guest", "Password@1234");
		mockUserBadEmailModel = new GuestModel("lastname", "User", "User@gmail", "Guest", "Password@1234");

	}

	@Test
	void test() {
		iUserDAO = new UserDAOMock();
		iUserDetails = new UserDetailsService(iUserDAO);
		String message = iUserDetails.saveUser(mockUserModel.getLastName(), mockUserModel.getFirstName(),
				mockUserModel.getEmail(), mockUserModel.getEncryptedPassword(), mockUserModel.getEncryptedPassword());
		assertEquals(UserVerificationParameters.SIGNUP_SUCCESS, message);
		message = iUserDetails.saveUser(mockUserModel.getLastName(), mockUserModel.getFirstName(),
				mockUserModel.getEmail(), mockUserModel.getEncryptedPassword(), mockUserModel.getEncryptedPassword());
		assertEquals(UserVerificationParameters.USER_EXISTS, message);
		message = iUserDetails.saveUser(mockUserBadEmailModel.getLastName(), mockUserBadEmailModel.getFirstName(),
				mockUserBadEmailModel.getEmail(), mockUserBadEmailModel.getEncryptedPassword(),
				mockUserModel.getEncryptedPassword());
		assertEquals(UserVerificationParameters.INVALID_EMAIL, message);
		message = iUserDetails.saveUser(mockUserBadEmailModel.getLastName(), mockUserBadEmailModel.getFirstName(),
				mockUserBadEmailModel.getEmail(), mockUserBadEmailModel.getEncryptedPassword(), "Aspirant@0909121");
		assertEquals(UserVerificationParameters.INVALID_PASSWORD_EMAIL, message);
		message = iUserDetails.saveUser(mockUserModel.getLastName(), mockUserModel.getFirstName(), "get123@dal.ca",
				mockUserModel.getEncryptedPassword(), "Aspirant@0909121");
		assertEquals(UserVerificationParameters.INVALID_PASSWORD, message);

	}

}
