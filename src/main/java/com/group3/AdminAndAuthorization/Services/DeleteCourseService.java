package com.group3.AdminAndAuthorization.Services;

import com.group3.AdminAndAuthorization.Services.IDeleteCourseService;
import com.group3.BusinessModels.Course;
import com.group3.AdminAndAuthorization.DAO.IDeleteCourseDAO;

public class DeleteCourseService implements IDeleteCourseService {
	IDeleteCourseDAO iDeleteCourseDAO;
	Course course;
	public DeleteCourseService(IDeleteCourseDAO iDeleteCourseDAO, Course course) {
		this.iDeleteCourseDAO = iDeleteCourseDAO;
		this.course = course;
		
	}
	@Override
	public String deleteCourse() {

		String message = iDeleteCourseDAO.deleteCourse(course);
		
		
		return message;
	}

}
