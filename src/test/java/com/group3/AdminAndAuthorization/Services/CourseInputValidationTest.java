package com.group3.AdminAndAuthorization.Services;

import static org.junit.jupiter.api.Assertions.*;

import com.group3.AdminAndAuthorization.Services.ServiceInjector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group3.BusinessModels.Course;
import com.group3.AdminAndAuthorization.Services.ICourseInputValidation;

class CourseInputValidationTest {
	ICourseInputValidation courseInputValidation;
	String CourseId,CourseName,CourseIdErrorMesssage,CourseNameErrorMesssage;
	Course course;

	public CourseInputValidationTest() {
		course  = new Course();
		 courseInputValidation = new ServiceInjector().createCourseInputValidation();
		 CourseIdErrorMesssage = "Invalid Course Id (It Should Like : csci5308)";
		 CourseNameErrorMesssage ="Invalid Course Name (It Should start with String only)";
	}

	@Test
	final void testValidateInputCourseInValidCourseId() {

		CourseId = "CSC6400";
		CourseName = "Virtual Reality";
		
		course.setCourseId(CourseId);
		course.setCourseName(CourseName);
		
		assertTrue(courseInputValidation.validateInputCourse(course).get(0).equals(CourseIdErrorMesssage),CourseIdErrorMesssage);
		
		



	}

	@Test
	public void testValidateInputCourseValidCourseId(){

		CourseId = "CSCI5308";
		CourseName = "QA";
		course.setCourseId(CourseId);
		course.setCourseName(CourseName);
		assertTrue(courseInputValidation.validateInputCourse(course).size()==0,"No Error condition");
		assertFalse(courseInputValidation.validateInputCourse(course).size()> 0,"No Error condition");


	}
	@Test
	public void testValidateInputCourseInValidCourseName(){
		CourseId = "CSCI5308";
		CourseName = "12345QA";
		course.setCourseId(CourseId);
		course.setCourseName(CourseName);
		assertTrue(courseInputValidation.validateInputCourse(course).get(0).equals(CourseNameErrorMesssage),CourseNameErrorMesssage);

	}
	@Test
	public void testValidateInputCourseValidCourseName(){
		CourseId = "CSCI5308";
		CourseName = "Quality Assurance";
		course.setCourseId(CourseId);
		course.setCourseName(CourseName);
		assertTrue(courseInputValidation.validateInputCourse(course).size()==0,"No Error condition");
		assertFalse(courseInputValidation.validateInputCourse(course).size()> 0,"No Error condition");
	}
}
