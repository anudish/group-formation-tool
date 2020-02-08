//package com.group3.AdminAndAuthorization;
//
//import static org.hamcrest.CoreMatchers.containsString;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//@SpringBootTest(classes= {AdminLogOutController.class})
//@AutoConfigureMockMvc
//class AdminLogOutControllerTest {
//    
//	
//	@Autowired
//	private MockMvc mockMvc;
//
//	@Test
//	final void testAdminLogout() throws Exception {
//		this.mockMvc.perform(get("/adminLogout")).andDo(print()).andExpect(status().isOk())
//		.andExpect(content().string(containsString("")));
//	}
//
//}
