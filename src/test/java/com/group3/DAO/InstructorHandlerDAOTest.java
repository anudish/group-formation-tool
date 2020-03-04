package com.group3.DAO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InstructorHandlerDAOTest {
    String mailId,courseId;
    IInstructorHandlerDAO iInstructorHandlerDAO;
    ArrayList<String> courseList;
	@BeforeEach
	void setUp() throws Exception {
		iInstructorHandlerDAO = new DAOInjector().createInstructorHandlerDAO();
		courseList = new ArrayList<>();
	}

	@Test
	final void testCreateNewInstructor() {
		mailId ="Caroline@dal.ca";
		courseId = "CSCI67000$%8&kjadjkk";
		assertFalse(this.iInstructorHandlerDAO.createNewInstructor(mailId, courseId).length() > 0);
	    courseId = "CSCI6700";
	    assertTrue(this.iInstructorHandlerDAO.createNewInstructor(mailId, courseId).length() > 0);
	    this.iInstructorHandlerDAO.deleteinstructor(mailId);
	}

	@Test
	final void testIsInstructorExists() {
		mailId = "joe.root@dal.ca";
		assertFalse(this.iInstructorHandlerDAO.isInstructorExists(mailId)==false);
	    assertTrue(this.iInstructorHandlerDAO.isInstructorExists(mailId));
	}

	@Test
	final void testDeleteinstructor() {
		mailId = "binny.rogers@dal.ca";
		assertFalse(this.iInstructorHandlerDAO.deleteinstructor(mailId).length() > 0);
	    this.iInstructorHandlerDAO.createNewInstructor(mailId, "CSCI5408");
		assertTrue(this.iInstructorHandlerDAO.deleteinstructor(mailId).length() > 0);
	}

	@Test
	final void testGetInstructorCourses() {
		
		mailId = "binny.rogers@dal.ca";
		courseId = "CSCI5408";
		courseList = this.iInstructorHandlerDAO.getInstructorCourses(mailId);
		assertFalse(courseList.size() > 0);
		this.iInstructorHandlerDAO.createNewInstructor(mailId, courseId);
		courseList = this.iInstructorHandlerDAO.getInstructorCourses(mailId);
		assertTrue(courseList.size() > 0);
		assertTrue(courseList.get(0).equals(courseId));
		this.iInstructorHandlerDAO.deleteinstructor(mailId);
	}

}
