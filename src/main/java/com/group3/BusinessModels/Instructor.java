package com.group3.BusinessModels;

import java.util.ArrayList;

import com.group3.course.DAO.IDAOAbstractFactory;
import com.group3.course.Services.ICourseManager;
import com.group3.course.Services.ServiceAbstractFactory;

public class Instructor extends Person {
	String instructorId;

	public String getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}

	public ArrayList<Course> getTACourse(IDAOAbstractFactory daoInjector, String studentId) {
		ArrayList<Course> courses = new ArrayList<Course>();
		ICourseManager courseManager = ServiceAbstractFactory.instance().createCourseManager(daoInjector);
		courses = courseManager.getCoursesByTAMailId(studentId);
		return courses;
	}
}