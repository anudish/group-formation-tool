package com.group3.DAO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group3.BusinessModels.Course;

class DeleteCourseDAOTest {
	private IAddCourseDAO iaddCourseDAO;
	private IDeleteCourseDAO iDeleteCourseDAO;
	private Course course;
	private String CourseName,CourseId;
	@BeforeEach
	void setUp() throws Exception {
		course = new Course();
		 CourseName = "Penentration Testing(Cyber)";
	     CourseId = "CSCI6786";
		course.setCourseId(CourseId);
		course.setCourseName(CourseName);
 	    DAOInjector daoinjector = new DAOInjector();
 	    iaddCourseDAO  = daoinjector.createAddCourseDAO();
 	   iDeleteCourseDAO = daoinjector.createDeleteCourseDAO();
	}

	@Test
	final void testDeleteCourse() {
		String expectedOutCome = course.getCourseName()+" ("+course.getCourseId()+") "+" is deleted sucessfully ";
		assertFalse(this.iDeleteCourseDAO.deleteCourse(course).equals(expectedOutCome));
		
		this.iaddCourseDAO.addCourse(course);
		
		assertTrue(this.iDeleteCourseDAO.deleteCourse(course).equals(expectedOutCome));
		
	}

}
