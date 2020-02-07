package com.group3.BusinessModels;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseTest {
    Course testcourse; 


	@Test
	final void testGetCourseID() {
		testcourse = new Course();
		
		assertNull(testcourse.getCourseID());
		
		testcourse.setCourseID("CSCI5308");
		
		assertNotNull(testcourse.getCourseID());
		
		
	}

	@Test
	final void testSetCourseID() {
		testcourse = new Course();
		testcourse.setCourseID("CSCI5608");
		assertNotEquals("CSCI5408",testcourse.getCourseID());
		assertEquals("CSCI5608",testcourse.getCourseID());
	}

	@Test
	final void testGetCourseName() {
		
		testcourse = new Course();
		
		assertNull(testcourse.getCourseName());
		
		testcourse.setCourseName("Cyber Security");
		
		assertNotNull(testcourse.getCourseName());
		
		
	}

	@Test
	final void testSetCourseName() {
		testcourse = new Course();
		testcourse.setCourseName("Coordinate Geomentry Applications");
		assertNotEquals("Coordinate Geomentry",testcourse.getCourseName());
		assertEquals("Coordinate Geomentry Applications",testcourse.getCourseName());
	}

}
