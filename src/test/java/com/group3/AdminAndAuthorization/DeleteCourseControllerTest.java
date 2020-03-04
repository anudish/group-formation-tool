package com.group3.AdminAndAuthorization;


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
import com.group3.DAO.DAOInjector;
import com.group3.DAO.IAddCourseDAO;
import com.group3.DAO.IViewCoursesDAO;
import com.group3.Services.IViewCoursesService;
import com.group3.Services.ServiceInjector;
import com.group3.groupmanager.GroupmanagerApplication;
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {AdminDashBoardMainPageController.class,GroupmanagerApplication.class})
class DeleteCourseControllerTest {
	ArrayList<Course> courseList;
	Course course;
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
	}

	@Test
	final void testDeleteCoursePage() throws Exception {
		
		this.mockMvc.perform(get("/DeleteCoursePage")).andDo(print()).andExpect(status().isOk())
		.andExpect(model().attributeExists("courseList"));
		
		
	}

	@Test
	final void testDeleteCourseRequest() throws Exception {
		
		course = courseList.get(0); 
		String CourseId = course.getCourseId();
		String CourseName = course.getCourseName();
		
		String expectedMessage = course.getCourseName()+" ("+course.getCourseId()+") "+" is deleted sucessfully ";
		this.mockMvc.perform(post("/deleteCourse").param("CourseId", CourseId).param("CourseName", CourseName)).andDo(print()).andExpect(status().isOk())
		.andExpect(model().attributeExists("courseList")).andExpect(model().attribute("feedBackMessage", expectedMessage));
		
		 iAddcourseDAO.addCourse(course);
		
	}

}
