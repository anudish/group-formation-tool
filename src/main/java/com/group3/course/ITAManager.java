package com.group3.course;

import java.util.ArrayList;
import java.util.List;

import com.group3.BusinessModels.Student;

public interface ITAManager {

	public ArrayList<Student> getAllStudents();
	public ArrayList<Student> getStudentByMailId(String studentMailId);
	public void addTA(String studentMailId);
}
