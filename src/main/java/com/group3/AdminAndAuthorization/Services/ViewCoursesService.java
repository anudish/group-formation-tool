package com.group3.AdminAndAuthorization.Services;

import java.util.ArrayList;

import com.group3.AdminAndAuthorization.Services.IViewCoursesService;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.group3.BusinessModels.Course;
import com.group3.AdminAndAuthorization.DAO.IViewCoursesDAO;

public class ViewCoursesService implements IViewCoursesService {
	private ArrayList<Course> courses;
	private IViewCoursesDAO viewCoursesDAO;
	private static Logger logger = LogManager.getLogger(ViewCoursesService.class);

	public ViewCoursesService(IViewCoursesDAO iViewCoursesDAO) {
		this.viewCoursesDAO = iViewCoursesDAO;
	}

	@Override
	public ArrayList<Course> getAllCourses() {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		try {
		courses = this.viewCoursesDAO.getAllCourses();
		if (courses.isEmpty()) {
			logger.info("No courses to display at all ");
		}
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
		} catch (IndexOutOfBoundsException ind) {
			logger.error(ind.getMessage());
		}
		return courses;
	}
}