package com.group3.DAO;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.group3.BusinessModels.Student;
import com.group3.course.InsertTestDataIntoDB;
import com.group3.course.RemoveTestDataFromDB;

class StudentDAOTest {

	IDAOInjector daoInjector;
	IStudentDAO studentDAO;
	InsertTestDataIntoDB insert;
	RemoveTestDataFromDB remove;
	
	public StudentDAOTest(){
		daoInjector = new DAOInjector();
		studentDAO = daoInjector.createStudentDAO();
		insert = new InsertTestDataIntoDB();
		remove = new RemoveTestDataFromDB();
	}
	
	@Test
	void getAllStudentsTest() {
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList = studentDAO.getAllStudents();
		assertNotNull(studentList);
		assertThat(studentList).isNotEmpty();
		assertTrue(studentList.size()>0);
	}
	
	@Test
	public void getStudentByMailIdTest() throws Exception {
		
		Student student = new Student();
		student.setLastName("Wick");
		student.setFirstName("John");
		student.setEmail("test@dal.ca");
		insert.StudentDAOTest_insertStudent(student);
		
		ArrayList<Student> studentList = studentDAO.getStudentByMailId("test@dal.ca");
		assertNotNull(studentList);
		assertThat(studentList).isNotEmpty();
		assertEquals(studentList.size(),1);
		
		remove.StudentDAOTest_removeStudent(student);
	}
	
	@Test
	public void assignTA() throws Exception{
		
		Student student = new Student();
		student.setLastName("Wick");
		student.setFirstName("John");
		student.setEmail("test2@dal.ca");
		insert.StudentDAOTest_insertStudent(student);
		insert.StudentDAOTest_updateTA(student);
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentDAO.assignTA("test2@dal.ca");
		studentList = studentDAO.getStudentByMailId("test2@dal.ca");
		assertNotNull(studentList);
		assertThat(studentList).isNotEmpty();
		assertEquals(studentList.size(),1);
		System.out.println(student.getEmail()+" "+student.getUserRole());
		assertEquals(studentList.get(0).getUserRole(),"TA");
		
		remove.StudentDAOTest_removeStudent(student);
	}

}
