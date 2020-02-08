package com.group3.course;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.group3.BusinessModels.Student;
import com.group3.DAO.DAOMockInjector;
import com.group3.DAO.ICourseDAO;
import com.group3.DAO.IDAOInjector;
import com.group3.DAO.IStudentDAO;
import com.group3.DAO.StudentDAO;

class TAManagerTest {

	IDAOInjector daoInjector;
	IStudentDAO studentDAO;
	
	public TAManagerTest(){
		daoInjector = new DAOMockInjector();
		studentDAO = daoInjector.createStudentDAO();
	}
	
	@Test
	public void getAllStudentsTest() {	
		ArrayList<Student> rows = studentDAO.getAllStudents();
		assertNotNull(rows);
		assertThat(rows).isNotEmpty();
		assertEquals(rows.size(),2);
	}
	
	@Test
	public void getStudentByMailIdTest() {
		ArrayList<Student> studentList = studentDAO.getStudentByMailId("krutarth07@dal.ca");
		assertNotNull(studentList);
		assertThat(studentList).isNotEmpty();
		assertEquals(studentList.size(),1);
	}

}
