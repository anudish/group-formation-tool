package com.group3.AdminAndAuthorization;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group3.BusinessModels.Course;
import com.group3.AdminAndAuthorization.DAO.DAOInjector;
import com.group3.AdminAndAuthorization.DAO.IViewCoursesDAO;
import com.group3.AdminAndAuthorization.Services.IViewCoursesService;
import com.group3.AdminAndAuthorization.Services.ServiceInjector;

@Controller
public class ViewCourseController {
    @RequestMapping("/ViewCoursesPage")
    public String viewCoursePage(Model model) {
    	DAOInjector injector = new DAOInjector();
    	IViewCoursesDAO iViewCoursesDAO = injector.createViewCourseDAO();
    	IViewCoursesService iViewCoursesService = new ServiceInjector().createViewCoursesService(iViewCoursesDAO);
    	ArrayList<Course> courseList = iViewCoursesService.getAllCourses();
    	model.addAttribute("courseList", courseList);
    	return "ViewCoursePage.html";
    }
}
