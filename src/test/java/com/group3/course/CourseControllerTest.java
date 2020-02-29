package com.group3.course;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import com.group3.AdminAndAuthorization.AdminDashBoardMainPageController;
import com.group3.groupmanager.GroupmanagerApplication;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {CourseController.class,GroupmanagerApplication.class})
class CourseControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	WebApplicationContext context;
			
	@Test
	public void getCoursesByEmailIdTest() throws Exception {
//		this.mockMvc.perform(get("/courseAdmin")).andDo(print()).andExpect(status().isOk())
//		.andExpect(model().attributeExists("courseInfo"));
	}
	
	@Test
	public void getSelectedCourseTest() throws Exception {
//		 this.mockMvc.perform(get("/selectCourse").param("courseId", "csci7000").param("courseName", "Visual Processing")).andDo(print())
//		 .andExpect(status().isOk());  
	}

	@Test
	public void displayCoursePageTest() throws Exception {
		this.mockMvc.perform(get("/course")).andDo(print()).andExpect(status().isOk())
		.andExpect(model().attributeExists("courseInfo"));
	}

	@Test
	public void displayGuestCoursePageTest() throws Exception {
		this.mockMvc.perform(get("/showGuestcourse")).andDo(print()).andExpect(status().isOk())
		.andExpect(model().attributeExists("courseInfo"));
	}
}
