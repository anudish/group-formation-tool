package com.group3.AdminAndAuthorization;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.group3.BusinessModels.Course;
import com.group3.DAO.DAOInjector;
import com.group3.DAO.IDeleteCourseDAO;
import com.group3.DAO.IViewCoursesDAO;
import com.group3.Services.IDeleteCourseService;
import com.group3.Services.IViewCoursesService;
import com.group3.Services.ServiceInjector;

@Controller
public class DeleteCourseController {
	
   @RequestMapping("/DeleteCoursePage")
   public String deleteCoursePage(Model model) {
	 DAOInjector injector = new DAOInjector();
   	 IViewCoursesDAO iViewCoursesDAO = injector.createViewCourseDAO();
   	 IViewCoursesService iViewCoursesService = new ServiceInjector().createViewCoursesService(iViewCoursesDAO);
   	 ArrayList<Course> courseList = iViewCoursesService.getAllCourses();
   	 model.addAttribute("courseList", courseList);
     return "DeleteCoursePage.html";
	   
	   
   }
   
   @RequestMapping("/deleteCourse")
   public String deleteCourseRequest(Course course,Model model) {
	   DAOInjector injector = new DAOInjector();
	   IDeleteCourseDAO iDeleteCourseDAO = injector.createDeleteCourseDAO();
	   IDeleteCourseService iDeleteCourseService = new ServiceInjector().createDeleteCourseService(iDeleteCourseDAO, course);
	   IViewCoursesDAO iViewCoursesDAO = injector.createViewCourseDAO();
	   String feedBackMessage = iDeleteCourseService.deleteCourse();
	   model.addAttribute("feedBackMessage", feedBackMessage);
	   IViewCoursesService iViewCoursesService = new ServiceInjector().createViewCoursesService(iViewCoursesDAO);
	   ArrayList<Course> courseList = iViewCoursesService.getAllCourses();
	   model.addAttribute("courseList", courseList);
	   return "DeleteCoursePage.html";
   }
}
