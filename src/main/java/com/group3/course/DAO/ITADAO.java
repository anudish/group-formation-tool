package com.group3.course.DAO;

import java.util.ArrayList;

import com.group3.BusinessModels.Course;

public interface ITADAO {
	public ArrayList<Course> getCoursesByTAMailId(String studentMailId);
}
