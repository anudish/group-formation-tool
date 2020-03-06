package com.group3.AdminAndAuthorization.DAO;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import com.group3.AdminAndAuthorization.DAO.IAddCourseDAO;
import com.group3.AdminAndAuthorization.DAO.IDeleteCourseDAO;
import com.group3.AdminAndAuthorization.DAO.IViewCoursesDAO;
import com.group3.AdminAndAuthorization.DAO.DAOInjector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group3.BusinessModels.Course;

class ViewCoursesDAOTest {
   ArrayList<Course> courseList;
   IViewCoursesDAO iViewCoursesDAO;
   IDeleteCourseDAO iDeleteCoursesDAO;
   IAddCourseDAO iAddCourseDAO;
   Course testCourse;

	public ViewCoursesDAOTest() {
		courseList = new ArrayList<>();
		IDAOInjector dAOInjector = DAOInjector.instance();
		iAddCourseDAO = dAOInjector.createAddCourseDAO();
		iDeleteCoursesDAO = dAOInjector.createDeleteCourseDAO();
		iViewCoursesDAO = dAOInjector.createViewCourseDAO();
		testCourse = new Course();
		testCourse.setCourseId("CSCT7777");
		testCourse.setCourseName("Computational Biotechnology II");
	}

	@Test
	final void testGetAllCourses() {
		courseList = this.iViewCoursesDAO.getAllCourses();
		for(Course course:courseList) {
			assertNotEquals(course.getCourseId(),testCourse.getCourseId());
		}
		this.iAddCourseDAO.addCourse(testCourse);
		courseList = this.iViewCoursesDAO.getAllCourses();
		for(Course course:courseList) {
			if(course.getCourseName().equals(testCourse.getCourseName())) {
				assertEquals(testCourse.getCourseId(), course.getCourseId());
			}
			
		}
		this.iDeleteCoursesDAO.deleteCourse(testCourse);
	}

}
