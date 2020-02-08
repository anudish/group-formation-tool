//package com.group3.AdminAndAuthorization;
//
//import static org.hamcrest.CoreMatchers.containsString;
//import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//@SpringBootTest(classes= {AdminDashBoardMainPageController.class})
//@AutoConfigureMockMvc
//class AdminDashBoardMainPageControllerTest {
//    
//	@Autowired
//	  private WebApplicationContext context;
//	
//	private MockMvc mockMvc;
//	
//	
//	@Before
//	  public void setup() {
//	    mockMvc = MockMvcBuilders
//	            .webAppContextSetup(context)
//	            .apply(springSecurity())
//	            .alwaysDo(print())
//	            .build();
//	  }
//	
//	@Test
//	final void testReturnAdminDashBoardPage() throws Exception {
//		mockMvc.perform(get("/adminMainPageRequest")).andDo(print()).andExpect(status().isOk())
//		.andExpect(content().string(containsString("")));
//	}
//
//}
