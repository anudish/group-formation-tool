package com.group3.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.group3.BusinessModels.Student;
import com.group3.DBConnectivity.ObtainDataBaseConnection;
import com.group3.course.TAManager;

public class CourseDAO implements ICourseDAO{

	Connection conn;
	String sql;
	private static Logger logger = LogManager.getLogger(CourseDAO.class);
	PreparedStatement statement;
	
	public ArrayList<String> getEnrolledStudents(String courseId) {
		
		ArrayList<String> current_students = new ArrayList<String>();
		
		//get all currently enrolled students
		try {
			conn = ObtainDataBaseConnection.obtainDatabaseConnection();
			sql = "SELECT * FROM student_enrollments where COURSE_ID='"+courseId+"'";
	        statement = conn.prepareStatement(sql);
	
	        ResultSet result = statement.executeQuery();
	        while (result.next()) {
	            
	        	logger.info(result.getObject("COURSE_ID"));
	            
	        	current_students.add(result.getObject("MAIL_ID").toString());
	        }
	        
 			conn.close();

	        logger.info("GET ENROLLED STUDENTS QUERY EXECUTED");
		}
		catch(Exception e) {
			logger.info(e);	
		}
		return current_students;
		
	}
	
	public void enrollStudentToCourse(Student studentDetails, String courseId) {
		try {
			conn = ObtainDataBaseConnection.obtainDatabaseConnection();
			sql = "insert into student_enrollments (BANNER_ID,MAIL_ID,COURSE_ID) values ('"+studentDetails.getBannerId()+"','"+studentDetails.getEmail()+"','"+courseId+"')";
	        statement = conn.prepareStatement(sql);		
	        int result = statement.executeUpdate();
	        System.out.println(result);
	        
	        //sql = "insert into USER_DATABASE (BANNER_ID,MAIL_ID,FIRST_NAME,LAST_NAME,ROLE) values ('"+bannerId+"','"+mailId+"','"+firstName+"','"+lastName+"','Student')";
	        sql = "insert into USER_DATABASE (MAIL_ID,FIRST_NAME,LAST_NAME,ROLE) values ('"+studentDetails.getEmail()+"','"+studentDetails.getFirstName()+"','"+studentDetails.getLastName()+"','Student')";
	        statement = conn.prepareStatement(sql);
	        result = statement.executeUpdate();
	        System.out.println(result);
	        
	        sql = "insert into AUTHENTICATION_DATABASE (MAIL_ID,PASSWORD) values ('"+studentDetails.getEmail()+"','"+studentDetails.getEncryptedPassword()+"')";
	        statement = conn.prepareStatement(sql);
	        result = statement.executeUpdate();
	        System.out.println(result);
	        
	        conn.close();
	        
	        logger.info("ENROLL STUDENTS QUERY EXECUTED");
		}catch (Exception e) {
			logger.info("Error adding students to database!"+e);
		}
	}
}
