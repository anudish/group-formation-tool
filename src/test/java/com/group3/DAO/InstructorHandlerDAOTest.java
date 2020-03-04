package com.group3.DAO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group3.course.DAO.StudentDAO;

class InstructorHandlerDAOTest {
    String mailId,courseId;
    IInstructorHandlerDAO iInstructorHandlerDAO;
    ArrayList<String> courseList;
    private static Logger logger = LogManager.getLogger(InstructorHandlerDAO.class);
	
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
		logger.error(courseList.size());
		this.iInstructorHandlerDAO.createNewInstructor(mailId, courseId);
		courseList = this.iInstructorHandlerDAO.getInstructorCourses(mailId);
		this.iInstructorHandlerDAO.deleteinstructor(mailId);
	}

}
