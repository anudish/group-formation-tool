package com.group3.DAO;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.group3.BusinessModels.Student;
import com.group3.DBConnectivity.ObtainDataBaseConnection;
import com.group3.course.CourseModel;
import com.group3.course.InsertTestDataIntoDB;
import com.group3.course.RemoveTestDataFromDB;

class CourseDAOTest {

	IDAOInjector daoInjector;
	ICourseDAO courseDAO;
	
	RemoveTestDataFromDB remove;
	
	public CourseDAOTest(){
		daoInjector = new DAOInjector();
		courseDAO = daoInjector.createCourseDAO();
		remove = new RemoveTestDataFromDB();
	}
	
	@Test
	public void getEnrolledStudentsByCourseId() throws Exception{
		
		Student student = new Student();
		student.setBannerId("B001234");
		student.setEmail("test@dal.ca");
		
		courseDAO.enrollStudentToCourse(student, "CSCI00");
		
		ArrayList<String> enrolledStudentMailIds = courseDAO.getEnrolledStudentsByCourseId("CSCI00");
		assertNotNull(enrolledStudentMailIds);
		assertThat(enrolledStudentMailIds).isNotEmpty();
		assertEquals(enrolledStudentMailIds.size(),1);

		remove.CourseEnrollmentsDAOTest_removeEnrollment(student, "CSCI00");

}
	
	@Test
	public void enrollStudentToCourse() throws Exception {
		
		Student student = new Student();
		student.setBannerId("B0012345");
		student.setFirstName("Test");
		student.setLastName("Test");
		student.setEncryptedPassword("Test");
		student.setUserRole("Student");
		student.setEmail("test2@dal.ca");
		
		courseDAO.enrollStudentToCourse(student, "CSCI01");
		ArrayList<String> enrolledStudentMailIds = courseDAO.getEnrolledStudentsByCourseId("CSCI01");
		assertNotNull(enrolledStudentMailIds);
		assertThat(enrolledStudentMailIds).isNotEmpty();
		assertEquals(enrolledStudentMailIds.size(),1);

		remove.CourseEnrollmentsDAOTest_removeEnrollment(student, "CSCI01");
		
	}
	
	@Test
	public void getCoursesForGuest() throws Exception {
		
		ArrayList<CourseModel> enrolledStudentMailIds = courseDAO.getCoursesForGuest();
		assertNotNull(enrolledStudentMailIds);
		assertThat(enrolledStudentMailIds).isNotEmpty();
		assertTrue(enrolledStudentMailIds.size()>0);
		
	}
	
}
