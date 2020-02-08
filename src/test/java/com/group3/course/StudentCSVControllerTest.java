package com.group3.course;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestParam;

import com.group3.AdminAndAuthorization.AdminDashBoardMainPageController;
import com.group3.groupmanager.GroupmanagerApplication;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {AdminDashBoardMainPageController.class,GroupmanagerApplication.class})
class StudentCSVControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
//	@Test
//	public void showImportXMLPageTest() throws Exception {
//		
//		this.mockMvc.perform(post("/importCSV")).andDo(print()).andExpect(status().isOk())
//		.andExpect(model().attributeExists("courseInfo"));
//	
//	}
	
	@Test
	public void uploadCSVFileTest() throws Exception{
		
		String fileName = "test.txt";
	      File file = new File(fileName);
	      //delete if exits
	      file.delete();
	      MockMultipartFile mockMultipartFile = new MockMultipartFile("file",fileName,
	              "text/plain", "hello world".getBytes());
	      MockHttpServletRequestBuilder builder =
	              MockMvcRequestBuilders.fileUpload("/upload-csv-file")
	                                    .file(mockMultipartFile);
	      
		this.mockMvc.perform(builder).andDo(print()).andExpect(status().isOk())
		.andExpect(model().attributeExists("studentList"));
		
	}

}
