package com.group3.AdminAndAuthorization.Services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import com.group3.AdminAndAuthorization.Services.IViewCoursesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group3.AdminAndAuthorization.DAO.DAOMockInjector;
import com.group3.AdminAndAuthorization.DAO.IDAOInjector;
import com.group3.AdminAndAuthorization.DAO.IViewCoursesDAO;
import com.group3.BusinessModels.Course;;
class ViewCoursesServiceTest {
	IDAOInjector injector;
	IViewCoursesDAO iViewCoursesDAO;
	IViewCoursesService iViewCoursesService;
	ArrayList<Course> courseList;

	public ViewCoursesServiceTest() {
		injector = DAOMockInjector.instance();
		 iViewCoursesDAO = injector.createViewCourseDAO();
	}

	

	@Test
	final void testGetAllCourses() {

		iViewCoursesService = new ServiceInjector().createViewCoursesService(iViewCoursesDAO);
		courseList = iViewCoursesService.getAllCourses();
		assertFalse(courseList.isEmpty());
		
		//Enabling dataset
		assertTrue(courseList.size()==3);
		
		
		
		
	}

}
