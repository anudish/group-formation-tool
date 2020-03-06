package com.group3.AdminAndAuthorization;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group3.BusinessModels.Course;
import com.group3.AdminAndAuthorization.DAO.DAOInjector;
import com.group3.AdminAndAuthorization.DAO.IDAOInjector;
import com.group3.AdminAndAuthorization.DAO.IViewCoursesDAO;
import com.group3.AdminAndAuthorization.Services.IViewCoursesService;
import com.group3.AdminAndAuthorization.Services.ServiceInjector;

@Controller
public class ViewCourseController {
	IDAOInjector daoInjector;
	IViewCoursesDAO viewCoursesDAO;
	IViewCoursesService viewCoursesService;

	@RequestMapping("/ViewCoursesPage")
	public String viewCoursePage(Model model) {
		daoInjector = DAOInjector.instance();
		ArrayList<Course> courseList;
		viewCoursesDAO = daoInjector.createViewCourseDAO();
		viewCoursesService = ServiceInjector.instance().createViewCoursesService(viewCoursesDAO);

		courseList = viewCoursesService.getAllCourses();
		model.addAttribute("courseList", courseList);
		return "ViewCoursePage.html";
	}
}