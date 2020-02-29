package com.group3.DAO;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.group3.course.CourseModel;
import com.group3.course.InsertTestDataIntoDB;
import com.group3.course.RemoveTestDataFromDB;

class InstructorDAOTest {

	IDAOInjector daoInjector;
	IInstructorDAO instructorDAO;
	
	InsertTestDataIntoDB insert;
	RemoveTestDataFromDB remove;
	
	public InstructorDAOTest() {
		daoInjector = new DAOInjector();
		instructorDAO = daoInjector.createInstructorDAO();
		insert = new InsertTestDataIntoDB();
		remove = new RemoveTestDataFromDB();
	}
	
	@Test
	public void getCoursesByInstructorMailId() throws Exception{

		insert.InstructorDAOTest_insertEnrollment("testinstructor@dal.ca", "TestCSCI03");
		
		ArrayList<CourseModel> courses = new ArrayList<CourseModel>();
		courses = instructorDAO.getCoursesByInstructorMailId("testinstructor@dal.ca");
		assertNotNull(courses);
		assertThat(courses).isNotEmpty();
		assertEquals(courses.get(0).getCourseId(),"TestCSCI03");
		assertEquals(courses.get(0).getCourseName(),"TEST");
		assertEquals(courses.size(),1);
		
		remove.InstructorDAOTest_removeEnrollment("testinstructor@dal.ca", "TestCSCI03");
	}

}
