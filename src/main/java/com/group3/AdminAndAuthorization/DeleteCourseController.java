package com.group3.AdminAndAuthorization;

import java.sql.SQLException;
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
import com.group3.AdminAndAuthorization.DAO.IDeleteCourseDAO;
import com.group3.AdminAndAuthorization.DAO.IViewCoursesDAO;
import com.group3.AdminAndAuthorization.Services.IDeleteCourseService;
import com.group3.AdminAndAuthorization.Services.IViewCoursesService;
import com.group3.AdminAndAuthorization.Services.ServiceAbstractFactory;

@Controller
public class DeleteCourseController {
private static Logger logger = LogManager.getLogger(DeleteCourseController.class);
	IDAOAbstractFactory daoInjector;
	IViewCoursesDAO viewCoursesDAO;
	IViewCoursesService viewCoursesService;
	ArrayList<Course> courseList;

	@RequestMapping("/DeleteCoursePage")
	public String deleteCoursePage(Model model) {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		daoInjector = DAOAbstractFactory.instance();
		try {
		viewCoursesDAO = daoInjector.createViewCourseDAO();
		viewCoursesService = ServiceAbstractFactory.instance().createViewCoursesService(viewCoursesDAO);
		courseList = viewCoursesService.getAllCourses();

		model.addAttribute("courseList", courseList);
		return "DeleteCoursePage.html";
		} catch (NullPointerException nl) {
			logger.log(Level.ERROR, nl.getMessage());
			return "error.html";
		} catch (IndexOutOfBoundsException ind) {
			logger.log(Level.ERROR, ind.getMessage());
			return "error.html";
		}
	}

	@RequestMapping("/deleteCourse")
	public String deleteCourseRequest(Course course, Model model) {
			PropertyConfigurator.configure("src/main/resources/log4j.properties");

		IDeleteCourseDAO deleteCourseDAO = daoInjector.createDeleteCourseDAO();
		IDeleteCourseService deleteCourseService = ServiceAbstractFactory.instance().createDeleteCourseService(deleteCourseDAO,
				course);
		ArrayList<Course> courseList;
		String feedBackMessage;
		try {
		viewCoursesDAO = daoInjector.createViewCourseDAO();
		feedBackMessage = deleteCourseService.deleteCourse();
		viewCoursesService = ServiceAbstractFactory.instance().createViewCoursesService(viewCoursesDAO);
		courseList = viewCoursesService.getAllCourses();

		model.addAttribute("feedBackMessage", feedBackMessage);
			if (feedBackMessage.contains("Server not responding")) {
				throw new SQLException();
			}
		model.addAttribute("courseList", courseList);
		return "DeleteCoursePage.html";
		} catch (NullPointerException nlp) {
			logger.log(Level.ERROR, nlp.getMessage());
			return "error.html";
		} catch (IndexOutOfBoundsException ind) {
			logger.log(Level.ERROR, ind.getMessage());
			return "error.html";
		} catch (SQLException sql) {
			logger.error("Server not responding. The SQL State is :" + sql.getSQLState() + ". Error Code : " + sql.getErrorCode());
			return "error.html";
		}
	}
}