package com.group3.course;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.group3.DAO.DAOInjector;
import com.group3.DAO.IDAOInjector;
import com.group3.DBConnectivity.ObtainDataBaseConnection;

@Controller
public class CourseController {
	public static String courseId = "NA", courseName = "NA";
	CourseModel courseModel;
	ArrayList<CourseModel> courseInfo;
	private static Logger logger = LogManager.getLogger(CourseController.class);
	Connection conn;
	PreparedStatement statement;
	ICourseManager courseManager;	
	IDAOInjector daoInjector;
	
	public CourseController() {
		daoInjector = new DAOInjector();
		courseManager = new CourseManager(daoInjector);
	}
	
	///////////////////////////////////////COURSE SELECTION//////////////////////////////////////////////
	
	//show courses to instructors and TAs
	@RequestMapping("/courseAdmin") //show students with same course
	public ModelAndView getCoursesByEmailId(@RequestParam String emailId) {
		//get and show courses for TA from database
		
		logger.info("COURSE");
		
		ArrayList<CourseModel> rows = new ArrayList<CourseModel>();
		rows = courseManager.getCoursesByInstructorMailId(emailId);
		ModelAndView mv = new ModelAndView();
		//mv.addObject("courseList",rows);
		mv.addObject("courseInfo",rows);
		mv.setViewName("showCourses.html");
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
//        mv.addObject("courseId",courseId);
//        mv.addObject("courseName",courseName);
        mv.addObject("courseInfo",courseModel);
        mv.setViewName("courseAction.html");
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
	
}
