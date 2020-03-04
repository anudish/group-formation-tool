package com.group3.course;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.web.context.WebApplicationContext;
import com.group3.groupmanager.GroupmanagerApplication;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {
	CourseController.class, GroupmanagerApplication.class
})
class CourseControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	WebApplicationContext context;

	@Test
	public void getCoursesByEmailIdTest() throws Exception {
		//		this.mockMvc.perform(get("/courseAdmin?emailId=sg@dal.ca")).andDo(print()).andExpect(status().isOk())
		//		.andExpect(model().attributeExists("courseInfo"));

		//		RequestBuilder requestBuilder = formLogin().user("sg@dal.ca").password("stevengerrard");
		//		mockMvc.perform(requestBuilder)
		//		    .andDo(print());
		//		
		//		this.mockMvc.perform(requestBuilder)
		//		.andDo(
		//		           result -> this.mockMvc.perform(get("courseAdmin?emailId=sg@dal.ca")).andDo(print())
		//		  		  	.andExpect(status().isFound())
		//		  		  		
		//		           );
		//		
		//		mockMvc
		//        .perform(formLogin().userParameter("email").user("sg@dal.ca").password("stevengerrard"))
		//        .andExpect(status().isFound())
		//        .andExpect(redirectedUrl("courseAdmin?emailId=sg@dal.ca"))
		//        .andExpect(authenticated());

	}

	@Test
	public void getSelectedCourseTest() throws Exception {

		//		RequestBuilder requestBuilder = formLogin().user("sg@dal.ca").password("stevengerrard");
		//		mockMvc.perform(requestBuilder)
		//		    .andDo(print())
		//		  ;
		//		
		//		this.mockMvc.perform(requestBuilder)
		//		.andDo(
		//		           result -> this.mockMvc.perform(get("selectCourse?courseId=csci16700&UcourseName=Visual Processing")).andDo(print())
		//		           );
		//		
	}

	//	@Test
	//	public void displayCoursePageTest() throws Exception {
	//		this.mockMvc.perform(get("/course")).andDo(print()).andExpect(status().isOk())
	//		.andExpect(model().attributeExists("courseInfo"));
	//	}
	//
	//	@Test
	//	public void displayGuestCoursePageTest() throws Exception {
	//		this.mockMvc.perform(get("/showGuestcourse")).andDo(print()).andExpect(status().isOk())
	//		.andExpect(model().attributeExists("courseInfo"));
	//	}
}