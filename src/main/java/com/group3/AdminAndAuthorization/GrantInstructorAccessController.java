package com.group3.AdminAndAuthorization;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.group3.BusinessModels.Course;
import com.group3.BusinessModels.GuestModel;
import com.group3.DAO.DAOInjector;
import com.group3.DAO.IDAOInjector;
import com.group3.AdminAndAuthorization.DAO.IGrantInstructorAccessDAO;
import com.group3.AdminAndAuthorization.DAO.IInstructorHandlerDAO;
import com.group3.AdminAndAuthorization.DAO.IUserRoleHandlerDAO;
import com.group3.AdminAndAuthorization.DAO.IViewCoursesDAO;
import com.group3.AdminAndAuthorization.Services.IExtractCourseIdService;
import com.group3.Services.IGrantAccessFieldsValidation;
import com.group3.AdminAndAuthorization.DAO.IGrantInstructorAccessService;
import com.group3.Services.IServiceInjector;
import com.group3.AdminAndAuthorization.Services.IViewCoursesService;
import com.group3.Services.ServiceInjector;
@Controller
public class GrantInstructorAccessController {
	ArrayList<Course> courseList;
	ArrayList<GuestModel> userlist;
	public GrantInstructorAccessController() {
		
		IDAOInjector injector = new DAOInjector();
	   	IViewCoursesDAO iViewCoursesDAO = injector.createViewCourseDAO();
	   	IGrantInstructorAccessDAO iGrantInstructorAccessDAO = injector.createGrantInstructorAccessDAO();
	   	IServiceInjector iServiceInjector = new ServiceInjector();
	   	IViewCoursesService iViewCoursesService = iServiceInjector.createViewCoursesService(iViewCoursesDAO);
	    IGrantInstructorAccessService iGrantInsructorAccessService = iServiceInjector.createGrantInstructorAccessService(iGrantInstructorAccessDAO);
	   	 courseList = iViewCoursesService.getAllCourses();   
	   	 userlist = iGrantInsructorAccessService.returnUserList();
	}
	
	
   @RequestMapping("/grantInstructorPage")
   public String grantInstructorPage(Model model) {
	   
	
   	model.addAttribute("userlist",userlist);
   	model.addAttribute("courseList", courseList);
	return "GrantAccessPage.html";
	   
	   
   }
   @RequestMapping("/GrantRoleRequest")
   public String grantInstructorRole(GuestModel guestmodel,@RequestParam("CourseID") String CourseId,String role,Model model) {
	   guestmodel.setUserRole(role); 
	   System.out.println(guestmodel.getUserRole());
		
	    
		IDAOInjector injector = new DAOInjector();
		IInstructorHandlerDAO iInstructorHandlerDAO = injector.createInstructorHandlerDAO();
		IUserRoleHandlerDAO iUserRoleHandlerDAO = injector.createUserRoleHandlerDAO();
		IServiceInjector iServiceInjector = new ServiceInjector();
		
		IGrantAccessFieldsValidation iGrantAccessFieldsValidation = iServiceInjector.createGrantAccessFieldsValidation(CourseId, role);
		String validationMessage = iGrantAccessFieldsValidation.validateFields();
		if(validationMessage.length() > 0) {
			model.addAttribute("feedbackMessage", validationMessage);
			model.addAttribute("userlist",userlist);
		   	model.addAttribute("courseList", courseList);
			return "GrantAccessPage.html";
		}
		IExtractCourseIdService iExtractCourseIdService = iServiceInjector.createExtractCourseIdService(CourseId);
		CourseId = iExtractCourseIdService.extractCourseId();
		String feebackMessage = iServiceInjector.createAdminPageServices(iInstructorHandlerDAO, iUserRoleHandlerDAO, guestmodel, CourseId).alterUserRole();
	    System.out.println(feebackMessage);
		model.addAttribute("feedbackMessage", feebackMessage);
		
		
	   	model.addAttribute("userlist",userlist);
	   	model.addAttribute("courseList", courseList);
		return "GrantAccessPage.html";
		
	   
	   
   }
}
