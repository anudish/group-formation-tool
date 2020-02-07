package com.group3.Services;

import com.group3.BusinessModels.Course;
import com.group3.DAO.IDeleteCourseDAO;

public class DeleteCourseService implements IDeleteCourseService {
	IDeleteCourseDAO iDeleteCourseDAO;
	Course course;
	public DeleteCourseService(IDeleteCourseDAO iDeleteCourseDAO, Course course) {
		this.iDeleteCourseDAO = iDeleteCourseDAO;
		this.course = course;
		
	}
	@Override
	public String deleteCourse() {
		// TODO Auto-generated method stub
		String message = iDeleteCourseDAO.deleteCourse(course);
		
		
		return message;
	}

}
