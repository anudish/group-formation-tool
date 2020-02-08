package com.group3.DAO;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.group3.BusinessModels.Student;
import com.group3.course.CourseModel;
import com.group3.course.InsertTestDataIntoDB;
import com.group3.course.RemoveTestDataFromDB;

class TADAOTest {

	IDAOInjector daoInjector;
	ITADAO taDAO;
	
	InsertTestDataIntoDB insert;
	RemoveTestDataFromDB remove;
	
	public TADAOTest(){
		daoInjector = new DAOInjector();
		taDAO = daoInjector.createTADAO();
		insert = new InsertTestDataIntoDB();
		remove = new RemoveTestDataFromDB();
	}
	
	@Test
	public void getCoursesByTAMailId() throws Exception{
		
		Student student = new Student();
		student.setBannerId("B009876");
		student.setEmail("test1234@dal.ca");
		
		insert.TADAOTest_insertEnrollment(student, "CSCI04");
		
		ArrayList<CourseModel> courses = new ArrayList<CourseModel>();
		courses = taDAO.getCoursesByTAMailId("test1234@dal.ca");
		assertNotNull(courses);
		assertThat(courses).isNotEmpty();
		assertEquals(courses.get(0).getCourseId(),"CSCI04");
		assertEquals(courses.get(0).getCourseName(),"TEST");
		assertEquals(courses.size(),1);
		
		remove.TADAOTest_removeEnrollment(student, "CSCI04");
	}
	

}
