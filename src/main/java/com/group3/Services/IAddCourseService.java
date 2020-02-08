package com.group3.Services;

import java.util.ArrayList;

import com.group3.BusinessModels.Course;

public interface IAddCourseService {
	public ArrayList<String> insertCourseDetails(Course course, ICourseInputValidation iCourseInputValidation);
}
