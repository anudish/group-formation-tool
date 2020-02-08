package com.group3.DAO;

import java.util.ArrayList;

import com.group3.BusinessModels.Course;

public class AddCourseDAOMock implements IAddCourseDAO {
    
	ArrayList<Course> courseList;
	AddCourseDAOMock(){
		//Structure for mocking as DataBase
		courseList = new ArrayList<>();
		Course course = new Course();
		course.setCourseID("CSCI7800");
		course.setCourseName("Advanced Algorithms");
		courseList.add(course);
		course = new Course();
		course.setCourseID("CSCI5308");
		course.setCourseName("Quality Assurance");
		courseList.add(course);
		course = new Course();
		course.setCourseID("CSCI8000");
		course.setCourseName("Pattern Recognition");
		courseList.add(course);
	}
	
	@Override
	public String addCourse(Course course) {
		// TODO Auto-generated method stub
		courseList.add(course);
		String CourseName = course.getCourseName();
		String CourseId = course.getCourseID();
		String feedBackMessage = CourseName + " with "+CourseId+" created successfully";
		return feedBackMessage;
	}

	@Override
	public String isCourseExist(String courseId) {
		// TODO Auto-generated method stub
		
		String feedBackMessage = new String();
		for(Course course : courseList) {
			System.out.println(course.getCourseID());
			if(course.getCourseID().equals(courseId)) {
				
				feedBackMessage = "Course Name  "+course.getCourseName()+" with "+"Course ID "+course.getCourseID()+" already exists !! ";
			    break;
			}
		}
		System.out.println(feedBackMessage);
		return feedBackMessage;
	}

}
