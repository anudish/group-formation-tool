package com.group3.course.Services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.group3.BusinessModels.Student;
import com.group3.course.DAO.DAOMockAbstractFactory;

import com.group3.course.DAO.*;

class StudentManagerTest {

	IDAOAbstractFactory daoInjector;
	ICourseDAO courseDAO;
	ArrayList<String> current_students;

	public StudentManagerTest() {
		
		daoInjector = new DAOMockAbstractFactory();
		courseDAO = daoInjector.createCourseDAO();
	}

	@Test
	void addStudentsToCourseTest() {

		Student studentDetails = new Student();
		studentDetails.setEmail("jwick@dal.ca");
		courseDAO.enrollStudentToCourse(studentDetails, "2");
		current_students = courseDAO.getEnrolledStudentsByCourseId("1");
		assertNotNull(current_students);
		assertThat(current_students).isNotEmpty();
		assertEquals(current_students.size(), 1);
	}
}