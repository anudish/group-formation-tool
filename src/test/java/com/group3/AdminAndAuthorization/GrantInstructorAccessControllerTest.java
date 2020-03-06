package com.group3.AdminAndAuthorization;


import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import com.group3.AdminAndAuthorization.DAO.*;
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
	@Autowired
	private MockMvc mockMvc;
	@BeforeEach
	void setUp() throws Exception {
		IDAOInjector injector = new DAOInjector();
	   	IViewCoursesDAO iViewCoursesDAO = injector.createViewCourseDAO();
	   	IGrantInstructorAccessDAO iGrantInstructorAccessDAO = injector.createGrantInstructorAccessDAO();
	   	IServiceInjector iServiceInjector = new ServiceInjector();
	   	IViewCoursesService iViewCoursesService = iServiceInjector.createViewCoursesService(iViewCoursesDAO);
	    IGrantInstructorAccessService iGrantInsructorAccessService = iServiceInjector.createGrantInstructorAccessService(iGrantInstructorAccessDAO);
	   	 courseList = iViewCoursesService.getAllCourses();   
	   	 userlist = iGrantInsructorAccessService.returnUserList();
	}

	@Test
	final void testGrantInstructorPage() throws Exception {
		this.mockMvc.perform(get("/grantInstructorPage")
				.with(user("user").password("password").roles("ADMIN"))).andDo(print()).andExpect(status().isOk())
		.andExpect(model().attributeExists("courseList"))
		.andExpect(model().attributeExists("userlist"));
	}

	@Test
	final void testGrantInstructorRole() throws Exception{
		
		String lastName =  userlist.get(0).getLastName();
		String firstName = userlist.get(0).getFirstName();
		String email = userlist.get(0).getEmail();
		String role = "Instructor";
		String expectedOutcome = "Instructor Assigned for "+ courseList.get(0).getCourseId();
		String CourseId = courseList.get(0).getCourseId()+"-"+courseList.get(0).getCourseName();
		String previousRole = role;
		
		if(userlist.get(0).getUserRole().equalsIgnoreCase(role)) {
			role = "Guest";
			expectedOutcome =   firstName+" "+lastName+" "+" switched their role from "+previousRole+" to "+role;
			this.mockMvc.perform(post("/GrantRoleRequest").param("lastName", lastName).param("firstName", firstName).param("email", email).param("role", role).param("CourseId",CourseId)
					.with(user("user").password("password").roles("ADMIN")))
					.andDo(print()).andExpect(status().isOk())
			.andExpect(model().attributeExists("courseList"))
			.andExpect(model().attributeExists("userlist"))
			.andExpect(model().attribute("feedbackMessage", expectedOutcome));
			
		}
		
		this.mockMvc.perform(post("/GrantRoleRequest")
				.param("lastName", lastName).param("firstName", firstName).param("email", email).param("role", role).param("CourseId",CourseId)
				.with(user("user").password("password").roles("ADMIN")))
				.andDo(print()).andExpect(status().isOk())
		.andExpect(model().attributeExists("courseList"))
		.andExpect(model().attributeExists("userlist"))
		.andExpect(model().attribute("feedbackMessage", expectedOutcome));
		
		expectedOutcome = firstName+" "+lastName+" "+"is already an instructor for the course "+courseList.get(0).getCourseId();
		this.mockMvc.perform(post("/GrantRoleRequest").param("lastName", lastName).param("firstName", firstName).param("email", email).param("role", role).param("CourseId",CourseId)
				.with(user("user").password("password").roles("ADMIN"))).andDo(print()).andExpect(status().isOk())
		.andDo(print()).andExpect(status().isOk())
		.andExpect(model().attributeExists("courseList"))
		.andExpect(model().attributeExists("userlist"))
		.andExpect(model().attribute("feedbackMessage", expectedOutcome));
		
		
		
		
		
		role = "Guest";
		expectedOutcome =   firstName+" "+lastName+" "+" switched their role from "+previousRole+" to "+role;
		this.mockMvc.perform(post("/GrantRoleRequest").param("lastName", lastName).param("firstName", firstName).param("email", email).param("role", role).param("CourseId",CourseId)
				.with(user("user").password("password").roles("ADMIN")))
				.andDo(print()).andExpect(status().isOk())
		.andExpect(model().attributeExists("courseList"))
		.andExpect(model().attributeExists("userlist"))
		.andExpect(model().attribute("feedbackMessage", expectedOutcome));
		
		
	}

}
