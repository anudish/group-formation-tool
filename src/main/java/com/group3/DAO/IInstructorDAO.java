package com.group3.DAO;

import java.util.ArrayList;

import com.group3.course.CourseModel;

public interface IInstructorDAO {
	public ArrayList<CourseModel> getCoursesByInstructorMailId(String instructorMailId);
}
