package com.group3.AdminAndAuthorization.Services;

import java.util.ArrayList;

import com.group3.AdminAndAuthorization.Services.IAddCourseService;
import com.group3.AdminAndAuthorization.Services.ICourseInputValidation;
import org.springframework.stereotype.Service;

import com.group3.BusinessModels.Course;
import com.group3.AdminAndAuthorization.DAO.IAddCourseDAO;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class AddCourseService implements IAddCourseService {
	private IAddCourseDAO addCourseDAO;
	public AddCourseService addCourseService;
	private ArrayList<String> errorList, successMessage;
	private Logger logger = LogManager.getLogger(AddCourseService.class);

	public AddCourseService(IAddCourseDAO addCourseDAO) {
		this.addCourseDAO = addCourseDAO;
		errorList = new ArrayList<>();
		successMessage = new ArrayList<>();
	}

	public ArrayList<String> insertCourseDetails(Course course, ICourseInputValidation icourseInputValidation) {
		String feedBackMessage;
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		try {

		errorList = icourseInputValidation.validateInputCourse(course);
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
		}
		if (errorList.size() > 0) {
			return errorList;
		} else {
			try {
			feedBackMessage = addCourseDAO.isCourseExist(course.getCourseId());

			if (feedBackMessage.isEmpty()) {
				feedBackMessage = addCourseDAO.addCourse(course);
			}

			successMessage.add(feedBackMessage);
			} catch (StringIndexOutOfBoundsException e) {
				logger.error(e.getMessage());
			} catch (NullPointerException np) {
				logger.error(np.getMessage());
			}
			return successMessage;
		}
	}
}