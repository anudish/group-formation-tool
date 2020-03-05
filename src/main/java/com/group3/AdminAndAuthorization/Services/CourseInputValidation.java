package com.group3.AdminAndAuthorization.Services;

import java.util.ArrayList;
import java.util.regex.Pattern;

import com.group3.AdminAndAuthorization.Services.ICourseInputValidation;
import com.group3.BusinessModels.Course;



public class CourseInputValidation implements ICourseInputValidation {
	ArrayList<String> ErrorarrayList = null;
	public CourseInputValidation() {
    }
	@Override
	public ArrayList<String> validateInputCourse(Course course) {
		
		 String courseIdPattern =  "[A-za-z]{4}[0-9]{4}";
		 String courseNamePattern = "[A-Za-z{\\s}*]+[0-9]*";
		 ErrorarrayList = new ArrayList<>();
		String CourseId = course.getCourseId();
		
		if(!Pattern.matches(courseIdPattern,CourseId)) {
		
			System.out.println("Invalid Course Id (It Should Like : csci5308)");
			String Message = "Invalid Course Id (It Should Like : csci5308)";
			if(ErrorarrayList==null) {
				
				ErrorarrayList = new ArrayList<>();
			}
			ErrorarrayList.add(Message);
		}
		String CourseName = course.getCourseName();
		if(!Pattern.matches(courseNamePattern,CourseName)) {
			System.out.println("Invalid Course Name (It Should start with String only)");
			String Message = "Invalid Course Name (It Should start with String only)";
			if(ErrorarrayList==null) {
				
				ErrorarrayList = new ArrayList<>();
			}
			ErrorarrayList.add(Message);
			
		}
		 return ErrorarrayList;
		
	}

}
