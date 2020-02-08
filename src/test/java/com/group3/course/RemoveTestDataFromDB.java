package com.group3.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.group3.BusinessModels.Student;
import com.group3.DAO.CourseDAO;
import com.group3.DBConnectivity.ObtainDataBaseConnection;


public class RemoveTestDataFromDB {

	Connection conn;
	String sql;
	private static Logger logger = LogManager.getLogger(CourseDAO.class);
	PreparedStatement statement;
	CourseModel courseModel;
	ArrayList<CourseModel> courseInfo;
	
	public void CourseEnrollmentsDAOTest_removeEnrollment(Student student, String courseId) throws Exception {
		//To remove the data that was inserted for testing
		conn = ObtainDataBaseConnection.obtainDatabaseConnection();
		sql = "delete from student_enrollments where MAIL_ID ='"+student.getEmail()+"' and COURSE_ID = '"+courseId+"'";
        statement = conn.prepareStatement(sql);		
        int result = statement.executeUpdate();
        System.out.println(result);
        
        sql = "delete from USER_DATABASE where MAIL_ID ='"+student.getEmail()+"'";
        statement = conn.prepareStatement(sql);
        result = statement.executeUpdate();
        System.out.println(result);
        
        sql = "delete from AUTHENTICATION_DATABASE where MAIL_ID ='"+student.getEmail()+"'";
        statement = conn.prepareStatement(sql);
        result = statement.executeUpdate();
        System.out.println(result);
        conn.close();
	}
	
	public void InstructorDAOTest_removeEnrollment(String instId, String courseId) throws Exception {
		//To remove the data that was inserted for testing
		
		conn = ObtainDataBaseConnection.obtainDatabaseConnection();
		sql = "delete from COURSES where COURSE_ID ='"+courseId+"'";
        statement = conn.prepareStatement(sql);		
        int result = statement.executeUpdate();
        System.out.println("Test Course deleted!");
        
        sql = "delete from ALLOCATE_INSTRUCTOR where MAIL_ID ='"+instId+"'";
        statement = conn.prepareStatement(sql);		
        result = statement.executeUpdate();
        System.out.println("Test Instructor deleted!");	
        conn.close();
	}
	
	public void TADAOTest_removeEnrollment(Student student, String courseId) throws Exception {
		//To remove the data that was inserted for testing
		
		conn = ObtainDataBaseConnection.obtainDatabaseConnection();
		sql = "delete from COURSES where COURSE_ID ='"+courseId+"'";
        statement = conn.prepareStatement(sql);		
        int result = statement.executeUpdate();
        System.out.println("Test Course deleted!");
        
        sql = "delete from student_enrollments where COURSE_ID ='"+courseId+"'";
        statement = conn.prepareStatement(sql);		
        result = statement.executeUpdate();
        System.out.println("Test Instructor deleted!");	        
        conn.close();
	}
	
	public void StudentDAOTest_removeStudent(Student student) throws Exception{
		conn = ObtainDataBaseConnection.obtainDatabaseConnection();
		sql = "delete from USER_DATABASE where MAIL_ID ='"+student.getEmail()+"'";
        statement = conn.prepareStatement(sql);		
        int result = statement.executeUpdate();
        System.out.println("Test Student deleted!");
        conn.close();
		
	}
	
}
