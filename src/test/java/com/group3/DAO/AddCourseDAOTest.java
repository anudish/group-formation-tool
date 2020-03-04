package com.group3.DAO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.group3.BusinessModels.Course;
import com.group3.Services.IServiceInjector;
import com.group3.Services.IViewCoursesService;
import com.group3.Services.ServiceInjector;

class AddCourseDAOTest {


	private IAddCourseDAO iaddCourseDAO;
    private IDeleteCourseDAO iDeleteCourseDAO;
	private Course course;
	private String CourseName,CourseId;
	private ArrayList<Course> courseList;
	
	@BeforeEach
	void setUp() throws Exception {
		course = new Course();
		 CourseName = "Virtual Reality";
	     CourseId = "CSCI6748";
		course.setCourseId(CourseId);
		course.setCourseName(CourseName);
  	    DAOInjector daoinjector = new DAOInjector();
  	    iaddCourseDAO  = daoinjector.createAddCourseDAO();
  	    
  	    IDAOInjector injector = new DAOInjector();
	   	IViewCoursesDAO iViewCoursesDAO = injector.createViewCourseDAO();
	   
	   	IServiceInjector iServiceInjector = new ServiceInjector();
	   	IViewCoursesService iViewCoursesService = iServiceInjector.createViewCoursesService(iViewCoursesDAO);
	   
	   	 courseList = iViewCoursesService.getAllCourses();   
	   	 iDeleteCourseDAO = daoinjector.createDeleteCourseDAO();
	}

	@Test
	final void testAddCourse() {
		
		
		String outcome  = this.iaddCourseDAO.addCourse(courseList.get(0));
		String expectedOutcome = "Course already exist !";
		assertEquals(outcome,expectedOutcome);
		
		iDeleteCourseDAO.deleteCourse(course);
		expectedOutcome =  CourseName + " with "+CourseId+" created successfully";
		outcome = this.iaddCourseDAO.addCourse(course);
		
		assertEquals(expectedOutcome,outcome);
		
	}

	@Test
	final void testIsCourseExist() {
		
		String expectedOutcome = "Course Name  "+courseList.get(0).getCourseName()+" with "+"Course ID "+courseList.get(0).getCourseId()+" already exists !! ";
	    assertTrue(this.iaddCourseDAO.isCourseExist(courseList.get(0).getCourseId()).equals(expectedOutcome));
	}

}
