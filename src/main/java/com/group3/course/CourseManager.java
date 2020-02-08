package com.group3.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.group3.DAO.ICourseDAO;
import com.group3.DAO.IDAOInjector;
import com.group3.DAO.IInstructorDAO;
import com.group3.DAO.ITADAO;
import com.group3.DBConnectivity.ObtainDataBaseConnection;

public class CourseManager implements ICourseManager {

	Connection conn;
	PreparedStatement statement;
	CourseModel courseModel;
	IDAOInjector daoInjector;
	ICourseDAO courseDAO;
	ITADAO taDAO;
	IInstructorDAO instructorDAO;
	ArrayList<CourseModel> courseInfo;
	
	private static Logger logger = LogManager.getLogger(CourseManager.class);
	
	public CourseManager(IDAOInjector daoInjector) {
		this.daoInjector = daoInjector;
		this.courseDAO = daoInjector.createCourseDAO();
		this.taDAO = daoInjector.createTADAO();
		this.instructorDAO = daoInjector.createInstructorDAO();
	}
	
	@Override
	public ArrayList<CourseModel> getCoursesByTAMailId(String studentMailId) {
		
		courseInfo = new ArrayList<CourseModel>();	
		courseInfo = taDAO.getCoursesByTAMailId(studentMailId);
		return courseInfo;
	}
	
	@Override
	public ArrayList<CourseModel> getCoursesByInstructorMailId(String instructorMailId) {
		courseInfo = new ArrayList<CourseModel>();	
		courseInfo = instructorDAO.getCoursesByInstructorMailId(instructorMailId);
		return courseInfo;
	}

}
