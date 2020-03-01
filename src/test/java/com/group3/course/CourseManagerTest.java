package com.group3.course;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group3.BusinessModels.Student;
import com.group3.DAO.DAOMockInjector;
import com.group3.DAO.ICourseDAO;
import com.group3.DAO.IDAOInjector;
import com.group3.DAO.IInstructorDAO;
import com.group3.DAO.ITADAO;

class CourseManagerTest {

	IDAOInjector daoInjector;
	ITADAO taDAO;
	IInstructorDAO instructorDAO;
	ICourseDAO courseDAO;
	ArrayList<CourseModel> courseInfo;
	
	public CourseManagerTest(){
		daoInjector = new DAOMockInjector();
		taDAO = daoInjector.createTADAO();
		instructorDAO = daoInjector.createInstructorDAO();
		courseDAO = daoInjector.createCourseDAO();
	}
	
	@BeforeEach
	public void init() {
		courseInfo = new ArrayList<CourseModel>();
	}
	
	@Test
	public void getCoursesByTAMailIdTest() {
		courseInfo = taDAO.getCoursesByTAMailId("tstark@dal.ca");
		assertNotNull(courseInfo);
		assertThat(courseInfo).isNotEmpty();
		assertEquals(courseInfo.size(),1);
	}
	
	@Test
	public void getCoursesByInstructorMailIdTest() {	
		courseInfo = instructorDAO.getCoursesByInstructorMailId("srogers@dal.ca");
		assertNotNull(courseInfo);
		assertThat(courseInfo).isNotEmpty();
		assertEquals(courseInfo.size(),1);
	}
	
	@Test
	public void getCoursesForGuestTest() {	
		courseInfo = courseDAO.getCoursesForGuest();
		assertNotNull(courseInfo);
		assertThat(courseInfo).isNotEmpty();
		assertEquals(courseInfo.size(),1);
	}

}
