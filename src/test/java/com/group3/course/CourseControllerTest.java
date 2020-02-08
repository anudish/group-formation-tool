package com.group3.course;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootTest(classes= {CourseController.class})
@AutoConfigureMockMvc
class CourseControllerTest {

	@Autowired
	private MockMvc mockMvc;
		
	@Test
	public void getCoursesByEmailId() throws Exception {
		this.mockMvc.perform(get("/courseAdmin").param("emailId", "anist@dal.ca")).andDo(print()).andExpect(status().isOk())
		.andExpect(model().attributeExists("courseInfo"));
	}
	
	@Test
	public void getSelectedCourse() throws Exception {
		this.mockMvc.perform(get("/selectCourse").param("courseId", "csci6406").param("courseName", "Visualisation")).andDo(print()).andExpect(status().isOk())
		.andExpect(model().attributeExists("courseInfo"));
	}


}
