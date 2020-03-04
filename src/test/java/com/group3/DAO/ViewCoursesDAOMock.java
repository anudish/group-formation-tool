package com.group3.DAO;

import java.util.ArrayList;

import com.group3.BusinessModels.Course;

public class ViewCoursesDAOMock implements IViewCoursesDAO {

	ArrayList<Course> courseList;
	public ViewCoursesDAOMock(){
		
		//Initializing mock dataset
		courseList = new ArrayList<>();
		
		
	}
	@Override
	public ArrayList<Course> getAllCourses() {
		// TODO Auto-generated method stub
		setCourses(); //Comment out this method for testing empty condition
		return courseList;
	}
   
	//mehod to enable or disable dataset
	public void setCourses() {
		
		Course course = new Course();
		course.setCourseId("CSCI7800");
		course.setCourseName("Advanced Algorithms");
		courseList.add(course);
		course = new Course();
		course.setCourseId("CSCI5308");
		course.setCourseName("Quality Assurance");
		courseList.add(course);
		course = new Course();
		course.setCourseId("CSCI8000");
		course.setCourseName("Pattern Recognition");
		courseList.add(course);
	}
}
