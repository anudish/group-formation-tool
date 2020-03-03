package com.group3.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.group3.DAO.DAOInjector;
import com.group3.DAO.IDAOInjector;
import com.group3.DAO.ILoginDAO;

@Controller
public class CourseController {
	public static String courseId = "NA", courseName = "NA";
	CourseModel courseModel;
	ArrayList<CourseModel> courseInfo;
	private static Logger logger = LogManager.getLogger(CourseController.class);
	Connection conn;
	ILoginDAO loginDAO;
	PreparedStatement statement;
	ICourseManager courseManager;	
	IDAOInjector daoInjector;
	String role = null;
	
	public CourseController() {
		daoInjector = new DAOInjector();
		courseManager = new CourseManager(daoInjector);
		loginDAO = daoInjector.createLoginDAO();
		
	}
	
	///////////////////////////////////////COURSE SELECTION//////////////////////////////////////////////
		
	//show courses to instructors and TAs
	@RequestMapping("/courseAdmin") //show students with same course
	public ModelAndView getCoursesByEmailId() {
		//get and show courses for TA from database
		
		logger.info("COURSE");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String email = authentication.getName();
		
		String formattedRole = null;
		
		@SuppressWarnings("unchecked")
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) authentication.getAuthorities();
		for (GrantedAuthority authority : authorities) {
		     String role = authority.getAuthority().replace("ROLE_","").toLowerCase();
		     System.out.println("Role formatted: " + role.substring(0, 1).toUpperCase() + role.substring(1));
		     formattedRole = role.substring(0, 1).toUpperCase() + role.substring(1);
		 }

		role = formattedRole;

		ArrayList<CourseModel> rows = new ArrayList<CourseModel>();
		ModelAndView mv = new ModelAndView();
		if(role.equals("Guest")) {
			rows = courseManager.getCoursesForGuest();
			mv.addObject("courseInfo",rows);
			mv.setViewName("showCoursesGuest.html");
		}else if(role.equals("Instructor")){
			rows = courseManager.getCoursesByInstructorMailId(email);
			mv.addObject("courseInfo",rows);
			mv.setViewName("showCourses.html");
		}
		else if(role.equals("Ta") || role.equals("Student")){
			rows = courseManager.getCoursesByTAMailId(email);
			mv.addObject("courseInfo",rows);
			mv.setViewName("showCourses.html");
		}
		
		return mv;

		
	};
	
	@RequestMapping("/selectCourse") //show students with same course
	public ModelAndView getSelectedCourse(@RequestParam String courseId, @RequestParam String courseName) {
		courseModel = new CourseModel();
		courseModel.setCourseId(courseId);
		courseModel.setCourseName(courseName);
		this.courseId = courseId;
		this.courseName = courseName;
		logger.info("SELECT COURSE: "+courseId);

		ModelAndView mv = new ModelAndView();

		if(role.equals("Student")) {
			
			courseModel = new CourseModel();
			courseModel.setCourseId(this.courseId);
			courseModel.setCourseName(this.courseName);
		    mv.addObject("courseInfo",courseModel);
			mv.setViewName("course.html");
			
		}else if(role.equals("Instructor") || role.equals("Ta")) {
	        mv.addObject("courseInfo",courseModel);
	        mv.setViewName("courseAction.html");
	        
		}

	  return mv;
	}
	

	//show course to the students
	@RequestMapping("/course")
	public ModelAndView displayCoursePage() {

		logger.info("COURSE");
		
		ModelAndView mv = new ModelAndView();
		courseModel = new CourseModel();
		courseModel.setCourseId(this.courseId);
		courseModel.setCourseName(this.courseName);
	    mv.addObject("courseInfo",courseModel);
		mv.setViewName("course.html");
		return mv;
	}
	
	//show course to the students
	@RequestMapping("/showGuestcourse")
	public ModelAndView displayGuestCoursePage() {

		logger.info("COURSE");
		
		ModelAndView mv = new ModelAndView();
		courseModel = new CourseModel();
		courseModel.setCourseId(this.courseId);
		courseModel.setCourseName(this.courseName);
	    mv.addObject("courseInfo",courseModel);
		mv.setViewName("showCoursesGuest.html");
		return mv;
	}
	
}
