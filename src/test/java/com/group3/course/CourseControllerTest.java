//package com.group3.course;
//
//import static org.hamcrest.CoreMatchers.containsString;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.group3.AdminAndAuthorization.AdminDashBoardMainPageController;
//import com.group3.groupmanager.GroupmanagerApplication;
//
//
//@RunWith(SpringRunner.class)
//@AutoConfigureMockMvc
//@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {AdminDashBoardMainPageController.class,GroupmanagerApplication.class})
//class CourseControllerTest {
//
//	@Autowired
//	private MockMvc mockMvc;
//		
//	@Test
//	public void getCoursesByEmailId() throws Exception {
//		this.mockMvc.perform(get("/courseAdmin")).andDo(print()).andExpect(status().isOk())
//		.andExpect(model().attributeExists("courseInfo"));
//	}
//	
//	@Test
//	public void getSelectedCourse() throws Exception {
//		this.mockMvc.perform(get("/selectCourse").param("courseId", "CSCI6406").param("courseName", "Visualisation")).andDo(print()).andExpect(status().isOk())
//		.andExpect(model().attributeExists("courseInfo"));
//	}
//
//
//
//}
