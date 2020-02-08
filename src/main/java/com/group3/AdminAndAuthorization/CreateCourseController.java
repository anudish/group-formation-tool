package com.group3.AdminAndAuthorization;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.group3.BusinessModels.Course;
import com.group3.DAO.DAOInjector;
import com.group3.Services.IAddCourseService;
import com.group3.Services.ICourseInputValidation;
import com.group3.Services.IServiceInjector;
import com.group3.Services.ServiceInjector;

@Controller
public class CreateCourseController {
      @RequestMapping("/addCoursePageRequest")
      public String renderCoursePage() {
    	  
		return "AddCourse.html";
    	  
    	  
      }
      //Handling add Course Request
      @RequestMapping("/addCourse")
      public String addCourse(Course course,Model model) {
          //Invoking Service Layer For Course Addition Service
    	  IServiceInjector serviceinjector = new ServiceInjector();
    	  DAOInjector daoinjector = new DAOInjector();
    	 
    	  //Injecting AddCourseDAO dependency
    	  IAddCourseService addCourseService = serviceinjector.createaddCourseService(daoinjector.createAddCourseDAO());
    	  ICourseInputValidation icourseInputValidation = serviceinjector.createCourseInputValidation(); 
    	  ArrayList<String> operationFeedback = addCourseService.insertCourseDetails(course,icourseInputValidation);
    	 
    	  model.addAttribute("operationFeedback", operationFeedback);
    	  return "AddCourse.html";
      }
      
}
