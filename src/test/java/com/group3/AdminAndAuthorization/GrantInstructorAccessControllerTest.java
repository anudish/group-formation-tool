package com.group3.AdminAndAuthorization;


import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import com.group3.AdminAndAuthorization.DAO.*;
import com.group3.signup.DAO.DAOAbstractFactory;
import com.group3.signup.DAO.IUserDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.group3.BusinessModels.Course;
import com.group3.BusinessModels.GuestModel;

import com.group3.AdminAndAuthorization.Services.IServiceInjector;
import com.group3.AdminAndAuthorization.Services.IViewCoursesService;
import com.group3.AdminAndAuthorization.Services.ServiceInjector;
import com.group3.groupmanager.GroupmanagerApplication;
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {AdminDashBoardMainPageController.class,GroupmanagerApplication.class})
class GrantInstructorAccessControllerTest {
	ArrayList<Course> courseList;
	ArrayList<GuestModel> userlist;
	IUserDAO iUserDAO;
	IDeleteUserDAO iDeleteUserDAO;
	IAddCourseDAO iAddCourseDAO;
	IDeleteCourseDAO iDeleteCourseDAO;
	@Autowired
	private MockMvc mockMvc;

	public  GrantInstructorAccessControllerTest() {
		IDAOInjector injector = DAOInjector.instance();
	   	IViewCoursesDAO iViewCoursesDAO = injector.createViewCourseDAO();
	   	IGrantInstructorAccessDAO iGrantInstructorAccessDAO = injector.createGrantInstructorAccessDAO();
	   	IServiceInjector iServiceInjector = ServiceInjector.instance();
	   	IViewCoursesService iViewCoursesService = iServiceInjector.createViewCoursesService(iViewCoursesDAO);
	    IGrantInstructorAccessService iGrantInsructorAccessService = iServiceInjector.createGrantInstructorAccessService(iGrantInstructorAccessDAO);
	   	 courseList = iViewCoursesService.getAllCourses();   
	   	 userlist = iGrantInsructorAccessService.returnUserList();
	   	 iUserDAO = DAOAbstractFactory.instance().createUserDAO();
	   	 iDeleteUserDAO = DAOInjector.instance().createDeleteUserDAO();
	   	 iAddCourseDAO  = DAOInjector.instance().createAddCourseDAO();
	   	 iDeleteUserDAO = DAOInjector.instance().createDeleteUserDAO();
	}

	@Test
	final void testGrantInstructorPage() throws Exception {
		this.mockMvc.perform(get("/grantInstructorPage")
				.with(user("user").password("password").roles("ADMIN"))).andDo(print()).andExpect(status().isOk())
		.andExpect(model().attributeExists("courseList"))
		.andExpect(model().attributeExists("userlist"));
	}


	@Test
	final void testGrantInstructorsRoleSwitching() throws Exception{
		String email = "justin@dal.ca";
		String firstName = "Justin";
		String lastName = "Treadue";
		String previousRole = "Guest";
		String expectedRole ="Instructor";
		String pass ="Hello@123";
		GuestModel guestModel = new GuestModel();
		guestModel.setEmail(email);
		guestModel.setFirstName(firstName);
		guestModel.setLastName(lastName);
		guestModel.setUserRole(previousRole);
		guestModel.setEncryptedPassword(pass);
		Course course = new Course();
		course.setCourseName("Data Technology");
		course.setCourseId("CSCT5111");

		iUserDAO.getSignUpDetailsofUser(guestModel);
		String courseId = course.getCourseId()+"-"+course.getCourseName();
		String expectedOutcome =   firstName+" "+lastName+" "+" switched their role from "+previousRole+" to "+expectedRole;
		this.mockMvc.perform(post("/GrantRoleRequest").param("lastName", lastName).param("firstName", firstName).param("email", email).param("role", expectedRole).param("CourseId",courseId)
				.with(user("user").password("password").roles("ADMIN")))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(model().attributeExists("courseList"))
				.andExpect(model().attributeExists("userlist"))
				.andExpect(model().attributeExists("feedbackMessage"));
		iDeleteUserDAO.deleteUser(email);

	}
}
