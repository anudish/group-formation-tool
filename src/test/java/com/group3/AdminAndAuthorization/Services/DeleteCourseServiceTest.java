package com.group3.AdminAndAuthorization.Services;

import static org.junit.jupiter.api.Assertions.*;

import com.group3.AdminAndAuthorization.Services.IDeleteCourseService;
import com.group3.Services.ServiceInjector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group3.BusinessModels.Course;

import com.group3.AdminAndAuthorization.DAO.DAOMockInjector;
import com.group3.AdminAndAuthorization.DAO.IDAOInjector;
import com.group3.AdminAndAuthorization.DAO.IDeleteCourseDAO;

class DeleteCourseServiceTest {
    private Course course;
    private IDeleteCourseService iDeleteCourseService;
    private IDeleteCourseDAO iDeleteCourseDAO;
	@BeforeEach
	void setUp() throws Exception {
		iDeleteCourseDAO = new DAOMockInjector().createDeleteCourseDAO();
		
	}

	
	@Test
	final void testDeleteCourse() {
		//fail("Not yet implemented"); // TODO
		course = new Course();
		//Failing test ()
		course.setCourseId("CSCI7000");
		course.setCourseName("Software Architecture");
		iDeleteCourseService = new ServiceInjector().createDeleteCourseService(iDeleteCourseDAO, course);
	    String feedBackString = iDeleteCourseService.deleteCourse();
	    String expectedResponse = "Error occured while deleting the course";
	    assertTrue(feedBackString.equals(expectedResponse)==true);
	    
	    
	    //Passing Test 
	    course.setCourseId("CSCI7800");   //Course exist
		course.setCourseName("Advanced Algorithms"); 
		iDeleteCourseService = new ServiceInjector().createDeleteCourseService(iDeleteCourseDAO, course);
		feedBackString = iDeleteCourseService.deleteCourse();
	    expectedResponse = course.getCourseName()+" ("+course.getCourseId()+") "+" is deleted sucessfully ";
	    assertTrue(expectedResponse.equals(feedBackString)==true);
	}

}
