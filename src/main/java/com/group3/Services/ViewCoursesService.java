package com.group3.Services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.group3.BusinessModels.Course;

import com.group3.DAO.IViewCoursesDAO;
@Service("ViewCoursesService")
public class ViewCoursesService implements IViewCoursesService {
    
	private ArrayList<Course> courses;
	private IViewCoursesDAO iViewCoursesDAO;
	public ViewCoursesService(IViewCoursesDAO iViewCoursesDAO) {
		this.iViewCoursesDAO = iViewCoursesDAO;
		
	}
	@Override
	public ArrayList<Course> getAllCourses() {
		// TODO Auto-generated method stub
		courses = this.iViewCoursesDAO.getAllCourses();
		
		if(courses.isEmpty()) {
			
			System.out.println("No courses to display at all ");
		}//
		
		return courses;
	}

}
