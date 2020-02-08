//package com.group3.AdminAndAuthorization;
//
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.group3.BusinessModels.Course;
//import com.group3.DAO.DAOInjector;
//import com.group3.DAO.IAddCourseDAO;
//import com.group3.DAO.IViewCoursesDAO;
//import com.group3.Services.IViewCoursesService;
//import com.group3.Services.ServiceInjector;
//@SpringBootTest(classes= {DeleteCourseController.class})
//@AutoConfigureMockMvc
//class DeleteCourseControllerTest {
//	ArrayList<Course> courseList;
//	Course course;
//	@Autowired
//	private MockMvc mockMvc;
//	private IAddCourseDAO iAddcourseDAO;
//	
//	@BeforeEach
//	void setUp() throws Exception {
//		 DAOInjector injector = new DAOInjector();
//	   	 IViewCoursesDAO iViewCoursesDAO = injector.createViewCourseDAO();
//	   	 IViewCoursesService iViewCoursesService = new ServiceInjector().createViewCoursesService(iViewCoursesDAO);
//	   	  courseList = iViewCoursesService.getAllCourses();
//	   	  iAddcourseDAO = injector.createAddCourseDAO();
//	}
//
//	@Test
//	final void testDeleteCoursePage() throws Exception {
//		
//		this.mockMvc.perform(get("/DeleteCoursePage")).andDo(print()).andExpect(status().isOk())
//		.andExpect(model().attributeExists("courseList"));
//		
//		
//	}
//
//	@Test
//	final void testDeleteCourseRequest() throws Exception {
//		
//		course = courseList.get(0); 
//		String CourseId = course.getCourseID();
//		String CourseName = course.getCourseName();
//		
//		String expectedMessage = course.getCourseName()+" ("+course.getCourseID()+") "+" is deleted sucessfully ";
//		this.mockMvc.perform(post("/deleteCourse").param("CourseID", CourseId).param("CourseName", CourseName)).andDo(print()).andExpect(status().isOk())
//		.andExpect(model().attributeExists("courseList")).andExpect(model().attribute("feedBackMessage", expectedMessage));
//		
//		 iAddcourseDAO.addCourse(course);
//		
//	}
//
//}
