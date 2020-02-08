//package com.group3.forgotPassword;
//
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
//
//
//
//@SpringBootTest(classes= {forgetPasswordController.class})
//@AutoConfigureMockMvc
//
//
//public class forgetPasswordControllerTest {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@Test
//	public void enterEmailTest()
//	{
//		try {
//			this.mockMvc.perform(get("/enterEmail")).andDo(print()).andExpect(status().isOk());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void enterCode()
//	{
//		try {
//			this.mockMvc.perform(post("/enterCode").param("email","falgun@dal.ca")).andDo(print()).andExpect(status().isOk())
//			.andExpect(model().attributeExists("status"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//	
//	@Test
//	public void checkCode()
//	{
//		try {
//			this.mockMvc.perform(post("/checkCode").param("code_input","TmpCode")).andDo(print()).andExpect(status().isOk())
//			.andExpect(model().attributeExists("invalidcode"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void passwordUpdator()
//	{			
//		try {
//			this.mockMvc.perform(post("/checkCode").param("password","tmppassword")).andDo(print()).andExpect(status().isOk());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}
