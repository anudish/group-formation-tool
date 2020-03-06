package com.group3.AdminAndAuthorization;

import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group3.BusinessModels.Course;
import com.group3.AdminAndAuthorization.DAO.DAOAbstractFactory;
import com.group3.AdminAndAuthorization.DAO.IDAOAbstractFactory;
import com.group3.AdminAndAuthorization.DAO.IViewCoursesDAO;
import com.group3.AdminAndAuthorization.Services.IViewCoursesService;
import com.group3.AdminAndAuthorization.Services.ServiceAbstractFactory;

@Controller
public class ViewCourseController {
	IDAOAbstractFactory daoInjector;
	IViewCoursesDAO viewCoursesDAO;
	IViewCoursesService viewCoursesService;
	private static Logger logger = LogManager.getLogger(ViewCourseController.class);

	@RequestMapping("/ViewCoursesPage")
	public String viewCoursePage(Model model) {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		daoInjector = DAOAbstractFactory.instance();
		ArrayList<Course> courseList;
		    	try {

		viewCoursesDAO = daoInjector.createViewCourseDAO();
		viewCoursesService = ServiceAbstractFactory.instance().createViewCoursesService(viewCoursesDAO);

		courseList = viewCoursesService.getAllCourses();
		model.addAttribute("courseList", courseList);
		return "ViewCoursePage.html";
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
			return "error.html";
		}
    	catch(IndexOutOfBoundsException ind) {
    		logger.error(ind.getMessage());
    		return "error.html";
    	}
    }
}