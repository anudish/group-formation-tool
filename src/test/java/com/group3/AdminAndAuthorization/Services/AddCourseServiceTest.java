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

	public AddCourseServiceTest() {
		IAddCourseDAO iAddCourseDAO  = DAOMockInjector.instance().createAddCourseDAO();
		iAddCourseService = ServiceInjector.instance().createaddCourseService(iAddCourseDAO);
		 iCourseInputValidation = new ServiceInjector().createCourseInputValidation();
		 feedbackMessage = new ArrayList<>();
		
		
	}

	@Test
	final void testAddCourseService() {
		feedbackMessage = new ArrayList<>();
		Course course = new Course();
	    course.setCourseId("CS135"); //False Pattern for course
	    course.setCourseName("Software Engineering");
	    feedbackMessage =  iAddCourseService.insertCourseDetails(course, iCourseInputValidation);
		String expectedErrorMessage = "Invalid Course Id (It Should Like : csci5308)";
		assertTrue(feedbackMessage.get(0).equals(expectedErrorMessage));
		


	}
	@Test
	final void testAddCourseServiceAlreadyExist(){
		feedbackMessage = new ArrayList<>();
		Course course = new Course();
		course.setCourseId("CSCI5308");
		course.setCourseName("Quality Assurance");

		String expectedResponse = "Course Name  "+course.getCourseName()+" with "+"Course Id "+course.getCourseId()+" already exists !! ";
		IAddCourseDAO iAddCourseDAO  = DAOMockInjector.instance().createAddCourseDAO();
		feedbackMessage =  iAddCourseService.insertCourseDetails(course, iCourseInputValidation);

		iAddCourseService = ServiceInjector.instance().createaddCourseService(iAddCourseDAO);


		System.out.println(feedbackMessage.get(0)+"\n"+expectedResponse+" "+feedbackMessage.get(0).equals(expectedResponse));
		assertTrue(feedbackMessage.get(0).equals(expectedResponse));
	}
	@Test
	final void testAddCourseServiceCreatedSuccess(){
		feedbackMessage = new ArrayList<>();
		Course course = new Course();
		course.setCourseId("CSCT6707");
		course.setCourseName("Advanced Game Development");
		feedbackMessage =  iAddCourseService.insertCourseDetails(course, iCourseInputValidation);
		String expectedResponse   = course.getCourseName() + " with "+course.getCourseId()+" created successfully";
		System.out.println(" CC : "+feedbackMessage.get(0));
		System.out.println(expectedResponse);
		assertTrue(feedbackMessage.get(0).equals(expectedResponse));
	}
	@Test
	final void testInsertCourseDetails() {
		
	}

}
