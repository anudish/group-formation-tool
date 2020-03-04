package com.group3.DAO;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group3.BusinessModels.Course;

class ViewCoursesDAOTest {
   ArrayList<Course> courseList;
   IViewCoursesDAO iViewCoursesDAO;
   IDeleteCourseDAO iDeleteCoursesDAO;
   IAddCourseDAO iAddCourseDAO;
   Course testCourse;
	@BeforeEach
	void setUp() throws Exception {
		courseList = new ArrayList<>();
		DAOInjector dAOInjector = new DAOInjector();
		iAddCourseDAO = dAOInjector.createAddCourseDAO();
		iDeleteCoursesDAO = dAOInjector.createDeleteCourseDAO();
		iViewCoursesDAO = dAOInjector.createViewCourseDAO();
		testCourse = new Course();
		testCourse.setCourseId("CSCI7777");
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
