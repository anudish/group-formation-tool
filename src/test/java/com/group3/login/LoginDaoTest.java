package com.group3.login;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.group3.BusinessModels.LoginForm;
import com.group3.DAO.DAOInjector;
import com.group3.DAO.LoginDao;
import com.group3.groupmanager.GroupmanagerApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GroupmanagerApplication.class)
public class LoginDaoTest {

	private static final String TEST_EMAIL_1 = "admin@dal.ca";
	private static final String TEST_EMAIL_2 = "incorrectEmail@dal.ca";

	private static final String TEST_ROLE = "Admin";

	private LoginForm user;
	private String role;


	DAOInjector daoInjector;
	LoginDao loginDao;

	@Before
	public void setUp() {
		daoInjector = new DAOInjector();
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