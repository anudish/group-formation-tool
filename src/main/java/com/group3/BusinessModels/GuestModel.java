package com.group3.BusinessModels;

import java.util.ArrayList;

import com.group3.course.DAO.IDAOAbstractFactory;
import com.group3.course.Services.ICourseManager;
import com.group3.course.Services.ServiceAbstractFactory;

public class GuestModel extends Person {
	public GuestModel(String lastName, String firstName, String email, String role, String psw) {
		super(lastName, firstName, email, role, psw);
	}

	public GuestModel() {
		super();
	}

	public ArrayList<Course> getCourses(IDAOAbstractFactory daoInjector) {
		ArrayList<Course> courses = new ArrayList<Course>();
		ICourseManager courseManager = ServiceAbstractFactory.instance().createCourseManager(daoInjector);
		courses = courseManager.getCoursesForGuest();
		return courses;
	}
}