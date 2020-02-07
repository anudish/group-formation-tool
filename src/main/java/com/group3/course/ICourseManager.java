package com.group3.course;

import java.util.ArrayList;

public interface ICourseManager {

	public ArrayList<CourseModel> getCoursesByTAMailId(String studentMailId);
	public ArrayList<CourseModel> getCoursesByInstructorMailId(String instructorMailId);
}
