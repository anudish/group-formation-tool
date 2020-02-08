package com.group3.Services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group3.DAO.DAOMockInjector;
import com.group3.DAO.IDAOInjector;
import com.group3.DAO.IViewCoursesDAO;
import com.group3.BusinessModels.Course;;
class ViewCoursesServiceTest {
	IDAOInjector injector;
	IViewCoursesDAO iViewCoursesDAO;
	IViewCoursesService iViewCoursesService;
	ArrayList<Course> courseList;
	@BeforeEach
	void setUp() throws Exception {
		injector = new DAOMockInjector();
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
