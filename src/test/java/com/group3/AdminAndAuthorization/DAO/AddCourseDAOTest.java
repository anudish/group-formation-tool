package com.group3.AdminAndAuthorization.DAO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.group3.BusinessModels.Course;
import com.group3.AdminAndAuthorization.Services.IServiceInjector;
import com.group3.AdminAndAuthorization.Services.IViewCoursesService;
import com.group3.AdminAndAuthorization.Services.ServiceInjector;

class AddCourseDAOTest {


	private IAddCourseDAO iaddCourseDAO;
    private IDeleteCourseDAO iDeleteCourseDAO;
	private Course course;
	private String CourseName,CourseId;
	private ArrayList<Course> courseList;
	

	public AddCourseDAOTest() {
		course = new Course();
		 CourseName = "Computational Biology";
	     CourseId = "CSCT6748";
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
	final void testAddCourseCreatedSuccessCase(){
		String expectedOutcome =  CourseName + " with "+CourseId+" created successfully";
		String outcome = this.iaddCourseDAO.addCourse(course);

		assertEquals(expectedOutcome,outcome);
		iDeleteCourseDAO.deleteCourse(course);
	}


	@Test
	final void testIsCourseExist() {
		if (courseList.size() > 0){
			String expectedOutcome = "Course Name  "+courseList.get(0).getCourseName()+" with "+"Course ID "+courseList.get(0).getCourseId()+" already exists !! ";
			assertTrue(this.iaddCourseDAO.isCourseExist(courseList.get(0).getCourseId()).equals(expectedOutcome));
		}

	}

}
