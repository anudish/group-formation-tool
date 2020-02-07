package com.group3.DAO;

import java.util.ArrayList;

import com.group3.course.CourseModel;

public interface ITADAO {

	public ArrayList<CourseModel> getCoursesByTAMailId(String studentMailId);

}
