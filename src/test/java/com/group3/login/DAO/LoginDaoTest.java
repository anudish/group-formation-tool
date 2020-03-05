package com.group3.login.DAO;

import com.group3.BusinessModels.LoginForm;
import com.group3.groupmanager.GroupmanagerApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GroupmanagerApplication.class)
public class LoginDaoTest {

	private static final String TEST_EMAIL_1 = "admin@dal.ca";
	private static final String TEST_EMAIL_2 = "incorrectEmail@dal.ca";
	private static final String TEST_ROLE = "Admin";

	private LoginForm user;
	private String role;

	IDAOAbstractFactory daoInjector;
	ILoginDAO loginDao;

	@Before
	public void setUp() {

		daoInjector = DAOAbstractFactory.instance();
		loginDao = daoInjector.createLoginDAO();
	}

	@Test
	public void findByCorrectEmail_returnCorrectUser() {

		user = loginDao.getUserByEmail(TEST_EMAIL_1);
		assertThat(user).isNotNull();
		assertThat(user.getEmail()).isEqualTo(TEST_EMAIL_1);
	}

	@Test
	public void findByIncorrectEmail_returnNull() {

		user = loginDao.getUserByEmail(TEST_EMAIL_2);
		assertThat(user).isNull();
	}

	@Test
	public void findByCorrectEmail_returnCorrectRole() {

		role = loginDao.getRoleByEmail(TEST_EMAIL_1);
		assertThat(role).isNotNull().isNotEmpty();
		assertThat(role).isEqualTo(TEST_ROLE);
	}

	@Test
	public void findByInCorrectEmail_returnNull() {

		role = loginDao.getRoleByEmail(TEST_EMAIL_2);
		assertThat(role).isNullOrEmpty();
	}
}