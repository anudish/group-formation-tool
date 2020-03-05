package com.group3.AdminAndAuthorization.Services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


import com.group3.AdminAndAuthorization.DAO.IAddCourseDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group3.BusinessModels.Course;
import com.group3.AdminAndAuthorization.DAO.DAOMockInjector;
import com.group3.AdminAndAuthorization.*;
import com.group3.AdminAndAuthorization.Services.ServiceInjector;
import com.group3.AdminAndAuthorization.Services.IAddCourseService;
import com.group3.AdminAndAuthorization.Services.ICourseInputValidation;
class AddCourseServiceTest {
	IAddCourseService iAddCourseService;
	ICourseInputValidation iCourseInputValidation;
	ArrayList<String> feedbackMessage;
	@BeforeEach
	void setUp() throws Exception {
		IAddCourseDAO iAddCourseDAO  = new DAOMockInjector().createAddCourseDAO();
		iAddCourseService = new ServiceInjector().createaddCourseService(iAddCourseDAO);
		 iCourseInputValidation = new ServiceInjector().createCourseInputValidation();
		 feedbackMessage = new ArrayList<>();
		
		
	}

	@Test
	final void testAddCourseService() {
		
		Course course = new Course();
	    course.setCourseId("CS135"); //False Pattern for course
	    course.setCourseName("Software Engineering");
	    feedbackMessage =  iAddCourseService.insertCourseDetails(course, iCourseInputValidation);
		String expectedErrorMessage = "Invalid Course Id (It Should Like : csci5308)";
		assertTrue(feedbackMessage.get(0).equals(expectedErrorMessage));
		
		 feedbackMessage.clear();
		course = new Course();
		course.setCourseId("CSCI5308");
		course.setCourseName("Quality Assurance");

		String expectedResponse = "Course Name  "+course.getCourseName()+" with "+"Course ID "+course.getCourseId()+" already exists !! ";
		feedbackMessage =  iAddCourseService.insertCourseDetails(course, iCourseInputValidation);
		IAddCourseDAO iAddCourseDAO  = new DAOMockInjector().createAddCourseDAO();
		iAddCourseService = new ServiceInjector().createaddCourseService(iAddCourseDAO);
		assertTrue(feedbackMessage.get(0).equals(expectedResponse));
		 feedbackMessage.clear();

		course.setCourseId("CSCI6707");
		course.setCourseName("Advanced Game Development");
		feedbackMessage =  iAddCourseService.insertCourseDetails(course, iCourseInputValidation);
		expectedResponse   = course.getCourseName() + " with "+course.getCourseId()+" created successfully";
		System.out.println(" CC : "+feedbackMessage.get(0));
		System.out.println(expectedResponse);
		assertTrue(feedbackMessage.get(0).equals(expectedResponse));
	}

	@Test
	final void testInsertCourseDetails() {
		
	}

}
