package com.group3.AdminAndAuthorization.Services;

import static org.junit.jupiter.api.Assertions.*;

import com.group3.AdminAndAuthorization.Services.IDeleteCourseService;
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

	public DeleteCourseServiceTest() {
		iDeleteCourseDAO = DAOMockInjector.instance().createDeleteCourseDAO();
		
	}

	
	@Test
	final void testDeleteCourse() {

		course = new Course();
		course.setCourseId("CSCI7000");
		course.setCourseName("Software Architecture");
		iDeleteCourseService = new ServiceInjector().createDeleteCourseService(iDeleteCourseDAO, course);
	    String feedBackString = iDeleteCourseService.deleteCourse();
	    String expectedResponse = "Error occured while deleting the course";
	    assertTrue(feedBackString.equals(expectedResponse)==true);
	    
	    

	    course.setCourseId("CSCI7800");
		course.setCourseName("Advanced Algorithms"); 
		iDeleteCourseService = new ServiceInjector().createDeleteCourseService(iDeleteCourseDAO, course);
		feedBackString = iDeleteCourseService.deleteCourse();
	    expectedResponse = course.getCourseName()+" ("+course.getCourseId()+") "+" is deleted sucessfully ";
	    assertTrue(expectedResponse.equals(feedBackString)==true);
	}

}
