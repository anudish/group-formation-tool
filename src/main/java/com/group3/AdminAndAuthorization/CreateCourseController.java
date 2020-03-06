package com.group3.AdminAndAuthorization;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group3.BusinessModels.Course;
import com.group3.AdminAndAuthorization.DAO.DAOInjector;
import com.group3.AdminAndAuthorization.DAO.IDAOInjector;
import com.group3.AdminAndAuthorization.Services.IAddCourseService;
import com.group3.AdminAndAuthorization.Services.ICourseInputValidation;
import com.group3.AdminAndAuthorization.Services.IServiceInjector;
import com.group3.AdminAndAuthorization.Services.ServiceInjector;

@Controller
public class CreateCourseController {
	IServiceInjector serviceinjector;
	IDAOInjector daoInjector;

	@RequestMapping("/addCoursePageRequest")
	public String renderCoursePage() {
		return "AddCourse.html";
	}

	@RequestMapping("/addCourse")
	public String addCourse(Course course, Model model) {
		IAddCourseService addCourseService;
		ICourseInputValidation courseInputValidation;
		ArrayList<String> operationFeedback;

		serviceinjector = ServiceInjector.instance();
		daoInjector = DAOInjector.instance();

		addCourseService = serviceinjector.createaddCourseService(daoInjector.createAddCourseDAO());
		courseInputValidation = serviceinjector.createCourseInputValidation();
		operationFeedback = addCourseService.insertCourseDetails(course, courseInputValidation);

		model.addAttribute("operationFeedback", operationFeedback);
		return "AddCourse.html";
	}
}