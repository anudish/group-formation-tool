package com.group3.course.DAO;

import java.util.ArrayList;
import java.util.List;

import com.group3.BusinessModels.Student;

public interface IStudentDAO {
	public ArrayList<Student> getAllStudents();

	public ArrayList<Student> getStudentByMailId(String studentMailId);

	public void assignTA(String studentMailId);
}
