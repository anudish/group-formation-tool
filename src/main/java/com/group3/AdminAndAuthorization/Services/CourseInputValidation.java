package com.group3.AdminAndAuthorization.Services;

import java.util.ArrayList;
import java.util.regex.Pattern;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.group3.BusinessModels.Course;

public class CourseInputValidation implements ICourseInputValidation {
	ArrayList<String> ErrorarrayList = null;
	String courseIdPattern;
	String courseNamePattern;
	String courseId;
	String message;
	String courseName;
	private static Logger logger = LogManager.getLogger(AdminPageServices.class);

	@Override
	public ArrayList<String> validateInputCourse(Course course) {
			PropertyConfigurator.configure("src/main/resources/log4j.properties");
		ErrorarrayList = new ArrayList<>();
		courseIdPattern = "[A-za-z]{4}[0-9]{4}";
		courseNamePattern = "[A-Za-z{\\s}*]+[0-9]*";
		courseId = course.getCourseId();
		try {
		if (Pattern.matches(courseIdPattern, courseId) == false) {
			message = "Invalid Course Id (It Should Like : csci5308)";

			if (ErrorarrayList == null) {
				ErrorarrayList = new ArrayList<>();
			}

			ErrorarrayList.add(message);
		}

		courseName = course.getCourseName();
		if (Pattern.matches(courseNamePattern, courseName) == false) {
			message = "Invalid Course Name (It Should start with String only)";

			if (ErrorarrayList == null) {
				ErrorarrayList = new ArrayList<>();
			}

			ErrorarrayList.add(message);
		}
		} catch (NullPointerException np) {
			logger.error(np.getMessage());
		} catch (IndexOutOfBoundsException e) {
			logger.error(e.getMessage());
		}
		return ErrorarrayList;
	}
}