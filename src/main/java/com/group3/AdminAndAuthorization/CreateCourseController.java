package com.group3.AdminAndAuthorization;

import java.util.ArrayList;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group3.BusinessModels.Course;
import com.group3.AdminAndAuthorization.DAO.DAOAbstractFactory;
import com.group3.AdminAndAuthorization.DAO.IDAOAbstractFactory;
import com.group3.AdminAndAuthorization.Services.*;
@Controller
public class CreateCourseController {
	private static Logger logger = LogManager.getLogger(CreateCourseController.class);

	IServiceAbstractFactory serviceinjector;
	IDAOAbstractFactory daoInjector;

	@RequestMapping("/addCoursePageRequest")
	public String renderCoursePage() {
		return "AddCourse.html";
	}

	@RequestMapping("/addCourse")
	public String addCourse(Course course, Model model) {
		IAddCourseService addCourseService;
		ICourseInputValidation courseInputValidation;
		ArrayList<String> operationFeedback;

		serviceinjector = ServiceAbstractFactory.instance();
		daoInjector = DAOAbstractFactory.instance();
		try {
    	 addCourseService = serviceinjector.createaddCourseService(daoInjector.createAddCourseDAO());
		courseInputValidation = serviceinjector.createCourseInputValidation();
		operationFeedback = addCourseService.insertCourseDetails(course, courseInputValidation);

		model.addAttribute("operationFeedback", operationFeedback);
    	  logger.info("The Course : " + operationFeedback + " is added successfully.");
		return "AddCourse.html";
		} catch (NullPointerException np) {
			logger.log(Level.ERROR, np.getMessage());
			return "error.html";
      }
		catch(StringIndexOutOfBoundsException str) {
			logger.log(Level.ERROR, str.getMessage());
			return "error.html";
		}
	}
}