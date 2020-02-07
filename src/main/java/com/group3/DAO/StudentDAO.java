package com.group3.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.group3.BusinessModels.Student;
import com.group3.DBConnectivity.ObtainDataBaseConnection;
import com.group3.course.CourseController;
import com.group3.course.TAManager;

public class StudentDAO implements IStudentDAO {
	
	Connection conn;
	String sql;
	private static Logger logger = LogManager.getLogger(StudentDAO.class);
	PreparedStatement statement;
	Student studentDetails;
	
	@Override
	public ArrayList<Student> getAllStudents(){
		ArrayList<Student> rows = new ArrayList<Student>();
		try {
			conn = ObtainDataBaseConnection.obtainDatabaseConnection();
			sql = "SELECT * FROM USER_DATABASE where ROLE = 'Student'";
	        statement = conn.prepareStatement(sql);
	
	        ResultSet result = statement.executeQuery();
	        logger.info("QUERY EXECUTED");
	        while (result.next()) {
	            
	        	logger.info(result.getObject("LAST_NAME"));
	            
	            //items.add(result.getObject("BANNER_ID").toString());
	        	studentDetails = new Student();
	            studentDetails.setLastName(result.getObject("LAST_NAME").toString());
	            studentDetails.setFirstName(result.getObject("FIRST_NAME").toString());
	            studentDetails.setEmail(result.getObject("MAIL_ID").toString());
	            rows.add(studentDetails);
	        }
	        conn.close();
		}
		catch(Exception e) {
			logger.info(e);	
		}
		
		return rows;
	}

	@Override
	public ArrayList<Student> getStudentByMailId(String studentMailId){
		ArrayList<Student> rows = new ArrayList<Student>();		
		try {
			conn = ObtainDataBaseConnection.obtainDatabaseConnection();
			sql = "SELECT * FROM USER_DATABASE where ROLE = 'Student' and MAIL_ID LIKE '%"+studentMailId+"%'";
	        statement = conn.prepareStatement(sql);
	
	        ResultSet result = statement.executeQuery();
	        logger.info("SEARCH STUDENT QUERY EXECUTED");
	        while (result.next()) {
	            
	        	logger.info(result.getObject("LAST_NAME"));
	            
	        	studentDetails = new Student();
	            studentDetails.setLastName(result.getObject("LAST_NAME").toString());
	            studentDetails.setFirstName(result.getObject("FIRST_NAME").toString());
	            studentDetails.setEmail(result.getObject("MAIL_ID").toString());
	            rows.add(studentDetails);
	        }
	        conn.close();
		}
		catch(Exception e) {
			logger.info(e);	
		}
		
		return rows;
	}

	
	public void assignTA(String studentMailId) {
		try {
			conn = ObtainDataBaseConnection.obtainDatabaseConnection();
			
			sql = "insert into COURSE_TA (MAIL_ID,COURSE_ID) values ('"+studentMailId+"','"+CourseController.courseId+"')";
	        statement = conn.prepareStatement(sql);		
	        
	        int result = statement.executeUpdate();
	        System.out.println(result);
	        
	        sql = "update USER_DATABASE SET ROLE = 'TA' where MAIL_ID='"+studentMailId+"'";;
	        statement = conn.prepareStatement(sql);

	        result = statement.executeUpdate();
	        System.out.println(result);
	        
			conn.close();
			
			logger.info("WRITE TO DATABASE SUCCESSFUL!");
			
		}catch (Exception e) {
			logger.info(e);
		}
	}
}
