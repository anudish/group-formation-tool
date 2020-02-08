package com.group3.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.group3.DBConnectivity.ObtainDataBaseConnection;
import com.group3.course.CourseModel;

public class InstructorDAO implements IInstructorDAO{

	Connection conn;
	String sql;
	private static Logger logger = LogManager.getLogger(CourseDAO.class);
	PreparedStatement statement;
	CourseModel courseModel;
	ArrayList<CourseModel> courseInfo;
	
	@Override
	public ArrayList<CourseModel> getCoursesByInstructorMailId(String instructorMailId) {

		courseInfo = new ArrayList<CourseModel>();
		
		try {
			conn = ObtainDataBaseConnection.obtainDatabaseConnection();
			String sql = "SELECT C.COURSE_ID, C.COURSE_NAME"
					+ " FROM COURSES C"
					+ " JOIN ALLOCATE_INSTRUCTOR A ON A.COURSE_ID=C.COURSE_ID"
					+ " WHERE A.MAIL_ID=\"" + instructorMailId + "\"";
	        statement = conn.prepareStatement(sql);
	        logger.info(sql);
	
	        ResultSet result = statement.executeQuery();
	        courseInfo = new ArrayList<CourseModel>();
	        
	        while (result.next()) {
	            
	        	logger.info(result.getObject("COURSE_ID") + ": "+ result.getObject("COURSE_NAME"));
	        	courseModel = new CourseModel();
	        	courseModel.setCourseId(result.getObject("COURSE_ID").toString());
	            courseModel.setCourseName(result.getObject("COURSE_NAME").toString());
	            courseInfo.add(courseModel);
	        }
	        conn.close();
	        logger.info(courseInfo.isEmpty());
		}catch (Exception e) {
			logger.info(e);
		}
		
		return courseInfo;
	}


}
