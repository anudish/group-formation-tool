package com.group3.DAO;

import java.util.ArrayList;
import java.util.List;

import com.group3.BusinessModels.Student;

public interface ICourseDAO {

	public ArrayList<String> getEnrolledStudents(String courseId);
	public void enrollStudentToCourse(Student studentDetaisl, String courseId);
	
}
