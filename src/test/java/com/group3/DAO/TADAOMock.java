package com.group3.DAO;

import java.util.ArrayList;
import java.util.HashMap;

import com.group3.BusinessModels.Instructor;
import com.group3.BusinessModels.Student;
import com.group3.course.CourseModel;

public class TADAOMock implements ITADAO{

	ArrayList<Student> list = new ArrayList<Student>();
	ArrayList<CourseModel> courses = new ArrayList<CourseModel>();

	HashMap<String,ArrayList<CourseModel>> courseList = new HashMap<String,ArrayList<CourseModel>>();
	
	public TADAOMock() {
		
		CourseModel course = new CourseModel();
		course.setCourseId("1");
		course.setCourseName("CSCI 1: Learn to build robots");
		courses.add(course);
		
		Student student = new Student();
		student.setFirstName("John");
		student.setLastName("Wick");
		student.setUserRole("Student");
		student.setEmail("jwick@dal.ca");
		student.setEncryptedPassword("Ilovedogs@1234");
		list.add(student);
		courseList.put("jwick@dal.ca",courses);
		
		student = new Student();
		student.setFirstName("Tony");
		student.setLastName("Stark");
		student.setUserRole("TA");
		student.setEmail("tstark@dal.ca");
		student.setEncryptedPassword("Jarvis@1234");
		list.add(student);
		courseList.put("tstark@dal.ca", courses);
		
		Instructor instructor= new Instructor();
		instructor.setFirstName("Steve");
		instructor.setLastName("Rogers");
		instructor.setUserRole("Instructor");
		instructor.setEmail("srogers@dal.ca");
		instructor.setEncryptedPassword("Iamyoung@1234");
		list.add(student);
		courseList.put("srogers@dal.ca", courses);
	}
	
	@Override
	public ArrayList<CourseModel> getCoursesByTAMailId(String studentMailId) {
		ArrayList<CourseModel> courseTaken = new ArrayList<CourseModel>();
		courseTaken = courseList.get(studentMailId);
		return courseTaken;
	}

}
