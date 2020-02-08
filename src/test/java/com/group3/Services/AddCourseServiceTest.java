package com.group3.Services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group3.BusinessModels.Course;
import com.group3.DAO.DAOMockInjector;
import com.group3.DAO.IAddCourseDAO;

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
	    course.setCourseID("CS135"); //False Pattern for course
	    course.setCourseName("Software Engineering");
	    feedbackMessage =  iAddCourseService.insertCourseDetails(course, iCourseInputValidation);
		String expectedErrorMessage = "Invalid Course Id (It Should Like : csci5308)";
		assertTrue(feedbackMessage.get(0).equals(expectedErrorMessage));
		
		 feedbackMessage.clear();
		// Check for existing course
		course.setCourseID("CSCI5308");
		course.setCourseName("Quality Assurance");
		
		String expectedResponse = "Course Name  "+course.getCourseName()+" with "+"Course ID "+course.getCourseID()+" already exists !! ";;
		feedbackMessage =  iAddCourseService.insertCourseDetails(course, iCourseInputValidation);
		
		assertTrue(feedbackMessage.get(0).equals(expectedResponse));
		 feedbackMessage.clear();
		//successful entry
		course.setCourseID("CSCI6707");
		course.setCourseName("Advanced Game Development");
		feedbackMessage =  iAddCourseService.insertCourseDetails(course, iCourseInputValidation);
		expectedResponse   = course.getCourseName() + " with "+course.getCourseID()+" created successfully";
		System.out.println(" CC : "+feedbackMessage.get(0));
		System.out.println(expectedResponse);
		assertTrue(feedbackMessage.get(0).equals(expectedResponse));
	}

	@Test
	final void testInsertCourseDetails() {
		
	}

}
