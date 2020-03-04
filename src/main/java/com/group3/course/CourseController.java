package com.group3.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.group3.login.DAO.ILoginDAO;
import com.group3.login.Services.LoginAuthenticationSuccessHandler;

import com.group3.course.Services.ICourseManager;
import com.group3.course.Services.IServiceAbstractFactory;
import com.group3.course.Services.ServiceAbstractFactory;

import com.group3.BusinessModels.Course;

import com.group3.course.DAO.DAOAbstractFactory;
import com.group3.course.DAO.IDAOAbstractFactory;

@Controller
public class CourseController {
	public static String courseId = "NA", courseName = "NA";
	Course courseModel;
	String role = new String();

	private static Logger logger = LogManager.getLogger(CourseController.class);
	Connection conn;
	PreparedStatement statement;

	ILoginDAO loginDAO;
	IDAOAbstractFactory daoInjector;
	com.group3.login.DAO.IDAOInjector loginDAOInjector;
	IServiceAbstractFactory serviceAbstractFactory;
	ICourseManager courseManager;

	public CourseController() {
	
		daoInjector = DAOAbstractFactory.instance();
		serviceAbstractFactory = ServiceAbstractFactory.instance();
		loginDAOInjector = com.group3.login.DAO.DAOInjector.instance();
		courseManager = serviceAbstractFactory.createCourseManager(daoInjector);
		loginDAO = loginDAOInjector.createLoginDAO();
	}

	@RequestMapping("/courseAdmin")
	public ModelAndView getCoursesByEmailId() {

		ArrayList<Course> rows = new ArrayList<Course> ();
		String email = new String();
		email = LoginAuthenticationSuccessHandler.email;
		role = loginDAO.getRoleByEmail(email);

		ModelAndView mv = new ModelAndView();
		if (role.equals("Guest")) {
			rows = courseManager.getCoursesForGuest();
			mv.addObject("courseInfo", rows);
			mv.addObject("questionManager", "hidden");
			mv.setViewName("showCoursesGuest.html");
		} else if (role.equals("Instructor")) {
			rows = courseManager.getCoursesByInstructorMailId(email);
			mv.addObject("courseInfo", rows);
			mv.addObject("questionManager", "visible");
			mv.setViewName("showCourses.html");
		} else if (role.equals("TA") || role.equals("Student")) {
			rows = courseManager.getCoursesByTAMailId(email);
			mv.addObject("courseInfo", rows);
			mv.addObject("questionManager", "hidden");
			mv.setViewName("showCourses.html");
		}
		return mv;
	};

	@RequestMapping("/selectCourse")
	public ModelAndView getSelectedCourse(@RequestParam String courseId, @RequestParam String courseName) {

		courseModel = new Course();
		courseModel.setCourseId(courseId);
		courseModel.setCourseName(courseName);
		this.courseId = courseId;
		this.courseName = courseName;
		logger.info("SELECT COURSE: " + courseId);

		ModelAndView mv = new ModelAndView();
		if (role.equals("Student")) {
			logger.info("Student Logged In");
			courseModel = new Course();
			courseModel.setCourseId(this.courseId);
			courseModel.setCourseName(this.courseName);
			mv.addObject("courseInfo", courseModel);
			mv.setViewName("course.html");

		} else if (role.equals("Instructor") || role.equals("TA")) {
			logger.info("Instructor/TA Logged In!");
			mv.addObject("courseInfo", courseModel);
			mv.setViewName("courseAction.html");
		}
		return mv;
	}

	@RequestMapping("/course")
	public ModelAndView displayCoursePage() {

		ModelAndView mv = new ModelAndView();
		courseModel = new Course();
		courseModel.setCourseId(this.courseId);
		courseModel.setCourseName(this.courseName);
		mv.addObject("courseInfo", courseModel);
		mv.setViewName("course.html");
		return mv;
	}

	@RequestMapping("/showGuestcourse")
	public ModelAndView displayGuestCoursePage() {

		ModelAndView mv = new ModelAndView();
		courseModel = new Course();
		courseModel.setCourseId(this.courseId);
		courseModel.setCourseName(this.courseName);
		mv.addObject("courseInfo", courseModel);
		mv.setViewName("showCoursesGuest.html");
		return mv;
	}
}