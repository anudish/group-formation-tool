package com.group3.DAO;

import java.util.ArrayList;
import java.util.List;

import com.group3.BusinessModels.Student;
import com.group3.course.CourseModel;

public interface ICourseDAO {

	public ArrayList<String> getEnrolledStudentsByCourseId(String courseId);
	public void enrollStudentToCourse(Student studentDetails, String courseId);
//	public ArrayList<CourseModel> getCoursesByTAMailId(String studentMailId);
//	public ArrayList<CourseModel> getCoursesByInstructorMailId(String instructorMailId);
}
