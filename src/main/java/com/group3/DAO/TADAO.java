package com.group3.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.group3.DBConnectivity.ObtainDataBaseConnection;
import com.group3.course.CourseModel;

public class TADAO implements ITADAO{
	
	Connection conn;
	String sql;
	private static Logger logger = LogManager.getLogger(CourseDAO.class);
	PreparedStatement statement;
	CourseModel courseModel;
	ArrayList<CourseModel> courseInfo;
	
	public ArrayList<CourseModel> getCoursesByTAMailId(String studentMailId) {
		courseInfo = new ArrayList<CourseModel>();
		
		try {
			conn = ObtainDataBaseConnection.obtainDatabaseConnection();
			String sql = "SELECT C.COURSE_ID, C.COURSE_NAME"
						+ " FROM COURSES C"
						+ " JOIN student_enrollments S ON S.COURSE_ID=C.COURSE_ID"
						+ " WHERE S.MAIL_ID=\"" + studentMailId + "\"";
			
			logger.info(sql);
	        statement = conn.prepareStatement(sql);
	
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
		}catch (Exception e) {
			logger.info(e);
		}
		
		return courseInfo;
	}

}
