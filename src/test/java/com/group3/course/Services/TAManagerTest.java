package com.group3.course.Services;

import com.group3.BusinessModels.Student;

import com.group3.course.DAO.DAOMockAbstractFactory;
import com.group3.course.DAO.IDAOAbstractFactory;
import com.group3.course.DAO.IStudentDAO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TAManagerTest {

	IDAOAbstractFactory daoInjector;
	IStudentDAO studentDAO;

	public TAManagerTest() {

		daoInjector = new DAOMockAbstractFactory();
		studentDAO = daoInjector.createStudentDAO();
	}

	@Test
	public void getAllStudentsTest() {

		ArrayList<Student> rows = studentDAO.getAllStudents();
		assertNotNull(rows);
		assertThat(rows).isNotEmpty();
		assertEquals(rows.size(), 2);
	}

	@Test
	public void getStudentByMailIdTest() {

		ArrayList<Student> studentList = studentDAO.getStudentByMailId("krutarth07@dal.ca");
		assertNotNull(studentList);
		assertThat(studentList).isNotEmpty();
		assertEquals(studentList.size(), 1);
	}

}