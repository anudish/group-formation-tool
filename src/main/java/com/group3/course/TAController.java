package com.group3.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.group3.BusinessModels.Student;
import com.group3.DAO.DAOInjector;
import com.group3.DAO.IDAOInjector;
import com.group3.DBConnectivity.ObtainDataBaseConnection;

@Controller
public class TAController {

	IDAOInjector daoInjector;
	ITAManager taManager;
	CourseModel courseModel;
	
	Connection conn;
	String sql;

	private static Logger logger = LogManager.getLogger(TAController.class);
	PreparedStatement statement;
	
	public TAController() {
		daoInjector = new DAOInjector();
		taManager = new TAManager(daoInjector);
		courseModel = new CourseModel();
	}
	
	///////////////////////////////////////////TA ASSIGNMENT//////////////////////////////////////////////
	
	//show all the students
	@RequestMapping("/showAllStudents")
	public ModelAndView getAllStudents() {
		courseModel.setCourseId(CourseController.courseId);
		courseModel.setCourseName(CourseController.courseName);
		logger.info("SHOW ALL STUDENTS");

		ArrayList<Student> rows = taManager.getAllStudents();
				
		ModelAndView mv = new ModelAndView();
		mv.addObject("studentList",rows);
		mv.addObject("courseInfo",courseModel);
		mv.setViewName("studentList.html");
		return mv;
	};
	
	//search for a student
		@RequestMapping("/searchStudent")
		public ModelAndView searchStudent(@RequestParam String studentMailId) {
			
			logger.info("SEARCH STUDENT: "+studentMailId);
			
			ArrayList<Student> rows = taManager.getStudentByMailId(studentMailId);
			logger.info(rows);
			ModelAndView mv = new ModelAndView();
			mv.addObject("studentList",rows);
			mv.addObject("courseInfo",courseModel);
			mv.setViewName("studentList.html");
			return mv;
		};
	
	//assign TAship
	@RequestMapping("/addTA")
	public ModelAndView addStudentAsTA(@RequestParam String studentMailId) {
		
		logger.info("ADD TA: "+studentMailId);
		
		taManager.addTA(studentMailId);
		
		logger.info("TAship assigned");
		
		ModelAndView mv = new ModelAndView();
		courseModel = new CourseModel();
		courseModel.setCourseId("Test");
		courseModel.setCourseName("Test");
	    mv.addObject("courseInfo",courseModel);
		mv.setViewName("course.html");
		return mv;
	};
}
