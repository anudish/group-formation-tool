package com.group3.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.group3.BusinessModels.Course;
import com.group3.BusinessModels.Student;
import com.group3.login.DAO.ILoginDAO;

import com.group3.course.DAO.DAOAbstractFactory;
import com.group3.course.DAO.IDAOAbstractFactory;
import com.group3.course.Services.*;

@Controller
public class TAController {
	IServiceAbstractFactory serviceAbstractFactory;
	IDAOAbstractFactory daoInjector;
	com.group3.login.DAO.IDAOAbstractFactory loginDAOInjector;
	ITAManager taManager;
	ICourseManager courseManager;
	ILoginDAO loginDAO;
	Course courseModel;
	Connection conn;
	String sql;
	PreparedStatement statement;

	private static Logger logger = LogManager.getLogger(TAController.class);

	public TAController() {
		daoInjector = DAOAbstractFactory.instance();
		serviceAbstractFactory = ServiceAbstractFactory.instance();
		loginDAOInjector = com.group3.login.DAO.DAOAbstractFactory.instance();
		loginDAO = loginDAOInjector.createLoginDAO();
		taManager = serviceAbstractFactory.createTAManager(daoInjector);
		courseManager = serviceAbstractFactory.createCourseManager(daoInjector);
		courseModel = new Course();
	}

	@RequestMapping("/showAllStudents")
	public ModelAndView getAllStudents() {
		courseModel.setCourseId(CourseController.courseId);
		courseModel.setCourseName(CourseController.courseName);
		logger.info("SHOW ALL STUDENTS");

		ArrayList<Student> rows = taManager.getAllStudents();

		ModelAndView mv = new ModelAndView();
		mv.addObject("studentList", rows);
		mv.addObject("courseInfo", courseModel);
		mv.setViewName("studentList.html");
		return mv;
	}

	@RequestMapping("/searchStudent")
	public ModelAndView searchStudent(@RequestParam String studentMailId) {
		logger.info("SEARCH STUDENT: " + studentMailId);

		ArrayList<Student> rows = taManager.getStudentByMailId(studentMailId);
		logger.info(rows);
		ModelAndView mv = new ModelAndView();
		mv.addObject("studentList", rows);
		mv.addObject("courseInfo", courseModel);
		mv.setViewName("studentList.html");
		return mv;
	}

	@RequestMapping("/addTA")
	public ModelAndView addStudentAsTA(@RequestParam String studentMailId) {
		logger.info("ADD TA: " + studentMailId);

		taManager.addTA(studentMailId);

		logger.info("TAship assigned");
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String email = authentication.getName();

		String role = loginDAO.getRoleByEmail(email);
		ArrayList<Course> rows = new ArrayList<Course>();

		ModelAndView mv = new ModelAndView();
		if (role.equals("Guest")) {
			rows = courseManager.getCoursesForGuest();
			mv.addObject("courseInfo", rows);
			mv.setViewName("showCoursesGuest.html");
		} else if (role.equals("Instructor")) {
			rows = courseManager.getCoursesByInstructorMailId(email);
			mv.addObject("courseInfo", rows);
			mv.setViewName("showCourses.html");
		} else if (role.equals("TA") || role.equals("Student")) {
			rows = courseManager.getCoursesByTAMailId(email);
			mv.addObject("courseInfo", rows);
			mv.setViewName("showCourses.html");
		}

		return mv;
	}
}