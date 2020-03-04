package com.group3.Services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group3.BusinessModels.Course;
import com.group3.Services.ICourseInputValidation;
import com.group3.Services.ServiceInjector;

class CourseInputValidationTest {
	ICourseInputValidation courseInputValidation;
	String CourseId,CourseName,CourseIdErrorMesssage,CourseNameErrorMesssage;
	Course course; 
	@BeforeEach
	void setUp() throws Exception {
		course  = new Course();
		 courseInputValidation = new ServiceInjector().createCourseInputValidation();
		 CourseIdErrorMesssage = "Invalid Course Id (It Should Like : csci5308)";
		 CourseNameErrorMesssage ="Invalid Course Name (It Should start with String only)";
	}

	@Test
	final void testValidateInputCourse() {
		//fail("Not yet implemented"); // TODO
		//Failing Test Cases for Invalid Id Format
		CourseId = "CSC6400";
		CourseName = "Virtual Reality";
		
		course.setCourseId(CourseId);
		course.setCourseName(CourseName);
		
		assertTrue(courseInputValidation.validateInputCourse(course).get(0).equals(CourseIdErrorMesssage),CourseIdErrorMesssage);
		
		
		//Passing test case for Valid CourseId 
		CourseId = "CSCI5308";
		CourseName = "QA";
		course.setCourseId(CourseId);
		course.setCourseName(CourseName);
		//System.out.println("CC" +courseInputValidation.validateInputCourse(course).get(0));
		
		assertTrue(courseInputValidation.validateInputCourse(course).size()==0,"No Error condition");
		assertFalse(courseInputValidation.validateInputCourse(course).size()> 0,"No Error condition");
		
		//Failing test case for Invalid CourseName
		CourseId = "CSCI5308";
		CourseName = "12345QA";
		course.setCourseId(CourseId);
		course.setCourseName(CourseName);
		assertTrue(courseInputValidation.validateInputCourse(course).get(0).equals(CourseNameErrorMesssage),CourseNameErrorMesssage);
		
		
		//Passing Test Case for Valid CourseName
		CourseId = "CSCI5308";
		CourseName = "Quality Assurance";
		course.setCourseId(CourseId);
		course.setCourseName(CourseName);
		assertTrue(courseInputValidation.validateInputCourse(course).size()==0,"No Error condition");
		assertFalse(courseInputValidation.validateInputCourse(course).size()> 0,"No Error condition");
	}

}
