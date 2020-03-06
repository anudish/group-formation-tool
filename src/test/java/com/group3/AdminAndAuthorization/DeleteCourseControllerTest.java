package com.group3.AdminAndAuthorization;


import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.group3.BusinessModels.Course;
import com.group3.AdminAndAuthorization.DAO.DAOInjector;
import com.group3.AdminAndAuthorization.DAO.IAddCourseDAO;
import com.group3.AdminAndAuthorization.DAO.IViewCoursesDAO;
import com.group3.AdminAndAuthorization.Services.IViewCoursesService;
import com.group3.AdminAndAuthorization.Services.ServiceInjector;
import com.group3.groupmanager.GroupmanagerApplication;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {
		AdminDashBoardMainPageController.class, GroupmanagerApplication.class })
class DeleteCourseControllerTest {
	ArrayList<Course> courseList;
	Course course;
	String CourseId, CourseName;
	@Autowired
	private MockMvc mockMvc;
	private IAddCourseDAO iAddcourseDAO;

	@BeforeEach
	void setUp() throws Exception {
		DAOInjector injector = new DAOInjector();
		IViewCoursesDAO iViewCoursesDAO = injector.createViewCourseDAO();
		IViewCoursesService iViewCoursesService = new ServiceInjector().createViewCoursesService(iViewCoursesDAO);
		courseList = iViewCoursesService.getAllCourses();
		iAddcourseDAO = injector.createAddCourseDAO();
		course = courseList.get(0);
		CourseId = course.getCourseId();
		CourseName = course.getCourseName();

	}

	@Test
	final void testDeleteCoursePage() throws Exception {
		this.mockMvc.perform(get("/DeleteCoursePage")
				.with(user("user").password("passwrd").roles("ADMIN"))).andDo(print()).andExpect(status().isOk());
		iAddcourseDAO.addCourse(course);
	}

	@Test
	final void testDeleteCourseRequest() throws Exception {

		course = courseList.get(0);
		String CourseId = course.getCourseId();
		String CourseName = course.getCourseName();
		String expectedMessage = course.getCourseName() + " (" + course.getCourseId() + ") "
				+ " is deleted sucessfully ";
		this.mockMvc.perform(post("/deleteCourse").param("CourseId", CourseId).param("CourseName", CourseName)
				.with(user("user").password("password").roles("ADMIN")))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(model().attribute("feedBackMessage", expectedMessage));
	}

}
