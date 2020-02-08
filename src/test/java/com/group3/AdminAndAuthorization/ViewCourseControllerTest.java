//package com.group3.AdminAndAuthorization;
//
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//@SpringBootTest(classes= {ViewCourseController.class})
//@AutoConfigureMockMvc
//class ViewCourseControllerTest {
//    
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
//	@Test
//	final void testViewCoursePage() throws Exception {
//		this.mockMvc.perform(get("/ViewCoursesPage")).andDo(print()).andExpect(status().isOk())
//		.andExpect(model().attributeExists("courseList"));
//		
//	}
//
//}
