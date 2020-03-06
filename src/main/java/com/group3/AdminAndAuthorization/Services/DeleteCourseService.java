package com.group3.AdminAndAuthorization.Services;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.group3.AdminAndAuthorization.Services.IDeleteCourseService;
import com.group3.BusinessModels.Course;
import com.group3.AdminAndAuthorization.DAO.IDeleteCourseDAO;

public class DeleteCourseService implements IDeleteCourseService {
	IDeleteCourseDAO deleteCourseDAO;
	Course course;
	private static Logger logger = LogManager.getLogger(DeleteCourseService.class);

	public DeleteCourseService(IDeleteCourseDAO deleteCourseDAO, Course course) {
		this.deleteCourseDAO = deleteCourseDAO;
		this.course = course;
	}

	@Override
	public String deleteCourse() {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		String message = null;
		try {
		message = deleteCourseDAO.deleteCourse(course);
		} catch (NullPointerException np) {
			logger.info(np.getMessage());
		} catch (StringIndexOutOfBoundsException str) {
			logger.info(str.getMessage());
		}
		return message;
	}
}